package br.iesb.poo.restapi.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.iesb.poo.restapi.dto.CustomerRequest;
import br.iesb.poo.restapi.dto.CustomerResponse;
import br.iesb.poo.restapi.dto.UpdateCustomerRequest;
import br.iesb.poo.restapi.service.ICustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	private final ICustomerService service;
	
	public CustomerController(ICustomerService service) {
		this.service = service;
	}
	
	// GET: /customers - listar todos os clientes
	@GetMapping()
	public ResponseEntity<List<CustomerResponse>> findAll() {
		List<CustomerResponse> customers = service.findAll();
		return ResponseEntity.ok(customers);
	}
	
	// GET: /customers/{id} - listar um cliente pelo id
	@GetMapping("/{id}")
	public ResponseEntity<CustomerResponse> findById(@PathVariable UUID id) {
		CustomerResponse found = service.findById(id);
		return ResponseEntity.ok(found);
	}
	
	// POST: /customer - criar novo cliente
	@PostMapping()
	public ResponseEntity<CustomerResponse> create(@RequestBody @Validated CustomerRequest request) {
		CustomerResponse created = service.create(request);
		URI location = URI.create("/customers/" + created.id());
		return ResponseEntity.created(location).body(created);
	}
		
	// PUT: /customer/{id} - editar um cliente pelo id
	@PutMapping("/{id}")
	public ResponseEntity<CustomerResponse> update(@PathVariable UUID id, @RequestBody @Validated UpdateCustomerRequest request) {
		CustomerResponse updated = service.update(id, request);
		return ResponseEntity.ok(updated);
	}
	
	// DELETE: /customer/{id} - deletar um cliente pelo id
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable UUID id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
