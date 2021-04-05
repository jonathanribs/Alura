package escola;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

	//ENTIDADE
	
	private CPF cpf;
	private String nome;
	private Email email;
	private List<Telefone> telefone = new ArrayList<>(); //importante iniciar inicialmente para já criar uma lista vazia, pois se for uma lista nula pode dar problemas a frente
	
	
	public Aluno(CPF cpf, String nome, Email email) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}

	
	public void adicionarTelefone(String ddd, String numero) {
		this.telefone.add(new Telefone(ddd, numero));
	}

	public CPF getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public Email getEmail() {
		return email;
	}

	public List<Telefone> getTelefone() {
		return telefone;
	}

}
