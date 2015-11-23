/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dta.pizzeria.test;

import dta.pizzeria.backend.PizzeriaBackendConfig;
import dta.pizzeria.backend.dao.ClientDao;
import dta.pizzeria.backend.dao.CommandeDao;
import dta.pizzeria.backend.dao.IngredientsDAO;
import dta.pizzeria.backend.dao.MenuDAO;
import dta.pizzeria.backend.dao.ProduitsDAO;
import dta.pizzeria.backend.dao.ReservationDao;
import dta.pizzeria.backend.dao.UtilisateurDao;
import dta.pizzeria.backend.entity.Client;
import dta.pizzeria.backend.entity.Commande;
import dta.pizzeria.backend.entity.Menu;
import dta.pizzeria.backend.entity.Produits;
import dta.pizzeria.backend.entity.Reservation;
import dta.pizzeria.backend.entity.Utilisateur;
import java.util.Date;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PizzeriaBackendConfig.class)
@WebAppConfiguration
public class testServices {

    @Autowired
    private UtilisateurDao utilisateurDao;
    
    @Autowired
    private ReservationDao reservationDao;
    
    @Autowired
    private ClientDao clientDao;
    
    @Autowired
    private CommandeDao commandeDao;
    
    @Autowired
    private IngredientsDAO ingredientsDao;
    
    @Autowired
    private ProduitsDAO produitsDao;
    
    @Autowired
    private MenuDAO menuDao;
    
    private Date dateTest = new Date();
    
    @Before
    public void setUp() {
        reservationDao.deleteAll();
        commandeDao.deleteAll();
        
        utilisateurDao.deleteAll();
        produitsDao.deleteAll();
        menuDao.deleteAll();
        
        ingredientsDao.deleteAll();
        clientDao.deleteAll();
        
        //On cree un utilisateur
        Utilisateur utilisateur = new Utilisateur("test", "test", "test", "test", "test", "test", "test", Utilisateur.Type.EMPLOYEE);
        utilisateurDao.save(utilisateur);
        
        //On cree un client
        Client client = new Client("test", "test", "test", "test", "test", "test", "test");
        clientDao.save(client);
        
        //On cree une reservation
        Reservation reservation = new Reservation(dateTest, dateTest);
        reservation.setClient(client);
        client.getReservations().add(reservation);
        reservationDao.save(reservation);
        clientDao.save(client);
        
        //On cree 3 produits
        Produits pizza = new Produits("Pizza Tartiflette", 5.60F, "fgsupreme.jpg", Produits.Type_Produit.PIZZA, Produits.Taille.MOYEN, null);
        produitsDao.save(pizza);
        Produits boisson = new Produits("Coca Cola", 2.5F, "fgsupreme.jpg", Produits.Type_Produit.BOISSON, null, Produits.Format.NORMAL);
        produitsDao.save(boisson);
        Produits dessert = new Produits("Fondant au chocolat", 2F, "fgsupreme.jpg", Produits.Type_Produit.DESSERT, null, null);
        produitsDao.save(dessert);
        
        //On cree un menu
        Menu menu = new Menu("Tartiflette", 8.75F, "Menu réservé aux fans des soirées d'hiver");
        menuDao.save(menu);
        
        dessert.getMenus().add(menu);
        menu.getProduits().add(dessert);
        boisson.getMenus().add(menu);
        menu.getProduits().add(boisson);
        pizza.getMenus().add(menu);
        menu.getProduits().add(pizza);
        produitsDao.save(dessert);
        produitsDao.save(boisson);
        produitsDao.save(pizza);
        menuDao.save(menu);
        
        //On cree une commande
        Commande commande = new Commande(menu.getPrix()+pizza.getPrix(), false, Commande.Type.SUR_PLACE, Commande.Paiement.EN_LIGNE, Commande.Etat.PREPARE);
        commande.setClient(client);
        client.getCommandes().add(commande);
        
        commande.getMenus().add(menu);
        menu.getCommandes().add(commande);
        
        commande.getProduits().add(pizza);
        pizza.getCommandes().add(commande);
        
        produitsDao.save(pizza);
        menuDao.save(menu);
        commandeDao.save(commande);
        clientDao.save(client);
        
        
    }
    
    @Test
    public void testUtilisateurService() {
        Utilisateur utilisateur = utilisateurDao.findAll().get(0);
        Assert.assertEquals("test", utilisateur.getLogin());
    }
    
    @Test
    public void testClientCommandeReservation(){
        Client client = clientDao.findAll().get(0);
        Assert.assertEquals("test", client.getNom());
//        Assert.assertEquals("10.0", ""+client.getCommandes().get(0).getTotal());
//        Assert.assertEquals(dateTest.toString(), ""+client.getReservations().get(0).getDate().toString());
    }
}
