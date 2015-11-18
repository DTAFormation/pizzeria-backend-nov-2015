/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dta.pizzeria.backend.dao;

import dta.pizzeria.backend.entity.Commande;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeDao extends JpaRepository<Commande, Long> {
    List<Commande> findByEtat(Commande.Etat etat);
}
