package br.com.alura.spring.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.spring.data.orm.Cargo;
import br.com.alura.spring.data.orm.Funcionario;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer>{
	//o próprio Spring Data reconhece os comandos que queremos pelo nome do método e cria a consulta SQL automaticamente
	List<Funcionario> findByNome(String nome);//no caso, como é uma busca, colocando o "findBy" ele já cria de acordo com os parâmetros que colocamos, e se colocarmos "And" ele entende que são parâmetros diferentes
}
