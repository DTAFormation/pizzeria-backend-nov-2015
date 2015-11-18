/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dta.pizzeria.test;

import dta.pizzeria.backend.PizzeriaBackendConfig;
import dta.pizzeria.backend.entity.Menu;
import dta.pizzeria.backend.metier.MenuService;
import java.util.List;
import javax.transaction.Transactional;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 *
 * @author Nemesis
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PizzeriaBackendConfig.class)
@WebAppConfiguration
public class TestServiceMenu {
    
    @Autowired
    private MenuService mService;
    
    @Before
    @Transactional
    public void avant() {
        mService.removeAllMenu();
        
        Menu menu1 = new Menu(1L, "PizzaPresta", 12.5F);
        Menu menu2 = new Menu(2L, "PizzaReina", 15F);
        Menu menu3 = new Menu(3L, "PizzaImperia", 20F);
        
        mService.setMenu(menu1);
        mService.setMenu(menu2);
        mService.setMenu(menu3);        
    }
    @Test
    public void test(){
        List<Menu> menus = mService.listMenu();
        
        Assert.assertEquals("PizzaPresta", menus.get(0).getNom());
        Assert.assertEquals("PizzaReina", menus.get(1).getNom());
        Assert.assertEquals("PizzaImperia", menus.get(2).getNom());
    }
    
}
