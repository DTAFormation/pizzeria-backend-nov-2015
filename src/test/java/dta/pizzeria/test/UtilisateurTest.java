/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dta.pizzeria.test;

import dta.pizzeria.backend.PizzeriaBackendConfig;
import dta.pizzeria.backend.entity.Utilisateur;
import dta.pizzeria.backend.metier.UtilisateurService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *
 * @author ETY01
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PizzeriaBackendConfig.class)
@WebAppConfiguration
public class UtilisateurTest {
    @Autowired
    private UtilisateurService userService;
    
    @Test
    public void mainTest() {
        System.out.println(">>===findAll===>"+userService.findAll());
        System.out.println(">>===findOne===>"+userService.findOne(1L));
    }
    
    @Test
    public void testLogin(){
        System.out.println(">>===Login===>"+ userService.login("login1", "motdepasse"));
    }
    
    @Before
    public void setUp() {
        userService.deleteAll();
        Utilisateur u1=new Utilisateur(1L,"login1", "motdepasse", "nom", "prenom", "mail", "adresse", "0123456789", Utilisateur.Type.EMPLOYEE.EMPLOYEE);
        Utilisateur u2=new Utilisateur(2L,"login2", "motdepasse", "nom", "prenom", "mail", "adresse", "tel", Utilisateur.Type.EMPLOYEE.ADMINISTRATEUR);
        
        userService.save(u1);
        userService.save(u2);

    }
    
}
