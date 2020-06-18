package com.cg.loanprocessing.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.loanprocessing.entity.Client;
import com.cg.loanprocessing.entity.LoanForm;
@SpringBootTest
class ClientServiceImplTest {

	@Autowired
	private ClientService clientService;

	Client client;
	Client addClient = null;
	

	@BeforeEach
	void addUser() {
		client	=new Client();
		client.setFullName("Anshu Kumar");
		client.setEmail("anshu@gmail.com");
		client.setPassword("Qwerty@1");
		client.setPhone("9009415759");
		client.setRole("ROLE_CUSTOMER");
		addClient=clientService.saveClient(client);
}
	@Test
	void testAddUser() {
		assertNotNull(addClient);
	}
	@Test
	void testSearchUser() {
		Client client = clientService.getClientByEmail(this.addClient.getEmail());
		assertNotNull(client);
	}
	@Test
	void testGetAllUsers() {
		List<Client> clientList = clientService.showAllClients();
		assertNotNull(clientList);
	}

	@AfterEach
	void testDeleteUser() {
		client = clientService.getClientByEmail(this.client.getEmail());
		clientService.deleteClient(client.getEmail());
	}
	
	
	 @Test void testAfterDelete() {
		  assertNotNull(client); }
	
	
	
	
	
	}
