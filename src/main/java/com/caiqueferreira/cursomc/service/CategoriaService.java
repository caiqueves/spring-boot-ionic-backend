package com.caiqueferreira.cursomc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caiqueferreira.cursomc.domain.Categoria;
import com.caiqueferreira.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
    
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Categoria obj = repo.findOne(id);
		return obj;
	}
}
