package dta.pizzeria.backend.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

	@Autowired
	private ClientService clientService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Client> listClients() {
		return clientService.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> setClient(@RequestBody Client client) {
		Client clientExistant = clientService.findByLoginOrMail(client.getLogin(), client.getMail());

		ResponseEntity<?> response = new ResponseEntity<String>("Login ou mail déjà utilisé", HttpStatus.BAD_REQUEST);

		if (clientExistant == null) {
			Client savedClient = clientService.save(client);
			response = new ResponseEntity<Client>(savedClient, HttpStatus.CREATED);
		}

		return response;
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void updateClient(@RequestBody Client client) {
		clientService.save(client);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void removeClient(@RequestParam long id) {
		clientService.delete(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Client getClient(@PathVariable("id") long id) {
		return clientService.findOne(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/connexion/{login}/{mdp}")
	public ResponseEntity<?> getConnexion(@PathVariable("login") String login, @PathVariable("mdp") String mdp) {
		Client client = clientService.findByLoginAndMdp(login, mdp);
		ResponseEntity<?> response = new ResponseEntity<String>("Login ou mdp érroné", HttpStatus.BAD_REQUEST);
		if (client != null)
			response = new ResponseEntity<Client>(client, HttpStatus.OK);
		return response;
	}

}