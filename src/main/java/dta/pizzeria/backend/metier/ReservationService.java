/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dta.pizzeria.backend.metier;

import dta.pizzeria.backend.dao.ReservationDao;
import dta.pizzeria.backend.entity.Reservation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kk
 */
@Service
public class ReservationService {
    @Autowired
    private ReservationDao reservationDao;

    public List<Reservation> findAll() {
        return reservationDao.findAll();
    }

    public Reservation getOne(Long id) {
        return reservationDao.getOne(id);
    }

    public <S extends Reservation> S save(S s) {
        return reservationDao.save(s);
    }

    public void delete(Long id) {
        reservationDao.delete(id);
    }

    public void deleteAll() {
        reservationDao.deleteAll();
    }
    
}
