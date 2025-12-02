package br.iesb.poo.restapi.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public class CustomerController {
	
	// GET: /customers - listar todos os clientes
	@GetMapping("/customers")
	public String findAll() {
		return "GET: /customers";
	}
	
	// GET: /customers/{id} - listar um cliente pelo id
	@GetMapping("/customers/{id}")
	public String findById(@PathVariable UUID id) {
		return "GET: /customers/" + id;
	}
	
	// POST: /customer - criar novo cliente
	@PostMapping("/customers")
	public String create() {
		return "POST: /customers";
	}
	
	// PUT: /customer/{id} - editar um cliente pelo id
	@PutMapping("/customers/{id}")
	public String update(@PathVariable UUID id) {
		return "PUT: /customers/" + id;
	}
	
	// DELETE: /customer/{id} - deletar um cliente pelo id
	@DeleteMapping("/customers/{id}")
	public String delete(@PathVariable UUID id) {
		return "DELETE: /customers/" + id;
	}
	
	
}
