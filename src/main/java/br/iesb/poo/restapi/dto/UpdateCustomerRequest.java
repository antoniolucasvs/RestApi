package br.iesb.poo.restapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UpdateCustomerRequest(
		@Size(min = 2, max = 100)
		String name,
		@Email
		String email,
		@Size(min = 6, max = 50)
		String password,
		@Min(18)
		Integer age,
		// pode ser nulo
		@Pattern(regexp = "^(Masculino|Feminino|Outro)$")
		String gender
		) 
		{}
