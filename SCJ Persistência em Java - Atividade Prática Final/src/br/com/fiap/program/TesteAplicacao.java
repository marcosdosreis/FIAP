package br.com.fiap.program;

import java.util.Date;
import java.util.List;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pedido;

public class TesteAplicacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			GenericDAO<Cliente> dao = new GenericDAO<>(Cliente.class);

			//Definindo o primeiro cliente

			Cliente cliente = new Cliente();
			cliente.setId(10);
			cliente.setNome("JULIO ALMEIDA");
			cliente.setEmail("julio@mail.com");
			
			//Definindo dois pedidos
			Pedido pedido = new Pedido();
			pedido.setId(1001);
			pedido.setCliente(cliente);
			pedido.setData(new Date());
			pedido.setDescricao("Pedido 1 do Cliente 10");
			pedido.setValor(100.10);

			pedido = new Pedido();
			pedido.setId(1002);
			pedido.setCliente(cliente);
			pedido.setData(new Date());
			pedido.setDescricao("Pedido 2 do Cliente 10");
			pedido.setValor(200.20);
			
			dao.adicionar(cliente);
			
			System.out.println("Primeiro cliente inserido com sucesso!");

			//Definindo o segundo cliente

			cliente = new Cliente();
			cliente.setId(20);
			cliente.setNome("SANDRA ALBUQUERQUE");
			cliente.setEmail("xxxxx@mail.com");
			
			//Definindo único pedido
			pedido = new Pedido();
			pedido.setId(2001);
			pedido.setCliente(cliente);
			pedido.setData(new Date());
			pedido.setDescricao("Pedido 1 do Cliente 20");
			pedido.setValor(300.30);
		
			dao.adicionar(cliente);

			System.out.println("Segundo cliente inserido com sucesso!");

			//Listar clientes
			listarClientes(dao.listar());
			
			//Atualizar primeiro cliente
			cliente = dao.buscar(10);
			cliente.setEmail("sandra@mail.com");
			dao.atualizar(cliente);

			System.out.println("Primeiro cliente alterado com sucesso!");
			
			//Listar clientes
			listarClientes(dao.listar());

			//Remover segundo cliente
			cliente = dao.buscar(20);
			dao.remover(cliente);

			System.out.println("Segundo cliente excluído com sucesso!");

			//Listar clientes
			listarClientes(dao.listar());
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void listarClientes(List<Cliente> lista) {
		System.out.println("--- Clientes / Pedidos ---");
		for(Cliente c : lista){
			System.out.println("Cliente: " + c.getId() + " Nome: " + c.getNome() + " Email: " + c.getEmail());
			for(Pedido p : c.getPedidos()) {
				System.out.println("    Pedido: " + p.getId() + " Data: " + p.getData() + " Descrição: " + p.getDescricao() + " Valor: " + p.getValor());
			}
		}	
	}
}



