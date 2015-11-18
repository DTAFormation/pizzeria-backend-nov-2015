/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dta.pizzeria.backend.rest;

import dta.pizzeria.backend.entity.Commande;
import dta.pizzeria.backend.metier.CommandeService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CommandeResource {

    @Autowired
    private CommandeService commandeService;

    @RequestMapping(value = "/commande", method = RequestMethod.GET)
    public List<Commande> listCommandes() {
        return commandeService.findAll();
    }

    @RequestMapping(value = "/commande", method = RequestMethod.POST)
    public Commande setCommande(@RequestBody Commande commande) {
        return commandeService.save(commande);
    }

    @RequestMapping(value = "/commandesPretes", method = RequestMethod.GET)
    public List<Commande> listCommandesPretes() {
        return commandeService.findByEtat(Commande.Etat.PREPARE);
    }

    @RequestMapping(value = "/commandesPretesCaisse", method = RequestMethod.GET)
    public List<Commande> listCommandesPretesCaisse() {
        List<Commande> retour = new ArrayList<>();
        List<Commande> enCours = commandeService.findByEtat(Commande.Etat.PREPARE);
        for (Commande commande : enCours) {
            if (!commande.getType().equals(Commande.Type.LIVRAISON)) {
                retour.add(commande);
            }
        }

        return retour;
    }

    @RequestMapping(value = "/commandesPretesLivraison", method = RequestMethod.GET)
    public List<Commande> listCommandesPretesLivraison() {
        List<Commande> retour = new ArrayList<>();
        List<Commande> enCours = commandeService.findByEtat(Commande.Etat.PREPARE);
        for (Commande commande : enCours) {
            if (commande.getType().equals(Commande.Type.LIVRAISON)) {
                retour.add(commande);
            }
        }
        List<Commande> enLivraison = commandeService.findByEtat(Commande.Etat.LIVRAISON);
        for (Commande commande : enLivraison) {
            if (commande.getType().equals(Commande.Type.LIVRAISON)) {
                retour.add(commande);
            }
        }

        return retour;
    }

    @RequestMapping(value = "/commandesEnCours", method = RequestMethod.GET)
    public List<Commande> listCommandesEnCours() {
        return commandeService.findByEtat(Commande.Etat.EN_COURS);
    }

    @RequestMapping(value = "/command", method = RequestMethod.PUT)
    public void updateCommandes(@RequestBody Commande commande) {
        commandeService.save(commande);
    }
}
