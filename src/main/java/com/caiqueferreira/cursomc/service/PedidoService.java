package com.caiqueferreira.cursomc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caiqueferreira.cursomc.domain.Pedido;
import com.caiqueferreira.cursomc.repositories.PedidoRepository;
import com.caiqueferreira.cursomc.service.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
    
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Pedido obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado Id:" +id 
					+ ", Tipo: " + Pedido.class.getName());
		}
		
		return obj;
	}
}
