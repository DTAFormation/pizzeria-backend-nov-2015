package dta.pizzeria.backend.rest;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dta.pizzeria.backend.entity.Produits;
import dta.pizzeria.backend.metier.ProduitsService;

@RestController
@CrossOrigin
//public class PizzaUniqueResource {
//
//	// TODO : En cours de creation, non fonctionel pour le moment
//	
//	@RequestMapping(value={ "/pizzaUne/{type}", "/pizzaUne" }, method=RequestMethod.GET)
//	public @ResponseBody Produits typedTestBean(
//	    @PathVariable Map<String, String> pathVariables,
//	    @RequestParam("id") String id) {
//
//	    if (pathVariables.containsKey("type")) {
//	        return getPizza(pathVariables.get("type"));
//	    } else {
//	        return null;
//	    }
//	}
//	
//	@Autowired private ProduitsService produitsService;
//
//	@RequestMapping(method = RequestMethod.GET)
//	public Produits getPizza(String id) {
//		return produitsService.getProduits(Long.parseLong(id));
//	}
//	
//	
//}
//
