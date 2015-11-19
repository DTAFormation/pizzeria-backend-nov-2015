/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dta.pizzeria.backend.metier;

import dta.pizzeria.backend.dao.CommandeDao;
import dta.pizzeria.backend.entity.Commande;

import dta.pizzeria.backend.entity.Produits;

import java.util.ArrayList;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author kk
 */
@Service
public class CommandeService {
    @Autowired
    private CommandeDao commandDao;
    @Autowired
    private ProduitsService ps;

    public List<Commande> findAll() {
        return commandDao.findAll();
    }

    public Commande getOne(Long id) {
        return commandDao.getOne(id);
    }

    @Transactional
    public <S extends Commande> S save(S s) {
        
        for (Produits p : s.getProduits()) {
            
            p = ps.updateProduits(p);
            System.err.println("PRODUIT : " + p);
        }

        return commandDao.save(s);
    }

    public void delete(Long id) {
        commandDao.delete(id);
    }

    public void deleteAll() {
        commandDao.deleteAll();
    }
    
//    public List<Commande> findAllPretes() {
//        List<Commande> commandesPretes = new ArrayList<Commande>();
//        List<Commande> commandes = commandDao.findAll();
//        
//        for(Commande commande:commandes){
//            if(commande.getEtat().equals(Commande.Etat.PREPARE))
//                commandesPretes.add(commande);
//        }
//        return commandesPretes;
//    }

    public List<Commande> findByEtat(Commande.Etat etat) {
        return commandDao.findByEtat(etat);
    }
}
