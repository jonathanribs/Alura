package br.com.alura.spring.data.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;

@Service
public class RelatoriosService {
	
	private final FuncionarioRepository funcionarioRepository;

	//Construtor
	public RelatoriosService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	//Métodos
	public void inicial(Scanner scanner) {
		
		Boolean system = true;
		
		while(system) {
			System.out.println("Qual acao de cargo deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Busca funcionario por nome");
//			System.out.println("2 - Atualizar");
//			System.out.println("3 - Visualizar");
//			System.out.println("4 - Deletar");
			
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				buscaFucionarioNome(scanner);
				break;
//			case 2:
//				this.atualizar(scanner);
//				break;
//			case 3:
//				this.visualizar();
//				break;
//			case 4:
//				this.deletar(scanner);
//				break;
			default:
				system = false;
				break;
			}
			
		}
	}
	
	private void buscaFucionarioNome(Scanner scanner) {
		System.out.println("Qual nome deseja pesquisa");
		String nome = scanner.next();
		List<Funcionario> list = funcionarioRepository.findByNome(nome);
		list.forEach(System.out::println);
	}
	
}
