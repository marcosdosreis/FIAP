package br.com.fiap.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="agenda")

public class Agenda implements Serializable {

	private static final long serialVersionUID = 400L;

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="id")
	private int id;
		
	@Temporal(value = TemporalType.DATE)
	@Column(name = "data")
	private Date data;

	@Temporal(value = TemporalType.TIME)
	@Column(name = "hora")
	private Date hora;
	
	@Column(name="descricao", length=45) 
	private String descricao;

	@ManyToMany()
	@JoinTable(name="agenda_paciente",joinColumns=@JoinColumn(name="agenda_id"),inverseJoinColumns=@JoinColumn(name="paciente_cpf"))
	private Collection<Paciente> pacientes = new ArrayList<Paciente>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Collection<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(Collection<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

}


