package br.iesb.poo.restapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.iesb.poo.restapi.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, UUID>{
	boolean existsByEmail(String email);
}
