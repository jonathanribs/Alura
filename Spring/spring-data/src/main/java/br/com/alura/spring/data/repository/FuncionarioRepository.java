package br.com.alura.spring.data.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.Funcionario;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer>{
	
	@Query(value = "SELECT * FROM funcionarios f WHERE f.data_contratacao >= :data", nativeQuery = true)
	List<Funcionario> findDataContratacaoMaior(LocalDate data);
	
	
	//Com Derived Query Methods, o próprio Spring Data reconhece os comandos que queremos pelo nome do método e cria a consulta SQL automaticamente
	List<Funcionario> findByNome(String nome);//no caso, como é uma busca, colocando o "findBy" ele já cria de acordo com os parâmetros que colocamos, e se colocarmos "And" ele entende que são parâmetros diferentes
	
	//Retorna todos funcionários informando nome, data de contratação e salário maior do que o informado no filtro
	List<Funcionario> findByNomeAndSalarioGreaterThanAndDataContratacao(String nome, Double salario, LocalDate data);
	//Mesmo metodo acima mas em JPQL:
	@Query("SELECT f FROM Funcionario f WHERE f.nome = :pNome AND f.salario >= :pSalario AND f.dataContratacao = :pData")
	List<Funcionario> findNomeSalarioMaiorDataContratacao(String pNome, Double pSalario, LocalDate pData);
	
	//Também é possível acessar os relacionamentos. No caso ele acessa o atributo 'Cargo' e "lá dentro" procura o atributo 'Descricao'
	List<Funcionario> findByCargoDescricao(String descricao);//deve estar no repositório do funcionário
	//Agora em JPQL:
	@Query("SELECT f FROM Funcionario f JOIN f.cargo c WHERE c.descricao = :descricao")
	List<Funcionario> findByCargoPelaDescricao(String descricao);
	//No caso de nomes composto, devemos usar underline:
	List<Funcionario> findByUnidadeTrabalhos_Descricao(String descricao);
	//TALVEZ VALHA A PENA USAR JPQL EM CASOS QUE O NOME SE TORNARIA MUITO COMPLEXO OU FORA DO PADRÃO
}

/* EXEMPLOS (mais em https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods)
//Usando like
 String nome = "%maria%" //o valor do parâmetro deve usar o pattern deste exemplo
 List<Funcionario> findByNomeLike(String nome);
 
 //Starting e Ending
 List<Funcionario> findByNomeEndingWith(String nome);
 List<Funcionario> findByNomeStartingWith(String nome);
 
 //Ordenacao
 List<Funcionario> findByNomeOrderByNomeAsc(String nome);
 
 //Null e not Null
 List<Funcionario> findByNomeIsNull();
 List<Funcionario> findByNomeIsNotNull();

*/
