/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dta.pizzeria.backend.metier;

import dta.pizzeria.backend.dao.ClientDao;
import dta.pizzeria.backend.entity.Client;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author kk
 */
@Service
public class ClientService {
    @Autowired
    private ClientDao clientDao;   
    
    @Autowired
    private MailService mailService;

    public List<Client> findAll() {
        return clientDao.findAll();
    }

    public Client findOne(Long id) {
        return clientDao.findOne(id);
    }

    public <S extends Client> S save(S s) {
        return clientDao.save(s);
    }

    public void delete(Long id) {
        clientDao.delete(id);
    }

    public void deleteAll() {
        clientDao.deleteAll();
    }

    
    public Client FindByNomAndPrenom(String nom, String prenom) {
        return clientDao.findByNomAndPrenom(nom, prenom);
    }


	public ResponseEntity<?> inscription(Client client) {
		Client clientExistant = clientDao.findByLoginOrMail(client.getLogin(),client.getMail());

		ResponseEntity<?> response = new ResponseEntity<String>("Login ou mail déjà utilisé", HttpStatus.BAD_REQUEST);

		if (clientExistant == null) {
			Client savedClient = save(client);
			response = new ResponseEntity<Client>(savedClient, HttpStatus.CREATED);
			mailService.envoyerMailSMTP(savedClient);
		}

		return response;
	
	}

	public ResponseEntity<?> connexion(String login, String mdp) {
		Client client = clientDao.findByLoginAndMdp(login, mdp);
		ResponseEntity<?> response = new ResponseEntity<String>("Login ou mdp érroné.", HttpStatus.BAD_REQUEST);
		if (client != null)
			if (client.getValidation())
				response = new ResponseEntity<Client>(client, HttpStatus.OK);
			else
				response = new ResponseEntity<String>("Ce compte n'a pas encore été validé.", HttpStatus.BAD_REQUEST);
		return response;		
	}
	
	public ResponseEntity<?> validation(long id, int hash) {
		Client client = findOne(id);
		ResponseEntity<?> response = new ResponseEntity<String>("Ce compte n'existe pas.", HttpStatus.BAD_REQUEST);
		if (client != null) {
			if(!client.getValidation()) {
				if(hash == (client.getLogin()+client.getMail()).hashCode()) {
					client.setValidation(true);
					save(client);
					response = new ResponseEntity<Client>(client, HttpStatus.OK);
				} else {
					response = new ResponseEntity<String>("Le hash ne correspond pas à ce compte.", HttpStatus.BAD_REQUEST);	
				}
			} else {
				response = new ResponseEntity<String>("Ce compte a déjà été validé.", HttpStatus.BAD_REQUEST);				
			}
			
		} 
		return response;
	
	}
}
