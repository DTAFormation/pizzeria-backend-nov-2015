package dta.pizzeria.backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dta.pizzeria.backend.entity.Produits;
import dta.pizzeria.backend.metier.ProduitsService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
//@RequestMapping("/pizza")
@CrossOrigin
public class PizzaResource {

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

//	@RequestMapping(method = RequestMethod.GET, value="/{id}")
//	public Produits getPizza(@RequestParam long id){
//		return produitsService.getProduits(id);
//	}
	
	@RequestMapping(method = RequestMethod.GET, value="/pizza/{id}")
	public Produits getPizza(@PathVariable("id") Long id){
		return produitsService.getProduits(id);
	}
	
}
