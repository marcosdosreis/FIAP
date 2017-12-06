package br.com.fiap.programa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.fiap.entity.Contato;
import br.com.fiap.entity.Empresa;
import br.com.fiap.entity.Telefone;
import br.com.fiap.helper.Helper;

public class TesteFinal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String texto;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAFinal");
		EntityManager em = emf.createEntityManager();
		
		Helper dao = new Helper(em);
		
		Empresa empresa = new Empresa();
		
		texto = JOptionPane.showInputDialog("Empresa - Entre com o CNPJ");
		empresa.setCnpj(texto);
		texto = JOptionPane.showInputDialog("Empresa - Entre com a Razão Social");
		empresa.setRazao(texto);
		texto = JOptionPane.showInputDialog("Empresa - Entre com o Nome Fantasia");
		empresa.setNome(texto);
		
		Contato contato = new Contato();
		texto = JOptionPane.showInputDialog("Contato - Entre com o Id");
		contato.setId(new Integer(texto));
		texto = JOptionPane.showInputDialog("Contato - Entre com o Nome");
		contato.setNome(texto);
		texto = JOptionPane.showInputDialog("Contato - Entre com o Departamento");
		contato.setDepartamento(texto);
		contato.setEmpresa(empresa);
		empresa.getContatos().add(contato);
		
		Telefone telefone = new Telefone();
		texto = JOptionPane.showInputDialog("Telefone - Entre com o Id");
		telefone.setId(new Integer(texto));
		telefone.setContato(contato);
		texto = JOptionPane.showInputDialog("Telefone - Entre com o Número do telefone");
		telefone.setTelefone(texto);
		contato.getTelefones().add(telefone);
		
		telefone = new Telefone();
		texto = JOptionPane.showInputDialog("Telefone - Entre com o Id");
		telefone.setId(new Integer(texto));
		telefone.setContato(contato);
		texto = JOptionPane.showInputDialog("Telefone - Entre com o Número do telefone");
		telefone.setTelefone(texto);
		contato.getTelefones().add(telefone);
		
		contato = new Contato();
		texto = JOptionPane.showInputDialog("Contato - Entre com o Id");
		contato.setId(new Integer(texto));
		texto = JOptionPane.showInputDialog("Contato - Entre com o Nome");
		contato.setNome(texto);
		texto = JOptionPane.showInputDialog("Contato - Entre com o Departamento");
		contato.setDepartamento(texto);
		contato.setEmpresa(empresa);
		empresa.getContatos().add(contato);
		
		telefone = new Telefone();
		texto = JOptionPane.showInputDialog("Telefone - Entre com o Id");
		telefone.setId(new Integer(texto));
		telefone.setContato(contato);
		texto = JOptionPane.showInputDialog("Telefone - Entre com o Número do telefone");
		telefone.setTelefone(texto);
		contato.getTelefones().add(telefone);
		
		try {
			dao.salvar(empresa);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
