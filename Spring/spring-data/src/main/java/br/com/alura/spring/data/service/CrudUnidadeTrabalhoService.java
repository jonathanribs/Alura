package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.UnidadeTrabalho;
import br.com.alura.spring.data.repository.UnidadeTrabalhoRepository;

@Service
public class CrudUnidadeTrabalhoService {

	private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;
	//private Boolean system = true;

	//Construtor
	public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
		this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
	}
	
	//Métodos
	public void inicial(Scanner scanner) {
		Boolean system = true;
		while(system) {
			System.out.println("Qual acao de unidade deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");
			
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				this.salvar(scanner);
				break;
			case 2:
				this.atualizar(scanner);
				break;
			case 3:
				this.visualizar();
				break;
			case 4:
				this.deletar(scanner);
				break;
			default:
				system = false;
				break;
			}
			
		}

	}
	
	private void salvar(Scanner scanner) {
		System.out.println("Descricao da UnidadeTrabalho");
		String descricao = scanner.next();
		System.out.println("Endereco da UnidadeTrabalho");
		String endereco = scanner.next();
		
		UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
		unidadeTrabalho.setDescricao(descricao);
		unidadeTrabalho.setEndereco(endereco);
		
		unidadeTrabalhoRepository.save(unidadeTrabalho);
		
		System.out.println("Salvo");
	}
	
	private void atualizar(Scanner scanner) {
		System.out.println("Id");
		int id = scanner.nextInt();
		System.out.println("Nova Descricao da UnidadeTrabalho");
		String descricao = scanner.next();
		System.out.println("Novo Endereco da UnidadeTrabalho");
		String endereco = scanner.next();
		
		UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
		unidadeTrabalho.setId(id);
		unidadeTrabalho.setDescricao(descricao);
		unidadeTrabalho.setEndereco(endereco);
		
		unidadeTrabalhoRepository.save(unidadeTrabalho);
		
		System.out.println("Atualizado");
	}
	
	private void visualizar() {
		Iterable<UnidadeTrabalho> unidadeTrabalhos= unidadeTrabalhoRepository.findAll();
		unidadeTrabalhos.forEach(unidade -> System.out.println(unidade));
	}
	
	private void deletar(Scanner scanner) {
		System.out.println("Id");
		int id = scanner.nextInt();
		
		unidadeTrabalhoRepository.deleteById(id);
		
		System.out.println("Deletado");
	}
	
}
