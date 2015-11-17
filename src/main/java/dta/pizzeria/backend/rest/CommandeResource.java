/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dta.pizzeria.backend.rest;

import dta.pizzeria.backend.entity.Commande;
import dta.pizzeria.backend.metier.CommandeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CommandeResource {
    @Autowired
    private CommandeService commandeService;
    
    @RequestMapping(name="/commandesPretes", method = RequestMethod.GET)
    public List<Commande> listCommandes() {
        return commandeService.findAllPretes();
    }
    
}
