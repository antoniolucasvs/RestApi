package br.iesb.poo.restapi.service;

import java.util.List;
import java.util.UUID;

import br.iesb.poo.restapi.dto.CustomerRequest;
import br.iesb.poo.restapi.dto.CustomerResponse;
import br.iesb.poo.restapi.dto.UpdateCustomerRequest;

public interface ICustomerService {
	List<CustomerResponse> findAll();
	CustomerResponse findById(UUID id);
	CustomerResponse create(CustomerRequest request);
	CustomerResponse update(UUID id, UpdateCustomerRequest request);
	void delete(UUID id);
}
