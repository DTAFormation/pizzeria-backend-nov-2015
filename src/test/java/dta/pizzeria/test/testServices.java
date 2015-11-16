/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dta.pizzeria.test;

import dta.pizzeria.backend.dao.ClientDao;
import dta.pizzeria.backend.dao.CommandeDao;
import dta.pizzeria.backend.dao.ReservationDao;
import dta.pizzeria.backend.dao.UtilisateurDao;
import dta.pizzeria.backend.entity.Client;
import dta.pizzeria.backend.entity.Commande;
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


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PizzeriaBackendConfigForTest.class)
public class testServices {
    @Autowired
    private UtilisateurDao utilisateurDao;
    
    @Autowired
    private ReservationDao reservationDao;
    
    @Autowired
    private ClientDao clientDao;
    
    @Autowired
    private CommandeDao commandeDao;
    
    private Date dateTest = new Date();
    
    @Before
    public void setUp() {
        reservationDao.deleteAll();
        commandeDao.deleteAll();
        clientDao.deleteAll();
        utilisateurDao.deleteAll();
        
        Utilisateur utilisateur = new Utilisateur(1L, "test", "test", "test", "test", "test", "test", "test", Utilisateur.Type.EMPLOYEE);
        
        utilisateurDao.save(utilisateur);
        
        Client client = new Client(1L, "test", "test", "test", "test", "test", "test", "test");
        clientDao.save(client);
        
        Reservation reservation = new Reservation(1L, dateTest, dateTest);
        reservation.setClient(client);
        client.getReservations().add(reservation);
        reservationDao.save(reservation);
        clientDao.save(client);
        
        Commande commande = new Commande(1L, 10.0F, false, Commande.Type.SUR_PLACE, Commande.Paiement.EN_LIGNE, Commande.Etat.PREPARE);
        commande.setClient(client);
        client.getCommandes().add(commande);
        commandeDao.save(commande);
        clientDao.save(client);
    }
    
    @Test
    public void testUtilisateurService() {
        Utilisateur utilisateur = utilisateurDao.findOne(1L);
        Assert.assertEquals("test", utilisateur.getLogin());
    }
    
    @Test
    public void testClientCommandeReservation(){
        Client client = clientDao.findOne(1L);
        Assert.assertEquals("test", client.getNom());
//        Assert.assertEquals("10.0", ""+client.getCommandes().get(0).getTotal());
//        Assert.assertEquals(dateTest.toString(), ""+client.getReservations().get(0).getDate().toString());
    }
}
