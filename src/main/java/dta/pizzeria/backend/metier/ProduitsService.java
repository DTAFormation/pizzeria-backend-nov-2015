/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dta.pizzeria.backend.metier;

import dta.pizzeria.backend.dao.ProduitsDAO;
import dta.pizzeria.backend.entity.Ingredients;
import dta.pizzeria.backend.entity.Produits;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MHayet
 */
@Service
public class ProduitsService {
    
    @Autowired
    private ProduitsDAO produitsDao;
    
    @Autowired
    private IngredientsService ingredientsService;
    
    @Transactional
    public Produits setProduits(Produits produit) {
        
        List<Ingredients> ingredients = new ArrayList<>();
        ingredients.addAll(produit.getIngredients());
        
        produit.getIngredients().clear();
        
        //Si produit est une pizza
        if (produit.getType() == Produits.Type_Produit.PIZZA) {
            
            //Met Format à null
            produit.setFormat(null);
            
            //Enregistrement de la pizza
            produitsDao.save(produit);
            
            for (Ingredients ing : ingredients) {
                
                //Update des ingredients
                ingredientsService.updateIngredient(ing);
                
                //Rajout des pizza dans ingredients
                ing.getPizzas().add(produit);
                ingredientsService.updateIngredient(ing);
                
                //Rajout de l'ingredient dans pizza
                produit.getIngredients().add(ing);
            }
        }
        
        //Si le produit est une boisson
        if (produit.getType() == Produits.Type_Produit.BOISSON) {
            
            produitsDao.save(produit);
            //Met Taille à null
            produit.setTaille(null);
        }
        
        
        //Si le produit est un desset
        if (produit.getType() == Produits.Type_Produit.DESSERT) {
            
            produitsDao.save(produit);
            //Met Format et Taille à null
            produit.setFormat(null);
            produit.setTaille(null);
        }
            
        
        //Enregistrement du produit
            return produitsDao.save(produit);

    }
    
    public Produits updateProduits(Produits produit){
       return setProduits(produit);
       
    }
    
    public Produits getProduits(Long id){
        return produitsDao.getOne(id);
    }
    
    public List<Produits> listProduits(){
        return produitsDao.findAll();
    }
    
    public List<Produits> listPizzas(){
//        //TODO : a optimiser
//    	List<Produits> prods = listProduits();
//        List<Produits> pizzas = new ArrayList<>();
//        for (Produits prod:prods){
//            if (prod.getType().equals(Produits.Type_Produit.PIZZA)){
//                pizzas.add(prod);
//            }
//        }
//        
//        return pizzas;
        
                return produitsDao.findByType(Produits.Type_Produit.PIZZA);
    }
    
    public List<Produits> listBoissons(){
//        //TODO : a optimiser
//        List<Produits> prods = listProduits();
//        List<Produits> boissons= new ArrayList<>();
//        for (Produits prod:prods){
//            if (prod.getType().equals(Produits.Type_Produit.BOISSON)){
//                boissons.add(prod);
//            }
//        }
//      return boissons;       
        
        return produitsDao.findByType(Produits.Type_Produit.BOISSON);
        
    }
    
    public List<Produits> listDesserts(){
//        //TODO : a optimiser
//        List<Produits> prods = listProduits();
//        List<Produits> desserts = new ArrayList<>();
//        for (Produits prod:prods){
//            if (prod.getType().equals(Produits.Type_Produit.DESSERT)){
//                desserts.add(prod);
//            }
//        }
//        
//        return desserts;
        
       return produitsDao.findByType(Produits.Type_Produit.DESSERT); 
        
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
