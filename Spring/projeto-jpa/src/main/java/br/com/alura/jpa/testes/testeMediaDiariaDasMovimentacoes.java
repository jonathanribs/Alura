package br.com.alura.jpa.testes;

import java.util.List;

import br.com.alura.jpa.modelo.MediaComData;
import br.com.alura.jpa.modelo.dao.MovimentacaoDao;

public class testeMediaDiariaDasMovimentacoes {
	public static void main(String[] args) {

		List<MediaComData> mediaDasMovimentacoes = new MovimentacaoDao().getMediaDiariaDasMovimentacoes();
		
		for (MediaComData resultado : mediaDasMovimentacoes) {
			System.out.println("A media das movimentacoes do dia " + resultado.getDia() + "/" + resultado.getMes() + " é: " + resultado.getValor());
		}

	}
	
}
