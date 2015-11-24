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
import dta.pizzeria.backend.entity.Produits;
import dta.pizzeria.backend.metier.IngredientsService;
import dta.pizzeria.backend.metier.ProduitsService;
import org.springframework.transaction.annotation.Transactional;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductResource {

	@Autowired 
	private ProduitsService produitsService;
	
	@Autowired 
	private IngredientsService ingredientsService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Produits> listProduit(){
		return produitsService.listProduits();
	}

	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public void deleteproduct(@PathVariable("id") Long id) {
		 produitsService.removeProduits(id);
	}
	
	@RequestMapping( method = RequestMethod.POST)
	public void addproduct(@RequestBody Produits produit) {
		List<Ingredients> ingredients = produit.getIngredients();
		produit.getIngredients().clear();
                if(produit.getType()==Produits.Type_Produit.PIZZA){
                    produit.setFormat(null);
                    produitsService.setProduits(produit);
                    for(Ingredients ing:ingredients){
                            ingredientsService.updateIngredient(ing);
                            produit.getIngredients().add(ing);
                            ing.getPizzas().add(produit);
                            ingredientsService.updateIngredient(ing);
                    }
                }
		produitsService.setProduits(produit);
	}
	
	@RequestMapping( method = RequestMethod.PUT)
	public void updateproduct(@RequestBody Produits produit) {
		List<Ingredients> ingredients = produit.getIngredients();
		produit.getIngredients().clear();
                if(produit.getType()==Produits.Type_Produit.PIZZA){
                    produit.setFormat(null);
                    produitsService.setProduits(produit);
                    for(Ingredients ing:ingredients){
                            ingredientsService.updateIngredient(ing);
                            produit.getIngredients().add(ing);
                            ing.getPizzas().add(produit);
                            ingredientsService.updateIngredient(ing);
                    }
                }
		produitsService.setProduits(produit);
	}
}
