package br.com.alura.jpa.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titular;
	private Integer agencia;
	private Integer numero;
	private Double saldo;
	@OneToMany(mappedBy="conta", fetch = FetchType.EAGER) //uma conta pode ter varias movimentacoes. O mappedBy diz que este relacionamento já está mapeado no atributo "conta" da classe 'abaixo', no caso "movimentacoes"
	//o atributo fetch foi colocado para mudar o padrão de carregamento Lazy(que significa que os dados de um relacionamento *toMany só são carregados na hora de serem usados). Com "eager" os dados são carregados antecipadamente como os atributos normais 
	private List<Movimentacao> movimentacoes;

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Movimentacao> getMovimentacoes() {
		return this.movimentacoes;
	}
}