/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dta.pizzeria.backend.rest;

import dta.pizzeria.backend.entity.Menu;
import dta.pizzeria.backend.metier.MenuService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author MHayet
 */

@RestController
@CrossOrigin
public class MenuResource {
    
    @Autowired
    private MenuService menuService;
    
    @RequestMapping(path = "/menu", method = RequestMethod.GET)
    public List<Menu> listMenus(){
        return menuService.listMenu();
    }

    @RequestMapping(path = "/menu/{monId}", method = RequestMethod.GET)
    public Menu getMenu(@PathVariable("monId") Long id){
        return menuService.getMenu(id);
    }

}
