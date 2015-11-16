package dta.pizzeria.backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dta.pizzeria.backend.entity.Produits;
import dta.pizzeria.backend.metier.ProduitsService;

@RestController
@RequestMapping("/dessert")
public class DessertResource {

	@Autowired private ProduitsService produitsService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Produits> listDesserts() {
		return produitsService.listDesserts();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void setDessert(@ModelAttribute("dessert") Produits dessert){
		produitsService.setProduits(dessert);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void updateDessert(@ModelAttribute("dessert") Produits dessert){
		produitsService.updateProduits(dessert);
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public void removeDessert(@RequestParam long id){
		produitsService.removeProduits(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public Produits getDessert(@RequestParam long id){
		return produitsService.getProduits(id);
	}
}
