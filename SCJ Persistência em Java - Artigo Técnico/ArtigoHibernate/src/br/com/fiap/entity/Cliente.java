package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Set;

public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L; 

	private Integer id;
	private String nome;
	private Set<Telefone> telefones;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Set<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}

	
}
