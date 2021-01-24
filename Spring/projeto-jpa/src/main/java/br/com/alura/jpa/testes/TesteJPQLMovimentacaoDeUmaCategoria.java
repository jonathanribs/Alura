package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQLMovimentacaoDeUmaCategoria {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		String jpql = "SELECT m FROM Movimentacao m JOIN m.categoria c WHERE c = :pCategoria";
		//como dentro de cada movimentação pode ter varias categorias, não pode se fazer a busca direto como em TesteJPQL.java
		//é necessário usar o JOIN para buscar na lista de categorias de cada movimentaação, a correspondencia desejada
		
		Categoria categoria = new Categoria();
		categoria.setId(2L);
		TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class); 
		query.setParameter("pCategoria", categoria); 
		
		List<Movimentacao> restulList = query.getResultList();
		for (Movimentacao movimentacao : restulList) {
			System.out.println("Categorias: " + movimentacao.getCategoria());
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Valor: " + movimentacao.getValor());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
		}

	}

}
