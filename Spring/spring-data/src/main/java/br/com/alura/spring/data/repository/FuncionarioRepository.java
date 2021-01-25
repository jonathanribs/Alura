package br.com.alura.spring.data.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.Funcionario;

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer>{
	
	@Query(value = "SELECT * FROM funcionarios f WHERE f.data_contratacao >= :data", nativeQuery = true)
	List<Funcionario> findDataContratacaoMaior(LocalDate data);
	
	@Query("SELECT f FROM Funcionario f WHERE f.nome = :pNome AND f.salario >= :pSalario AND f.dataContratacao = :pData")
	List<Funcionario> findNomeSalarioMaiorDataContratacao(String pNome, Double pSalario, LocalDate pData);
	
	List<Funcionario> findByNome(String nome);//no caso, como é uma busca, colocando o "findBy" ele já cria de acordo com os parâmetros que colocamos, e se colocarmos "And" ele entende que são parâmetros diferentes
}

