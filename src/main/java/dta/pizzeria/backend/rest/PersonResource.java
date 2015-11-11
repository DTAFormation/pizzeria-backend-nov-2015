package dta.pizzeria.backend.rest;

import dta.pizzeria.backend.entity.Person;
import dta.pizzeria.backend.metier.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonResource {

    @Autowired private PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Person> listPersons() {
        return personService.listPersons();
    }
}
