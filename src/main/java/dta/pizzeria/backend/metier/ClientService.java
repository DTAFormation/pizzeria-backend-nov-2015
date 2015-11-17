/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dta.pizzeria.backend.metier;

import dta.pizzeria.backend.dao.ClientDao;
import dta.pizzeria.backend.entity.Client;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kk
 */
@Service
public class ClientService {
    @Autowired
    private ClientDao clientDao;

    public List<Client> findAll() {
        return clientDao.findAll();
    }

    public Client findOne(Long id) {
        return clientDao.findOne(id);
    }

    public <S extends Client> S save(S s) {
        return clientDao.save(s);
    }

    public void delete(Long id) {
        clientDao.delete(id);
    }

    public void deleteAll() {
        clientDao.deleteAll();
    }
}
