package br.com.fiap.dao;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO {
	public void inserirCliente(Cliente cliente) throws Exception;
	public Cliente buscarCliente(int id) throws Exception;
}