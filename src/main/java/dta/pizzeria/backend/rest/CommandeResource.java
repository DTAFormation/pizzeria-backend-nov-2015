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

/***
 * 
 * @author Hantaro
 *
 */

@RestController
@RequestMapping("/command")
@CrossOrigin
public class CommandeResource {

    @Autowired
    private CommandeService commandeService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Commande> listCommandes() {
        return commandeService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void setCommande(@RequestBody Commande commande) {
        commandeService.save(commande);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public void updateCommandes(@RequestBody Commande commande) {
        commandeService.save(commande);
    }

    @RequestMapping(value = "/pretes", method = RequestMethod.GET)
    public List<Commande> listCommandesPretes() {
        return commandeService.findByEtat(Commande.Etat.PREPARE);
    }

    @RequestMapping(value = "/pretes/caisse", method = RequestMethod.GET)
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

    @RequestMapping(value = "/pretes/livraison", method = RequestMethod.GET)
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
        System.err.println("RETOUR LOL" + retour.get(0).getType());
        return retour;
    }

    @RequestMapping(value = "/enCours", method = RequestMethod.GET)
    public List<Commande> listCommandesEnCours() {
        return commandeService.findByEtat(Commande.Etat.EN_COURS);
    }
}
