/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dta.pizzeria.backend.rest;

import dta.pizzeria.backend.entity.Produits;
import dta.pizzeria.backend.metier.ProduitsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ETY
 */
@RestController
@RequestMapping("/pizza")
@CrossOrigin
public class PizzaRessource {
    @Autowired private ProduitsService produitsService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Produits> listPizzas() {
		return produitsService.listPizzas();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void setPizza(@ModelAttribute("pizza") Produits pizza){
		produitsService.setProduits(pizza);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void updatePizza(@ModelAttribute("pizza") Produits pizza){
		produitsService.updateProduits(pizza);
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public void removePizza(@RequestParam long id){
		produitsService.removeProduits(id);
	}

	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public Produits getPizza(@RequestParam long id){
		return produitsService.getProduits(id);
	}
}
