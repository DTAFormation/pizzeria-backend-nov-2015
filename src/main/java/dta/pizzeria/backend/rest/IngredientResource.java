package dta.pizzeria.backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dta.pizzeria.backend.entity.Ingredients;
import dta.pizzeria.backend.metier.IngredientsService;



@RestController
@RequestMapping("/ingredient")
@CrossOrigin
public class IngredientResource {

	@Autowired 
	private IngredientsService ingredientsService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Ingredients> listIngredients() {
		return ingredientsService.listIngredients();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public void deleteingredient(@PathVariable("id") Long id) {
		ingredientsService.removeIngredient(id);
	}
	
	@RequestMapping( method = RequestMethod.POST)
	public void addingredient(@RequestBody Ingredients ingredient) {
		ingredientsService.setIngredient(ingredient);
	}
}	
