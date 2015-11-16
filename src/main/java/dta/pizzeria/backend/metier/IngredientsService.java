/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dta.pizzeria.backend.metier;

import dta.pizzeria.backend.dao.IngredientsDAO;
import dta.pizzeria.backend.entity.Ingredients;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MHayet
 */
@Service
public class IngredientsService {
    
    @Autowired
    private IngredientsDAO ingredientsDao;
    
    public void setIngredient(Ingredients ingredient){
        ingredientsDao.save(ingredient);
    }
    
    public void updateIngredient(Ingredients ingredient){
        ingredientsDao.save(ingredient);
    }
    
    public Ingredients getIngredient(Long id){
        return ingredientsDao.getOne(id);
    }
    
    public List<Ingredients> listIngredients(){
        return ingredientsDao.findAll();
    }
    
    public void removeIngredient(Long id){
        ingredientsDao.delete(id);
    }
    
    public void removeIngredient(Ingredients ingredient){
        ingredientsDao.delete(ingredient);
    }
    
    public void removeAllIngredient(){
        ingredientsDao.deleteAll();
    }

}
