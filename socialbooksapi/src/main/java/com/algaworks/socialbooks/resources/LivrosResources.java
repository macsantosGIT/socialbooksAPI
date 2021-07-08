package com.algaworks.socialbooks.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivrosResources {

	@RequestMapping
	public String listar() {
		return "Rest Aplicado, Git passo-a-passo";
	}
}
