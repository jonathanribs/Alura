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
		//como dentro de cada movimenta��o pode ter varias categorias, n�o pode se fazer a busca direto como em TesteJPQL.java
		//� necess�rio usar o JOIN para buscar na lista de categorias de cada movimentaa��o, a correspondencia desejada
		
		Categoria categoria = new Categoria();
		categoria.setId(2L);
		TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class); 
		query.setParameter("pCategoria", categoria); 
		
		List<Movimentacao> restulList = query.getResultList();
		for (Movimentacao movimentacao : restulList) {
			System.out.println("Categorias: " + movimentacao.getCategoria());
			System.out.println("Descri��o: " + movimentacao.getDescricao());
			System.out.println("Valor: " + movimentacao.getValor());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
		}

	}

}
