package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestaRelatorioDasMovimentacoes {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		//String jpql = "select sum(m.valor) from Movimentacao m";//soma
		String jpql = "select avg(m.valor) from Movimentacao m"; //media
		
		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		Double mediaDasMovimentacoes = query.getSingleResult();
		
		System.out.println("A soma das movimentacoes �: " + mediaDasMovimentacoes);
		
	}
		
		
}
