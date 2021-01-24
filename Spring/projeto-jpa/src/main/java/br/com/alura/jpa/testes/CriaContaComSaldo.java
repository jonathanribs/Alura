package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class CriaContaComSaldo {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();
		conta.setTitular("Márcia");
		conta.setNumero(12345);
		conta.setAgencia(54321);
		conta.setSaldo(100.0);

		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		
		em.close();
		//Como EntityManager fechado, os objetos não são mais managed, ou seja, não estão mais sincronizados
		
		EntityManager em2 = emf.createEntityManager();
		System.out.println("ID da conta da Marcia" + conta.getId());
		conta.setSaldo(500.0); //Detached
				
		em2.getTransaction().begin();
		
		//Detached -> Managed
		em2.merge(conta);
		
		em2.getTransaction().commit();
		
	}
}