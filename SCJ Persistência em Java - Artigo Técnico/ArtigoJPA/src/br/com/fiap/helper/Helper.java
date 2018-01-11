package br.com.fiap.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.Query;

import br.com.fiap.entity.Cliente;

public class Helper {
	private EntityManager em;
	public Helper(EntityManager em){
		this.em = em;
	}

	public void salvar(Cliente cliente) throws Exception { 
		try {
			em.getTransaction().begin(); 
			em.persist(cliente);
			em.getTransaction().commit();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> listarClientes(){
		Query query = em.createQuery("select e from Cliente e"); 
		return query.getResultList();
		
	}

}