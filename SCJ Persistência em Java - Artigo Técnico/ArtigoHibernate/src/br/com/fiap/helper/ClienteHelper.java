package br.com.fiap.helper;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.fiap.config.HibernateUtil;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Telefone;

public class ClienteHelper {

	Session session = null;
	Transaction transaction = null;

	public void encerrar(){
		session.close();
	}

	public String salvar(Cliente cliente){ 
		try{
			session = HibernateUtil.getSessionFactory().getCurrentSession(); 
			transaction = session.beginTransaction();
			session.save(cliente);
			transaction.commit();
			return "Cliente salvo"; 
		}catch(Exception e){
			return e.getMessage();
		} 
	}

	public String salvar(Telefone telefone){ 
		try{
			session = HibernateUtil.getSessionFactory().getCurrentSession(); 
			transaction = session.beginTransaction();
			session.save(telefone);
			transaction.commit();
			return "Telefone salvo"; 
		}catch(Exception e){
			return e.getMessage();
		} 
	}
	
	public Telefone getTelefone(int idTelefone){
		Telefone telefone = new Telefone();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.load(telefone, idTelefone);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return telefone;
	} 

	@SuppressWarnings("unchecked")
	public List<Telefone> listarTelefones(){ 
		List<Telefone> telefones = new ArrayList<>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			TypedQuery<Telefone> query = session.createQuery("from Telefone");
			telefones = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return telefones;
	}
	
	public Cliente getCliente(int idCliente){
		Cliente cliente = new Cliente();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.load(cliente, idCliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cliente;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> listarClientes(String nome){ 
		List<Cliente> clientes = new ArrayList<>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			TypedQuery<Cliente> query = session.createQuery("from Cliente where nome like :nome");
			query.setParameter("nome", "%" + nome + "%");
			clientes = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientes;
	}

}
