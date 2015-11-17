package dta.pizzeria.backend.metier;

import dta.pizzeria.backend.dao.PersonDao;
import dta.pizzeria.backend.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

	@Autowired private PersonDao personDao;

	public List<Person> listPersons() {
		return personDao.findAll();
	}

}
