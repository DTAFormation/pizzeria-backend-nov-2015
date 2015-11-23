package dta.pizzeria.backend.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dta.pizzeria.backend.entity.Ingredients;
import dta.pizzeria.backend.entity.Produits;
import dta.pizzeria.backend.metier.IngredientsService;
import dta.pizzeria.backend.metier.ProduitsService;

/**
*
* @author devinez
*/

@RestController
public class DetailsPizzaResource {
	
	//@Autowired private IngredientsService ingredientsService;
	
	//@RequestMapping(path="/pizza/{id}", method=RequestMethod.GET)
	public List<Ingredients> listIngredients(@PathVariable("id") long id){
		
		PizzaResource p = new PizzaResource();
		List<Produits> pizzas = new ArrayList<>();
		pizzas = p.listPizzas(); 
        Produits pizza = pizzas.get(1);
		List<Ingredients> liste = new ArrayList<>();
		
		for (Ingredients i : pizza.getIngredients()) {
			
			liste.add(i);
		} 
		
		return liste;
	}
	
}
  