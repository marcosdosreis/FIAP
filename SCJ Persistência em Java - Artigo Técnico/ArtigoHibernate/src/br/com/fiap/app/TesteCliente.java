package br.com.fiap.app;


import java.util.List;
import java.util.Set;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Telefone;
import br.com.fiap.helper.ClienteHelper;

public class TesteCliente {

	private static ClienteHelper helper = new ClienteHelper();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		incluirClientecomTelefones();
		
		listarCliente();
		listarTelefones();
			
	}
	
	public static void incluirClientecomTelefones() {
		Cliente cliente = new Cliente();
		cliente.setNome("Paulo");
		
		Telefone telefone1 = new Telefone();
		telefone1.setTelefone("21988882323");;
		telefone1.setCliente(cliente);
		
		Telefone telefone2 = new Telefone();
		telefone2.setTelefone("31977742899");
		telefone2.setCliente(cliente);

		System.out.println(helper.salvar(cliente));
		System.out.println(helper.salvar(telefone1));
		System.out.println(helper.salvar(telefone2));
		
	}
	
	public static void listarCliente() {
		Cliente cliente = helper.getCliente(1);
		System.out.println("---Listar Cliente ---");
		System.out.println("Id Cliente: " + cliente.getId() + " Nome: " + cliente.getNome());
		Set<Telefone> telefones = cliente.getTelefones();
		for(Telefone telefone: telefones) {
			System.out.println("---Listar Telefones do Cliente ---");
			System.out.println("Id Telefone: " + telefone.getId() + " Telefone: " + telefone.getTelefone());			
		}

	}

	public static void listarTelefones() {
		List<Telefone> telefones = helper.listarTelefones();
		for(Telefone telefone: telefones) {
			System.out.println("---Listar Telefones ---");
			System.out.println("Id Telefone: " + telefone.getId() + " Telefone: " + telefone.getTelefone() + "Cliente:" + telefone.getCliente().getId());			
		}		
	}
}
