/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dta.pizzeria.backend.metier;

import dta.pizzeria.backend.dao.ProduitsDAO;
import dta.pizzeria.backend.entity.Produits;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MHayet
 */
@Service
public class ProduitsService {
    
    @Autowired
    private ProduitsDAO produitsDao;
    
    public void setProduits(Produits produits){
        produitsDao.save(produits);
    }
    
    public void updateProduits(Produits produits){
        produitsDao.save(produits);
    }
    
    public Produits getProduits(Long id){
        return produitsDao.getOne(id);
    }
    
    public List<Produits> listProduits(){
        return produitsDao.findAll();
    }
    
    public List<Produits> listPizzas(){
        //TODO : a optimiser
	List<Produits> prods = listProduits();
        List<Produits> pizzas = new ArrayList<>();
        for (Produits prod:prods){
            if (prod.getType().equals(Produits.Type_Produit.PIZZA)){
                pizzas.add(prod);
            }
        }
        
        return pizzas;
    }
    
    public List<Produits> listBoissons(){
        //TODO : a optimiser
        List<Produits> prods = listProduits();
        List<Produits> boissons= new ArrayList<>();
        for (Produits prod:prods){
            if (prod.getType().equals(Produits.Type_Produit.BOISSON)){
                boissons.add(prod);
            }
        }
        
        return boissons;
    }
    
    public List<Produits> listDesserts(){
        //TODO : a optimiser
        List<Produits> prods = listProduits();
        List<Produits> desserts = new ArrayList<>();
        for (Produits prod:prods){
            if (prod.getType().equals(Produits.Type_Produit.DESSERT)){
                desserts.add(prod);
            }
        }
        
        return desserts;
    }
    
    public void removeProduits(Long id){
        produitsDao.delete(id);
    }
    
    public void removeProduits(Produits produits){
        produitsDao.delete(produits);
    }
    
    public void removeAllProduits(){
        produitsDao.deleteAll();
    }

}
