package dta.pizzeria.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import dta.pizzeria.backend.PizzeriaBackendConfig;
import dta.pizzeria.backend.entity.Client;
import dta.pizzeria.backend.metier.ClientService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PizzeriaBackendConfig.class)
@WebAppConfiguration
public class TestClient {

	  
    @Autowired
    private ClientService clientService;
    
    @Before
    @Transactional
    public void before() {
    	clientService.deleteAll();
        
    	Client client1 = new Client("jean", "jacques", "jj@jj.com", "2 rue de JJ", "1234567890", "jj", "jj");
        
    	clientService.save(client1);
    }

    @Test
    public void testClientService() {
        List<Client> clients = clientService.findAll();
        for (Client client:clients){
            System.out.println("<====}=0 "+client.getNom());
        }
    }
}
