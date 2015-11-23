package dta.pizzeria.test;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dta.pizzeria.backend.PizzeriaBackendConfig;
import dta.pizzeria.backend.entity.Ingredients;
import dta.pizzeria.backend.entity.Produits;
import dta.pizzeria.backend.metier.IngredientsService;
import dta.pizzeria.backend.metier.ProduitsService;

/**
 *
 * @author MHayet
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PizzeriaBackendConfig.class)
@WebAppConfiguration
public class TestDetailsPizza {
    
    @Autowired
    private ProduitsService pService;
    @Autowired
    private IngredientsService iService;
    
    @Before
    @Transactional
    public void before() {
        pService.removeAllProduits();
        iService.removeAllIngredient();
        
        Produits produit1 = new Produits("Margarita", 12.5F, "torti.jpg", Produits.Type_Produit.PIZZA, Produits.Taille.LARGE, null);
        Produits produit2 = new Produits("Reine", 13.5F, "provencale.jpg", Produits.Type_Produit.PIZZA, Produits.Taille.LARGE, null);
        Produits produit3 = new Produits("Boisson1", 14.5F, "http://dtaformation.github.io/pizzeria-web-image-nov-2015/boisson.jpg", Produits.Type_Produit.BOISSON, null, Produits.Format.NORMAL);       
        
        
        Ingredients ingredient1 = new Ingredients("mozza");
        Ingredients ingredient2 = new Ingredients("jambon");
        Ingredients ingredient3 = new Ingredients("champi");
        
        iService.setIngredient(ingredient1);
        iService.setIngredient(ingredient2);
        iService.setIngredient(ingredient3);
        
        List<Ingredients> listIn1 = new ArrayList<>();
        listIn1.add(ingredient1);
        listIn1.add(ingredient2);
        produit1.setIngredients(listIn1);
        
        List<Ingredients> listIn2 = new ArrayList<>();
        listIn2.add(ingredient1);
        listIn2.add(ingredient2);
        listIn2.add(ingredient3);
        produit2.setIngredients(listIn2);
        
        pService.setProduits(produit1);
        pService.setProduits(produit2);
        pService.setProduits(produit3);
        
    }

    @Test
    public void testListPizza() {
        List<Produits> prods = pService.listProduits();
        List<Produits> pizzas = pService.listPizzas();
        for (Produits prod:prods){
            System.out.println("<====}=0 "+prod.getType());
        }
        for (Produits prod:pizzas){
            System.out.println("<====}=0 "+prod.getType());
        }
    }
    
    @Test
    @Transactional
    public void testPizza() {
        List<Produits> pizzas = pService.listPizzas();
        Produits pizza = pizzas.get(0);
        System.out.println("<====}=0 "+pizza.getNom());
        System.out.println("<====}=0 "+pizza.getIngredients());
        for(Ingredients i : pizza.getIngredients()) {
        	System.out.println("<====}=0 Ingredient : "+i.getNom());
        }
    }
}
