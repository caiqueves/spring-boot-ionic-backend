package com.caiqueferreira.cursomc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caiqueferreira.cursomc.domain.Cliente;
import com.caiqueferreira.cursomc.repositories.ClienteRepository;
import com.caiqueferreira.cursomc.service.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
    
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Cliente obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado Id:" +id 
					+ ", Tipo: " + Cliente.class.getName());
		}
		
		return obj;
	}
}
