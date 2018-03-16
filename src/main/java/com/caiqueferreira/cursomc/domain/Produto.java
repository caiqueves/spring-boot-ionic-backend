package com.caiqueferreira.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L; 
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer Id;
  private String name;
  private double preco;
  
  @JsonBackReference
  @ManyToMany
  @JoinTable( name = "PRODUTO_CATEGORIA",
     joinColumns = @JoinColumn(name = "produto_id"),
     inverseJoinColumns = @JoinColumn(name = "categoria_id")
		  )
  private List<Categoria> categorias = new ArrayList<>();
  
  public Produto() {
	  
  }
  
  public Produto(Integer id, String name, double preco) {
	super();
	Id = id;
	this.name = name;
	this.preco = preco;
  }

public Integer getId() {
	return Id;
}

public void setId(Integer id) {
	Id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getPreco() {
	return preco;
}

public void setPreco(double preco) {
	this.preco = preco;
}

public List<Categoria> getCategorias() {
	return categorias;
}

public void setCategorias(List<Categoria> categorias) {
	this.categorias = categorias;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((Id == null) ? 0 : Id.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Produto other = (Produto) obj;
	if (Id == null) {
		if (other.Id != null)
			return false;
	} else if (!Id.equals(other.Id))
		return false;
	return true;
}
  
  
}
