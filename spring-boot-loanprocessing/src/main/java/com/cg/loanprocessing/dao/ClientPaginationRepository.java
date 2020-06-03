package com.cg.loanprocessing.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cg.loanprocessing.entity.Client;

public interface ClientPaginationRepository extends PagingAndSortingRepository<Client, String> {

}
