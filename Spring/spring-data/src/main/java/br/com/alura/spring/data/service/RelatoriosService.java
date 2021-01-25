package br.com.alura.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.repository.FuncionarioRepository;

@Service
public class RelatoriosService {
	
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
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
			System.out.println("2 - Busca funcionario por nome, data contratacao e salario maior");
//			System.out.println("3 - Visualizar");
//			System.out.println("4 - Deletar");
			
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				buscaFucionarioNome(scanner);
				break;
			case 2:
				buscaFuncionarioNomeSalarioMaiorData(scanner);
				break;
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
	
	private void buscaFuncionarioNomeSalarioMaiorData(Scanner scanner) {
		System.out.println("Qual nome deseja pesquisar");
		String nome = scanner.next();
		
		System.out.println("Qual data contratacao");
		String data = scanner.next();
		LocalDate localDate = LocalDate.parse(data, formatter);
		
		System.out.println("Qual salario");
		Double salario = scanner.nextDouble();
		
		List<Funcionario> list = funcionarioRepository.findByNomeAndSalarioGreaterThanAndDataContratacao(nome, salario, localDate);
		list.forEach(System.out::println);
	}
}
