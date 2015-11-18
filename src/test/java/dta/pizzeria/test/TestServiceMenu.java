/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dta.pizzeria.test;

import dta.pizzeria.backend.PizzeriaBackendConfig;
import dta.pizzeria.backend.entity.Menu;
import dta.pizzeria.backend.entity.Produits;
import dta.pizzeria.backend.metier.MenuService;
import dta.pizzeria.backend.metier.ProduitsService;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *
 * @author Nemesis
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PizzeriaBackendConfig.class)
@WebAppConfiguration
public class TestServiceMenu {
    
    @Autowired
    private MenuService mService;
    
    @Autowired
    private ProduitsService pService;
    
    @Before
    @Transactional
    public void avant() {
        pService.removeAllProduits();
        mService.removeAllMenu();
        
        Produits pizza1 = new Produits(1L, "Reina", 12F, Produits.Type_Produit.PIZZA, Produits.Taille.LARGE, null);
        Produits pizza2 = new Produits(2L, "Imperiaa", 15F, Produits.Type_Produit.PIZZA, Produits.Taille.XLARGE, null);
        Produits boisson1 = new Produits(3L, "Coca", 12F, Produits.Type_Produit.BOISSON, null, Produits.Format.NORMAL);
        Produits boisson2 = new Produits(4L, "Pepsi", 12F, Produits.Type_Produit.BOISSON, null, Produits.Format.XL);
        Produits dessert1 = new Produits(5L, "Eclair au Chocolat", 12F, Produits.Type_Produit.DESSERT, null, null);
        Produits dessert2 = new Produits(6L, "Religieuse au Café", 12F, Produits.Type_Produit.DESSERT, null, null);
        
        pService.setProduits(pizza1);
        pService.setProduits(pizza2);
        pService.setProduits(boisson1);
        pService.setProduits(boisson2);
        pService.setProduits(dessert1);
        pService.setProduits(dessert2);
        
        List<Produits> produits1 = new ArrayList<>();
        produits1.add(pizza1);
        produits1.add(boisson1);
        produits1.add(dessert1);
        
        List<Produits> produits2 = new ArrayList<>();
        produits1.add(pizza2);
        produits1.add(boisson2);
        produits1.add(dessert2);
        Menu menu1 = new Menu(2L, "PizzaReina", 15F);
        menu1.setProduits(produits1);
        Menu menu2 = new Menu(3L, "PizzaImperia", 20F);
        menu1.setProduits(produits2);
        
        mService.setMenu(menu1);
        mService.setMenu(menu2);
    }
    
    @Test
    public void test(){
        List<Menu> menus = mService.listMenu();
        
        Assert.assertEquals("PizzaReina", menus.get(0).getNom());
        Assert.assertEquals("PizzaImperia", menus.get(1).getNom());
    }
    
}
