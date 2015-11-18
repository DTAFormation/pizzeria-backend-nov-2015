package dta.pizzeria.backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dta.pizzeria.backend.entity.Produits;
import dta.pizzeria.backend.metier.ProduitsService;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductResource {

	@Autowired 
	private ProduitsService produitsService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Produits> listProduit(){
		return produitsService.listProduits();
	}

	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public void deleteproduct(@PathVariable("id") Long id) {
		 produitsService.removeProduits(id);
	}
	
	@RequestMapping( method = RequestMethod.POST)
	public void adddproduct(@RequestBody Produits produits) {
		produitsService.setProduits(produits);
	}
	
	@RequestMapping( method = RequestMethod.PUT)
	public void updateproduct(@RequestBody Produits produits) {
		produitsService.updateProduits(produits);
	}
}
