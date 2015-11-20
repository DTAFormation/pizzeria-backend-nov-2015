package dta.pizzeria.backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dta.pizzeria.backend.entity.Client;
import dta.pizzeria.backend.metier.ClientService;

@RestController
@RequestMapping("/client")
@CrossOrigin
public class ClientRessource {
	
	@Autowired private ClientService clientService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Client> listClients() {
		return clientService.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void setClient(@RequestBody Client client){
		clientService.save(client);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void updateClient(@RequestBody Client client){
		clientService.save(client);
	}

	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public void removeClient(@RequestParam long id){
		clientService.delete(id);
	}

	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public Client getClient(@PathVariable("id") long id){
		return clientService.findOne(id);
	}
        
        @RequestMapping(method = RequestMethod.POST, value="/search")
        public Client findByNomAndPrenom(@RequestBody Client client) {
            System.out.println(client);
            return clientService.FindByNomAndPrenom(client.getNom(), client.getPrenom());
        }

}