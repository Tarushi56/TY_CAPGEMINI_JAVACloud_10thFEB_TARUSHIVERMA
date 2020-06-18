package com.cg.loanprocessing.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.loanprocessing.entity.Client;

public interface ClientRepository extends JpaRepository<Client, String> {

}
