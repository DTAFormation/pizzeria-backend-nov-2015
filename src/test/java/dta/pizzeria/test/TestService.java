package dta.pizzeria.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dta.pizzeria.backend.PizzeriaBackendConfig;
import dta.pizzeria.backend.entity.Produits;
import dta.pizzeria.backend.metier.ProduitsService;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *
 * @author MHayet
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PizzeriaBackendConfig.class)
@WebAppConfiguration
public class TestService {
    
    @Autowired
    private ProduitsService pService;
    
    @Before
    @Transactional
    public void before() {
        pService.removeAllProduits();
        
        Produits produit1 = new Produits(1L, "Pizza1", 12.5F, Produits.Type_Produit.PIZZA, Produits.Taille.LARGE, null);
        Produits produit2 = new Produits(2L, "Pizza2", 12.5F, Produits.Type_Produit.PIZZA, Produits.Taille.LARGE, null);
        Produits produit3 = new Produits(3L, "Boisson1", 12.5F, Produits.Type_Produit.BOISSON, null, Produits.Format.NORMAL);
        
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
}
