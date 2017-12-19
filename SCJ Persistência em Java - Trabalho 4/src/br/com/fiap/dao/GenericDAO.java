package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;

public class GenericDAO<T> implements Dao<T>{
	
	private final Class<T> classe;
	protected EntityManager em;
	
	public GenericDAO (Class<T> classe) {
		this.classe = classe;
	}
	
	@Override
	public void adicionar (T entidade) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<T> listar(String criterio) {
		em = JpaUtil.getEntityManager();
		return em.createQuery("SELECT c FROM " + classe.getSimpleName() + " c WHERE c.nome LIKE :nome", classe).setParameter("nome", criterio + "%").getResultList();
	}

	@Override
	public void atualizar (T entidade) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
		em.close();
	}
	
	@Override
	public void remover (T entidade) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(entidade));
		em.getTransaction().commit();
		em.close();
	}
	
	@Override
	public T buscar(int id) {
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		T entidade = em.find(classe, id);
		em.getTransaction().commit();
		em.close();
		return entidade;
	}
}
