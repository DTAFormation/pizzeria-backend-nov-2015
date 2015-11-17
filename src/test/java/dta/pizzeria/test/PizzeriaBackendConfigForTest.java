/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dta.pizzeria.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("dta.pizzeria.backend")
@EnableJpaRepositories(basePackages = "dta.pizzeria.backend.dao")
public class PizzeriaBackendConfigForTest {
    
    public static void main(String[] args) {
        SpringApplication.run(PizzeriaBackendConfigForTest.class,args);
    }
    
}
