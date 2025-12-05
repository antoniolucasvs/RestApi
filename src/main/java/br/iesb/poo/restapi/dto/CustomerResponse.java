package br.iesb.poo.restapi.dto;

import java.util.UUID;

public record CustomerResponse(
		/* Não expor a password, não comunicar a parte externa com a parte interna */
		UUID id,
		String name,
		String email,
		Integer age,
		String gender
		) {}
