package com.cg.loanprocessing.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.cg.loanprocessing.entity.Client;
import com.cg.loanprocessing.entity.LoanForm;
import com.cg.loanprocessing.entity.LoanProgram;

public interface ClientService {
	public List<Client> showAllClients();

	public Client getClientByEmail(String email);

	public Client saveClient(Client client);

	public void deleteClient(String email);

	public Page<Client> getClients(int pageNo, int itemsPerPage);

	public Page<Client> getSortClients(int pageNo, int itemsPerPage, String fieldName);

}
