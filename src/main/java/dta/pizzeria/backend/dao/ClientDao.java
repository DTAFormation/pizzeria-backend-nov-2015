/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dta.pizzeria.backend.dao;

import dta.pizzeria.backend.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Vincent
 */
public interface ClientDao extends JpaRepository<Client, Long>{
    Client findByNomAndPrenom(String nom, String prenom);
}
