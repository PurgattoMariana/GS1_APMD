package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.fiap.posto.*;
import br.com.fiap.posto.model.Produto;

public class ProdutoDao {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("posto");
	EntityManager manager = factory.createEntityManager();
	
	public void inserir(Produto produto) {

		manager.getTransaction().begin();
		manager.persist(produto);
		manager.getTransaction().commit();
	}
	
	public List<Produto> listarTodos(){
		String jpql = "SELECT p FROM Produto p" ;
		TypedQuery<Produto> query  = manager.createQuery(jpql, Produto.class);
		return query.getResultList();
	}
	
	public List<Produto> listarTodosId(){
		String jpql = "SELECT id FROM Produto p" ;
		TypedQuery<Produto> query  = manager.createQuery(jpql, Produto.class);
		return query.getResultList();
	}

	public void apagar(Produto produto) {
		manager.getTransaction().begin();
		manager.remove(produto);
		manager.getTransaction().commit();
	}
	
	public void apagarLinha(Produto produto) {
		manager.getTransaction().begin();
		manager.remove(produto);
		manager.getTransaction().commit();
	}
	
	public void apagar(Long id) {
		apagar(buscarPorId(id));
	}

	public Produto buscarPorId(Long id) {
		return manager.find(Produto.class, id);
	}
}
