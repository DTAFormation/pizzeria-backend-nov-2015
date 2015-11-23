package dta.pizzeria.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dta.pizzeria.backend.PizzeriaBackendConfig;
import dta.pizzeria.backend.entity.Client;
import dta.pizzeria.backend.entity.Produits;
import dta.pizzeria.backend.metier.ClientService;
import dta.pizzeria.backend.metier.CommandeService;

import dta.pizzeria.backend.entity.Utilisateur;
import dta.pizzeria.backend.metier.ProduitsService;
import dta.pizzeria.backend.metier.UtilisateurService;
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
    
    @Autowired
    private ClientService cservice;
    @Autowired
    private CommandeService cs;
    
    @Before
    @Transactional
    public void before() {
        pService.removeAllProduits();
        
        Produits produit1 = new Produits(1L, "Extravaganza", 12.5F, "primavera.jpg", Produits.Type_Produit.PIZZA, Produits.Taille.LARGE, null);
        pService.setProduits(new Produits(2L, "Bacon Groovy", 12.5F, "gourmande.jpg",Produits.Type_Produit.PIZZA, Produits.Taille.LARGE, null));
        pService.setProduits(new Produits(6L, "Bacon Groovy", 15F, "gourmande.jpg",Produits.Type_Produit.PIZZA, Produits.Taille.XLARGE, null));
        Produits produit2 = new Produits(3L, "Savoyarde", 12.5F, "pizzachef.jpg",Produits.Type_Produit.PIZZA, Produits.Taille.LARGE, null);
        Produits produit3 = new Produits(4L, "Whisky", 12.5F, "coca.png",Produits.Type_Produit.BOISSON, null, Produits.Format.NORMAL);
        pService.setProduits(new Produits(7L, "White Russian", 25F, "fanta.png",Produits.Type_Produit.BOISSON, null, Produits.Format.XL));
        pService.setProduits(new Produits(5L, "White Russian", 12.5F, "fanta.png", Produits.Type_Produit.BOISSON, null, Produits.Format.NORMAL));
        
        pService.setProduits(produit1);
        pService.setProduits(produit2);
        pService.setProduits(produit3);
        
        cservice.save(new Client(1L, "Winchester", "Dean", "oz@chatte.com", "8 bd kk", "054554545", "DeanChester", "mdp"));
        
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
