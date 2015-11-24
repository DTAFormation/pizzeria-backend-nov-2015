/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dta.pizzeria.backend.dao;

import dta.pizzeria.backend.entity.Produits;
import dta.pizzeria.backend.entity.Produits.Type_Produit;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author MHayet
 */
public interface ProduitsDAO extends JpaRepository<Produits, Long>{
    
    List<Produits> findByType(Type_Produit type);
    
}
