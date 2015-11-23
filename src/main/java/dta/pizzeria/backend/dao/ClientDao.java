/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dta.pizzeria.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import dta.pizzeria.backend.entity.Client;

/**
 *
 * @author Vincent
 */
public interface ClientDao extends JpaRepository<Client, Long>{

    Client findByNomAndPrenom(String nom, String prenom);
    Client findByLoginOrMail(String login, String mail);
    Client findByLoginAndMdp(String login, String mdp);
	

}
