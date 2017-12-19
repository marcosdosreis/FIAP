package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="paciente")

public class Paciente implements Serializable {

	private static final long serialVersionUID = 100L;

	@Id 
	@Column(name="cpf", length=11) 
	private String cpf;
	
	@Column(name="nome", length=45) 
	private String nome;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "datanasc")
	private Date dataNascimento;
	
	@Column(name="telefone", length=20) 
	private String telefone;

	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="paciente")
	private Set<Procedimento> procedimentos = new LinkedHashSet<Procedimento>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="paciente")
	private Set<MaterialMedicamento> materiaisMedicamentos = new LinkedHashSet<MaterialMedicamento>();
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Set<Procedimento> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(Set<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}

	public Set<MaterialMedicamento> getMateriaisMedicamentos() {
		return materiaisMedicamentos;
	}

	public void setMateriaisMedicamentos(Set<MaterialMedicamento> materiaisMedicamentos) {
		this.materiaisMedicamentos = materiaisMedicamentos;
	}
	
}
