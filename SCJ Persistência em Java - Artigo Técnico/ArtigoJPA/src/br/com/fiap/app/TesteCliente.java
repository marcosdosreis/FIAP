package br.com.fiap.app;

import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Telefone;
import br.com.fiap.helper.Helper;

public class TesteCliente {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ArtigoJPA");
		EntityManager em = emf.createEntityManager();
		
		Helper dao = new Helper(em);
		
		Cliente cliente = new Cliente();
		cliente.setNome("José");
		
		Telefone telefone = new Telefone();
		telefone.setCliente(cliente);
		telefone.setTelefone("11928281111");
		cliente.getTelefones().add(telefone);
		
		telefone = new Telefone();
		telefone.setCliente(cliente);
		telefone.setTelefone("11997772222");
		cliente.getTelefones().add(telefone);
		
		try {
			dao.salvar(cliente);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		List<Cliente> clientes = dao.listarClientes();
		System.out.println("---Listar Cliente ---");
		for(Cliente cliente1 : clientes){
			System.out.println("Id Cliente: " + cliente1.getId() + " Nome: " + cliente1.getNome());
			Set<Telefone> telefones = cliente1.getTelefones();
			for(Telefone telefone1: telefones) {
				System.out.println("---Listar Telefones do Cliente ---");
				System.out.println("Id Telefone: " + telefone1.getId() + " Telefone: " + telefone1.getTelefone());			
			}
		}
	}
}
