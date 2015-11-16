/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dta.pizzeria.backend.metier;

import dta.pizzeria.backend.dao.IngredientDAO;
import dta.pizzeria.backend.entity.Ingredient;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MHayet
 */
@Service
public class IngredientService {
    
    @Autowired
    private IngredientDAO ingredientsDao;
    
    public void setIngredient(Ingredient ingredient){
        ingredientsDao.save(ingredient);
    }
    
    public void updateIngredient(Ingredient ingredient){
        ingredientsDao.save(ingredient);
    }
    
    public Ingredient getIngredient(Long id){
        return ingredientsDao.getOne(id);
    }
    
    public List<Ingredient> listIngredients(){
        return ingredientsDao.findAll();
    }
    
    public void removeIngredient(Long id){
        ingredientsDao.delete(id);
    }
    
    public void removeIngredient(Ingredient ingredient){
        ingredientsDao.delete(ingredient);
    }
    
    public void removeAllIngredient(){
        ingredientsDao.deleteAll();
    }

}
