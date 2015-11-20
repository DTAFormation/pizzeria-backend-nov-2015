/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dta.pizzeria.backend.metier;

import dta.pizzeria.backend.dao.UtilisateurDao;
import dta.pizzeria.backend.entity.Utilisateur;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kk
 */
@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurDao utilisateurDao;

    public List<Utilisateur> findAll() {
        return utilisateurDao.findAll();
    }

    public Utilisateur findOne(Long id) {
        return utilisateurDao.findOne(id);
    }

    public <S extends Utilisateur> S save(S s) {
        return utilisateurDao.save(s);
    }

    public void delete(Long id) {
        utilisateurDao.delete(id);
    }

    public void deleteAll() {
        utilisateurDao.deleteAll();
    }

    public boolean login(String login, String mdp) {
        return utilisateurDao.findOneByLoginAndMdp(login, mdp)!=null;
    }
    
    
}
