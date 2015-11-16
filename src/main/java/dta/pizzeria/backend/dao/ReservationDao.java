/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dta.pizzeria.backend.dao;

import dta.pizzeria.backend.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author kk
 */
public interface ReservationDao extends JpaRepository<Reservation, Long>{
    
}
