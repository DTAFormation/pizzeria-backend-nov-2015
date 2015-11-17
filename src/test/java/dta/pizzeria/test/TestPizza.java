package dta.pizzeria.test;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import dta.pizzeria.backend.PizzeriaBackendConfig;
import dta.pizzeria.backend.entity.Produits;
import dta.pizzeria.backend.metier.ProduitsService;
import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PizzeriaBackendConfig.class)
@WebAppConfiguration
public class TestPizza {

	@Autowired
	private ProduitsService pService;

	// copy of TestService
	@Before
	@Transactional
	public void before() {
		pService.removeAllProduits();

//		Produits produit1 = new Produits(1L, "Pizza1", 12.5F, Produits.Type_Produit.PIZZA, Produits.Taille.LARGE, null);
//		Produits produit2 = new Produits(2L, "Pizza2", 12.5F, Produits.Type_Produit.PIZZA, Produits.Taille.LARGE, null);
//		Produits produit3 = new Produits(3L, "Boisson1", 12.5F, Produits.Type_Produit.BOISSON, null,
//				Produits.Format.NORMAL);
//
//		pService.setProduits(produit1);
//		pService.setProduits(produit2);
//		pService.setProduits(produit3);

	}
	
//    @Test
//    public void testListPizza() {
//        List<Produits> pizzas = pService.listPizzas();
//        Assert.assertTrue(Produits.Type_Produit.PIZZA.equals(pizzas.get(0).getType()));
//        Assert.assertTrue(Produits.Type_Produit.PIZZA.equals(pizzas.get(1).getType()));
//        List<Produits> prods = pService.listProduits();
//        Assert.assertTrue(Produits.Type_Produit.PIZZA.equals(prods.get(0).getType()));
//        Assert.assertTrue(Produits.Type_Produit.PIZZA.equals(prods.get(1).getType()));
//        Assert.assertFalse(Produits.Type_Produit.PIZZA.equals(prods.get(2).getType()));
//    }

}
