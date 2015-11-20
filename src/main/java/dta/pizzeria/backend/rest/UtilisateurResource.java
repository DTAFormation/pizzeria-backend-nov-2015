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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ETY01
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UtilisateurResource {
    
    @Autowired
    UtilisateurService userService;
    
    @RequestMapping(method = RequestMethod.GET )
    public List<Utilisateur> listUsers() {
        return userService.findAll();
    }
    
    @RequestMapping(method = RequestMethod.GET ,value="/{id}")
    public Utilisateur getUser(@PathVariable("id") Long id) {
        return userService.findOne(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void saveUser(@Validated @RequestBody Utilisateur user) {
        userService.save(user);
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public void updateUser(@RequestBody Utilisateur user) {
        userService.save(user);
    }
    
    @RequestMapping(method = RequestMethod.DELETE,value="/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public boolean login(@RequestParam String login,@RequestParam String mdp){
        return userService.login(login, mdp);
    }
}
