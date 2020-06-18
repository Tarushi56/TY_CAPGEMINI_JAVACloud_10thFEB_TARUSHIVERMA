package com.cg.loanprocessing.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cg.loanprocessing.dao.ClientRepository;
import com.cg.loanprocessing.entity.Client;
@Service
public class ClientServiceImpl implements ClientService {
private ClientRepository ClientRepo;

@Autowired
public ClientServiceImpl(ClientRepository ClientRepo) {
	this.ClientRepo=ClientRepo;
}
	@Override
	public List<Client> showAllClients() {
		return ClientRepo.findAll();
	}

	@Override
	public Client getClientByEmail(String email) {
		Optional<Client> result = ClientRepo.findById(email);
		Client theClient=null;
		if(result.isPresent()) {
			theClient=result.get();
			return theClient;
		}
		return null;
	}

	@Override
	public Client saveClient(Client client) {
		return ClientRepo.save(client);
	}

	@Override
	public void deleteClient(String email) {
		ClientRepo.deleteById(email);		
	}
	//pagination
	@Override
	public Page<Client> getClients(int pageNo, int itemsPerPage) {
		Pageable pageable = PageRequest.of(pageNo, itemsPerPage);
		return ClientRepo.findAll(pageable);
	}
	@Override
	public Page<Client> getSortClients(int pageNo, int itemsPerPage, String fieldName) {
		Pageable pageable = PageRequest.of(pageNo, itemsPerPage, Sort.by(fieldName));
		return ClientRepo.findAll(pageable);
	}

}
