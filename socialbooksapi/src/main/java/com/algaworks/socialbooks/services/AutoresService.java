package com.algaworks.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.socialbooks.domain.Autor;
import com.algaworks.socialbooks.repository.AutoresRepository;
import com.algaworks.socialbooks.services.exceptions.AutorExistenteException;
import com.algaworks.socialbooks.services.exceptions.AutorNaoEncontradoException;

@Service
public class AutoresService {

	@Autowired
	private AutoresRepository autoresRepsository;
	
	public List<Autor> listar(){
		return autoresRepsository.findAll();
	}
	
	public Autor salvar(Autor autor) {
		if(autor.getId() != null) {
			Autor a  = autoresRepsository.findById(autor.getId()).orElse(null);
			
			if(a != null) {
				throw new AutorExistenteException("O autor já existe.");
			}
		}
		return autoresRepsository.save(autor);
	}
	
	public Autor buscar(long id) {
		Autor autor =  autoresRepsository.findById(id).orElse(null);
		if(autor == null) {
			throw new AutorNaoEncontradoException("O autor não pode ser encontrado!");
		}
		return autor;
	}

}
