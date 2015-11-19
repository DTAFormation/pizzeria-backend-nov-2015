/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dta.pizzeria.backend.metier;

import dta.pizzeria.backend.dao.MenuDAO;
import dta.pizzeria.backend.entity.Menu;
import dta.pizzeria.backend.entity.Produits;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MHayet
 */
@Service
public class MenuService {
    
    @Autowired
    private ProduitsService pService;
    
    @Autowired
    private MenuDAO menuDao;
    
    public void setMenu(Menu menu){
        menuDao.save(menu);
    }
    
    @Transactional
    public void updateMenu(Menu menu){
        for (Produits prod:menu.getProduits()){
            pService.updateProduits(prod);
        }
        menuDao.save(menu);
    }
    
    public Menu getMenu(Long id){
        return menuDao.findOne(id);
    }
    
    public List<Menu> listMenu(){
        return menuDao.findAll();
    }
    
    public void removeMenu(Long id){
        menuDao.delete(id);
    }
    
    public void removeMenu(Menu menu){
        menuDao.delete(menu);
    }
    
    public void removeAllMenu(){
        menuDao.deleteAll();
    }

}
