package br.com.fiap.app;

import java.util.ArrayList;
import java.util.List;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.DaoFactory;
import br.com.fiap.dao.TelefoneDAO;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Telefone;

public class CadastroClientes {

	public static void main(String[] args) {

		try {
			
			System.out.println("Cadastrando Cliente ...");
			
			ClienteDAO clientes = DaoFactory.GetClienteDAO();
			TelefoneDAO telefones = DaoFactory.GetTelefoneDAO();
			
			List<Telefone> telefonesCliente = new ArrayList<>();
			
			Cliente cliente = new Cliente("José", telefonesCliente);
			clientes.inserirCliente(cliente);
			
			telefonesCliente.add(new Telefone("11989981212", cliente.getId()));
			telefonesCliente.add(new Telefone("11989003335", cliente.getId()));
			
			for (Telefone telefone : telefonesCliente) {
				telefones.inserirTelefone(telefone);;
			}
			
			System.out.println("Cadastro Cliente Finalizado!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	

	}

}
