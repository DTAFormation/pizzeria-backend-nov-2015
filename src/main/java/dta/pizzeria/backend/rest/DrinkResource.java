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
@RequestMapping("/drink")
public class DrinkResource {

	@Autowired private ProduitsService produitsService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Produits> listDrinks() {
		return produitsService.listBoissons();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void setBoisson(@ModelAttribute("drink") Produits drink){
		produitsService.setProduits(drink);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void updateDrink(@ModelAttribute("drink") Produits drink){
		produitsService.updateProduits(drink);
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public void removeDrink(@RequestParam long id){
		produitsService.removeProduits(id);
	}

	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public Produits getDrink(@RequestParam long id){
		return produitsService.getProduits(id);
	}

}
