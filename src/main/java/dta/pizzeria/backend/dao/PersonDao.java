package dta.pizzeria.backend.dao;

import dta.pizzeria.backend.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDao extends JpaRepository<Person,Long> {

}
