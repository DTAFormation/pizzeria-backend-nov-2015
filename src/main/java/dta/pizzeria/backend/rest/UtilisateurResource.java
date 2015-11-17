/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dta.pizzeria.backend.rest;

import dta.pizzeria.backend.entity.Utilisateur;
import dta.pizzeria.backend.metier.UtilisateurService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ETY01
 */
@RestController
@RequestMapping(value = "/user")
public class UtilisateurResource {
    
    @Autowired UtilisateurService userService;
    
    @RequestMapping(method = RequestMethod.GET ,value="/")
    public List<Utilisateur> listDrinks() {
            return userService.findAll();
    }
}
