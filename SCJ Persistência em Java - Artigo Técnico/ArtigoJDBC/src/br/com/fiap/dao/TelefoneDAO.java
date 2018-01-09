package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Telefone;

public interface TelefoneDAO {
	public void inserirTelefone(Telefone telefone) throws Exception;
	public List<Telefone> listarTelefones(int idCliente) throws Exception;
}
