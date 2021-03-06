package dta.pizzeria.backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dta.pizzeria.backend.entity.Produits;
import dta.pizzeria.backend.metier.ProduitsService;

@RestController
@RequestMapping("/dessert")
@CrossOrigin
public class DessertResource {

	@Autowired private ProduitsService produitsService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Produits> listDesserts() {
		return produitsService.listDesserts();
	}
}
