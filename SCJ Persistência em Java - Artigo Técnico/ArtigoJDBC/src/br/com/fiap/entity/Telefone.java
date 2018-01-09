package br.com.fiap.entity;

public class Telefone {

	private int id;
	private String telefone;
	private int idCliente;
	
	public Telefone(){
		
	}

	public Telefone(String telefone, int id, int idCliente) {
		super();
		this.id = id;
		this.telefone = telefone;
		this.idCliente=idCliente;
	}

	public Telefone(String telefone, int idCliente) {
		super();
		this.telefone = telefone;
		this.idCliente=idCliente;
	}
	
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

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
}
