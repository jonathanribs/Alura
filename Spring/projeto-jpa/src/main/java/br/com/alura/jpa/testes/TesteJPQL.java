package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQL {

	public static void main(String[] args) {

//		String query = "SELECT * FROM MOVIMENTACAO WHERE CONTA_ID = 2";
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		//String jpql = "SELECT m FROM Movimentacao m WHERE m.conta.id = 2"; //a forma abaixo substitui o uso do ID, buscando diretamente por uma conta
		Conta conta = new Conta();
		conta.setId(2L);
		String jpql = "SELECT m FROM Movimentacao m WHERE m.conta = :pConta"; //os 2 pontos indicam que é um parâmetro [o "p" é só por conveção, ajuda na leitura]
		
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta); //não necessário se a buscar for feita por meio do Id
		
		List<Movimentacao> restulList = query.getResultList();
		
		for (Movimentacao movimentacao : restulList) {
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
		}
		
	}

}
