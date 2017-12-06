package br.com.fiap.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.entity.Empresa;

public class Helper {
	private EntityManager em;

	public Helper(EntityManager em){
		this.em = em;
	}

	public void salvar(Empresa empresa) throws Exception { 
		try {
			em.getTransaction().begin(); 
			em.persist(empresa); 
			em.getTransaction().commit();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Empresa> listarEmpresas(){
		Query query = em.createQuery("select e from Empresa e"); 
		return query.getResultList();
		
	}

}