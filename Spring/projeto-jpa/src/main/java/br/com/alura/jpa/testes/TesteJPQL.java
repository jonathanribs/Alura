package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TesteJPQL {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setId(2L);
		String jpql = "SELECT m FROM Movimentacao m WHERE m.conta = :pConta order by m.valor desc"; 
		//os 2 pontos indicam que � um par�metro [o "p" � s� por conve��o, ajuda na leitura]

		//antes havia um aviso de que o tipo n�o era testado, inclusive sendo poss�vel passar na JPQL uma classe diferente de Movimentacao, levando a quebra quando o resultado fosse utilizado
		//para evitar este problema � usado a Query "tipada"
		TypedQuery<Movimentacao> query = em.createQuery(jpql, Movimentacao.class); 
		query.setParameter("pConta", conta); 
		
		List<Movimentacao> restulList = query.getResultList();
		
		for (Movimentacao movimentacao : restulList) {
			System.out.println("Descri��o: " + movimentacao.getDescricao());
			System.out.println("Valor: " + movimentacao.getValor());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentacao());
		}
		
	}

}
