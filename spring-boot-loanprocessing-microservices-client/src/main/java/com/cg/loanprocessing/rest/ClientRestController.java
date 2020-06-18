package com.cg.loanprocessing.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	private ClientService service;
	
	@Autowired
	public ClientRestController(ClientService service) {
		this.service = service;
	}
	@GetMapping("/client")
	public List<Client> getAllClients(){
		return service.showAllClients();
	}
	
	@GetMapping("/client/{email}")
	public Response<Client> getClientByEmail(@PathVariable String email) {
		Client client = service.getClientByEmail(email);
		if (client!= null) {
			return new Response<>(false,"record found",client);
		} else {
			throw new ClientNotFoundException("client not found");
		}
		
	}
	
	@PostMapping("/client/add")
	public Response<Client> addClient(@RequestBody Client client) {
		Client client1 = service.saveClient(client);
		if(client1!=null) {
			return new Response<Client>(false,"client saved Successfully ",client1);
		}else {
			return new Response<Client>(true,"client not saved ",null);
		}
			
	}
	
	@PutMapping("/client/update")
	public Response<Client> updateClient(@RequestBody Client client) {
		Client client1 = service.saveClient(client);
		if(client1!=null) {
			return new Response<Client>(false,"client updated Successfully ",client1);
		}else {
			return new Response<Client>(true,"client not updated ",null);
		}
	}
	
	@DeleteMapping("/client/delete/{email}")
	public Response<Client> deleteClient(@PathVariable String email) {
		Client client = service.getClientByEmail(email);
		if(client!=null) {
			service.deleteClient(email);
			return new Response<Client>(false,"client deleted successfully",client);
		}else {
			return new Response<Client>(true,"client not found",null);
		}
			
	}
	//pagination
		@GetMapping("/client/{pageNo}/{itemsPerPage}")
		public Page<Client> getClients(@PathVariable int pageNo, @PathVariable int itemsPerPage ){
			return service.getClients(pageNo, itemsPerPage);
		}
		//sorting
		@GetMapping("/client/{pageNo}/{itemsPerPage}/{fieldName}")
		public Page<Client> getSortClients(@PathVariable int pageNo ,@PathVariable int itemsPerPage,@PathVariable String fieldName){
			return service.getSortClients(pageNo, itemsPerPage, fieldName);
			
		}
}
