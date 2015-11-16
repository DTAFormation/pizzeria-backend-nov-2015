/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dta.pizzeria.test;

import dta.pizzeria.backend.PizzeriaBackendConfig;
import dta.pizzeria.backend.dao.UtilisateurDao;
import dta.pizzeria.backend.entity.Utilisateur;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author kk
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PizzeriaBackendConfig.class)
public class testServices {
    @Autowired
    private UtilisateurDao utilisateurDao;
    
    @Before
    public void setUp() {
        utilisateurDao.deleteAll();
        
        Utilisateur utilisateur = new Utilisateur(1L, "test", "test", "test", "test", "test", "test", "test", Utilisateur.Type.EMPLOYEE);
        
        utilisateurDao.save(utilisateur);
    }
    
    @Test
    public void testServices() {
        Utilisateur utilisateur = utilisateurDao.findOne(1L);
        Assert.assertEquals("test", utilisateur.getLogin());
    }
}
