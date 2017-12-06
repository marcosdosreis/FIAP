package br.com.fiap.entity;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CONTATOS")

public class Contato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id 
	@Column(name="IDCONTATO") 
	private int id;
	
	@Column(name="NOME", length=50) 
	private String nome;

	@Column(name="DEPARTAMENTO", length=50) 
	private String departamento;
	
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="CNPJ") 
	private Empresa empresa;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="contato")
	private Set<Telefone> telefones = new LinkedHashSet<Telefone>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Set<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	

}
