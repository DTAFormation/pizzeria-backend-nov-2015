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
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MHayet
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PizzeriaBackendConfig.class)
@WebAppConfiguration
public class TestServiceMenu {
    
    @Autowired
    private MenuService mService;
    
    @Autowired
    private ProduitsService pService;
    
    @Test
    public void avant() {
        pService.removeAllProduits();
        mService.removeAllMenu();
        
        Produits pizza1 = new Produits("Reina", 12F, "fgsupreme.jpg", Produits.Type_Produit.PIZZA, Produits.Taille.LARGE, null);
        Produits pizza2 = new Produits("Imperia", 15F,"speciale.jpg", Produits.Type_Produit.PIZZA, Produits.Taille.XLARGE, null);
        Produits boisson1 = new Produits("Coca", 2F, "coca.png",Produits.Type_Produit.BOISSON, null, Produits.Format.NORMAL);
        Produits boisson2 = new Produits("Pepsi", 3F, "sprite.png", Produits.Type_Produit.BOISSON, null, Produits.Format.XL);
        Produits dessert1 = new Produits("Eclair au Chocolat", 2F,  "chocolat.png",Produits.Type_Produit.DESSERT, null, null);
        Produits dessert2 = new Produits("Religieuse au Café", 3F, null, Produits.Type_Produit.DESSERT, null, null);

        Menu menu1 = new Menu("PizzaReina", 15F, "Menu digne d'un Roi");
        Menu menu2 = new Menu("PizzaImperia", 20F, "Menu digne d'un Empereur");
        
        pService.setProduits(pizza1);
        pService.setProduits(pizza2);
        pService.setProduits(boisson1);
        pService.setProduits(boisson2);
        pService.setProduits(dessert1);
        pService.setProduits(dessert2);
        mService.setMenu(menu1);
        mService.setMenu(menu2);
        
        List<Produits> produits1 = new ArrayList<>();
        produits1.add(pizza1);
        produits1.add(boisson1);
        produits1.add(dessert1);
        
        List<Produits> produits2 = new ArrayList<>();
        produits1.add(pizza2);
        produits1.add(boisson2);
        produits1.add(dessert2);
        
        List<Menu> m1 = new ArrayList<>();
        m1.add(menu1);
        m1.add(menu2);
        List<Menu> m2 = new ArrayList<>();
        m2.add(menu2);
        
        pizza1.setMenus(m1);
        pizza2.setMenus(m2);
        boisson1.setMenus(m1);
        boisson2.setMenus(m2);
        dessert1.setMenus(m1);
        dessert2.setMenus(m2);
        
        menu1.setProduits(produits1);
        menu1.setProduits(produits2);
        
        pService.updateProduits(pizza1);
        pService.updateProduits(pizza2);
        pService.updateProduits(boisson1);
        pService.updateProduits(boisson2);
        pService.updateProduits(dessert1);
        pService.updateProduits(dessert2);
        mService.updateMenu(menu1); 
        mService.updateMenu(menu2);
    }
    /*
    @Test
    @Transactional
    public void test(){
        List<Menu> menus = mService.listMenu();
        
        Assert.assertEquals("PizzaReina", menus.get(0).getNom());
        Assert.assertEquals("PizzaImperia", menus.get(1).getNom());
        
        Long id = menus.get(1).getId();
        
        Menu menu = mService.getMenu(id);
        
        System.out.println("<====}=0 Menu: "+menu);
                
        if (!menu.getProduits().isEmpty()){
            System.out.println("<====}=0 Pizza: "+menu.getProduits().get(0));
            System.out.println("<====}=0 Boisson: "+menu.getProduits().get(1));
            System.out.println("<====}=0 Dessert: "+menu.getProduits().get(2));
        }else{
            System.out.println("<====}=0 Aucun produits réupérés");
        }
    }
                
    */
}
