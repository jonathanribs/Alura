package escola;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

	//ENTIDADE
	
	private CPF cpf;
	private String nome;
	private Email email;
	private List<Telefone> telefone = new ArrayList<>(); //importante iniciar inicialmente para j� criar uma lista vazia, pois se for uma lista nula pode dar problemas a frente
	
	public void adicionarTelefone(String ddd, String numero) {
		this.telefone.add(new Telefone(ddd, numero));
	}
}
