package br.com.fiap.app;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.DaoFactory;
import br.com.fiap.dao.TelefoneDAO;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Telefone;

public class ConsultaClientes {

	public static void main(String[] args) {
	
		try {
			
			System.out.println("Consultando Cliente ...");
			
			ClienteDAO clientes = DaoFactory.GetClienteDAO();
			TelefoneDAO telefones = DaoFactory.GetTelefoneDAO();
		
			Cliente cliente = clientes.buscarCliente(1);
			
			System.out.println("Cliente "+cliente.getNome());
			
			for (Telefone telefone : cliente.getTelefones()) {
				System.out.println(telefone.getTelefone());
			}
			
			System.out.println("Consulta Cliente Finalizado!");
			System.out.println("Consultando Telefones ...");
			for (Telefone telefone : telefones.listarTelefones(1)) {
				System.out.println(telefone.getTelefone());
			}
			System.out.println("Consulta Telefones Finalizado!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}