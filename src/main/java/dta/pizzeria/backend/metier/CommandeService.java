/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dta.pizzeria.backend.metier;

import dta.pizzeria.backend.dao.CommandeDao;
import dta.pizzeria.backend.entity.Commande;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kk
 */
@Service
public class CommandeService {
    @Autowired
    private CommandeDao commandDao;

    public List<Commande> findAll() {
        return commandDao.findAll();
    }

    public Commande getOne(Long id) {
        return commandDao.getOne(id);
    }

    public <S extends Commande> S save(S s) {
        return commandDao.save(s);
    }

    public void delete(Long id) {
        commandDao.delete(id);
    }

    public void deleteAll() {
        commandDao.deleteAll();
    }
    
    public List<Commande> findAllPretes() {
        List<Commande> commandesPretes = new ArrayList<Commande>();
        List<Commande> commandes = commandDao.findAll();
        
        for(Commande commande:commandes){
            if(commande.getEtat().equals(Commande.Etat.PREPARE))
                commandesPretes.add(commande);
        }
        return commandesPretes;
    }
}
