package com.caiqueferreira.cursomc.domain;

import javax.persistence.Entity;

import com.caiqueferreira.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {
	
	private static final long serialVersionUID = 1L;
	
	private Integer numeroDeParcelas;
    
	public PagamentoComCartao () {
		
	}

	public PagamentoComCartao(Integer iD, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(iD, estado, pedido);
		
		this.numeroDeParcelas = numeroDeParcelas;
		
		// TODO Auto-generated constructor stub
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
}
