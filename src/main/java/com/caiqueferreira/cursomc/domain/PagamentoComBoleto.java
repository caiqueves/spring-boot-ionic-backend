package com.caiqueferreira.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.caiqueferreira.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento {
	
	private static final long serialVersionUID = 1L;
	
	private Date dataVencimento;
	private Date dataPagamento;
	
	public PagamentoComBoleto () {
		
	}

	public PagamentoComBoleto(Integer iD, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(iD, estado, pedido);
		
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataPagamento;
		// TODO Auto-generated constructor stub
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	
	
	

}
