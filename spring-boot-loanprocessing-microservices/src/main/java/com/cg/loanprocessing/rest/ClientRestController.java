package com.cg.loanprocessing.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.loanprocessing.entity.Client;
import com.cg.loanprocessing.entity.LoanForm;
import com.cg.loanprocessing.entity.LoanProgram;
import com.cg.loanprocessing.exception.ClientNotFoundException;
import com.cg.loanprocessing.response.Response;
import com.cg.loanprocessing.service.ClientService;

@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
@RestController
public class ClientRestController {
	@Autowired
	private RestTemplate template;
	@Autowired
	private ClientService service;
	
	@Autowired
	public ClientRestController(ClientService service) {
		this.service = service;
	}
	@SuppressWarnings("unchecked")
	@GetMapping("/client")
	public List<Client> getAllClients(){
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return template.exchange(" http://localhost:8083/client/" , HttpMethod.GET, entity, List.class).getBody();

	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/client/{email}")
	public Response<Client> getClientByEmail(@PathVariable String email) {
		Client client = service.getClientByEmail(email);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return template.exchange(" http://localhost:8083/client/"+email , HttpMethod.GET, entity, Response.class).getBody();

		
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/client/add")
	public Response<Client> addClient(@RequestBody Client client) {
		Client client1 = service.saveClient(client);
		 HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Client> entity = new HttpEntity<Client>(client,headers);
	      
	      return template.exchange(
	         "http://localhost:8083/client/add", HttpMethod.POST, entity, Response.class).getBody();
	  
			
	}
	
	@SuppressWarnings("unchecked")
	@PutMapping("/client/update")
	public Response<Client> updateClient(@RequestBody Client client) {
		Client client1 = service.saveClient(client);
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<Client> entity = new HttpEntity<Client>(client,headers);
	      
	      return template.exchange(
	         "http://localhost:8083/client/add", HttpMethod.PUT, entity, Response.class).getBody();
	  
			
	}
	
	@SuppressWarnings("unchecked")
	@DeleteMapping("/client/delete/{email}")
	public Response<Client> deleteClient(@PathVariable String email) {
		Client client = service.getClientByEmail(email);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return template.exchange(" http://localhost:8083/client/delete/"+email , HttpMethod.DELETE, entity, Response.class).getBody();

			
	}
	//pagination
		@SuppressWarnings("unchecked")
		@GetMapping("/client/{pageNo}/{itemsPerPage}")
		public Page<Client> getClients(@PathVariable int pageNo, @PathVariable int itemsPerPage ){
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<String>(headers);

			return template.exchange(" http://localhost:8083/client/" + pageNo +itemsPerPage, HttpMethod.GET, entity, Page.class).getBody();

		}
		//sorting
		@SuppressWarnings("unchecked")
		@GetMapping("/client/{pageNo}/{itemsPerPage}/{fieldName}")
		public Page<Client> getSortClients(@PathVariable int pageNo ,@PathVariable int itemsPerPage,@PathVariable String fieldName){
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<String> entity = new HttpEntity<String>(headers);

			return template.exchange(" http://localhost:8083/client/" + pageNo +itemsPerPage +fieldName, HttpMethod.GET, entity, Page.class).getBody();

			
		}
}
