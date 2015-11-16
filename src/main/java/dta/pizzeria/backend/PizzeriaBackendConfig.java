package dta.pizzeria.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan("dta.pizzeria.backend")
@EnableJpaRepositories(basePackages = "dta.pizzeria.backend.dao")
public class PizzeriaBackendConfig {

    public static void main(String[] args) {
        SpringApplication.run(PizzeriaBackendConfig.class,args);
    }

}
