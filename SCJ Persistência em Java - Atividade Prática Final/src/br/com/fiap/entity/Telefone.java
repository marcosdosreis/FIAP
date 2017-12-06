package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TELEFONES")

public class Telefone implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id 
	@Column(name="IDTELEFONE") 
	private int id;
	
	@Column(name="NUMTELEFONE", length=12) 
	private String telefone;
	
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="IDCONTATO") 
	private Contato contato;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	
	
}
