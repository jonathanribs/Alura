package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.alura.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long>{

	List<Topico> findByCursoNome(String nomeCurso); //em caso de ambiguidade (tendo um atributo cursoNome na Entity Topico, por exemplo), para acessar o relacionamento curso e lá dentro o atributo nome, é só usar underline Curso_Nome

	//Exemplo caso queira definir um nome personalizado para o método (perdemos a vantagem do Spring montar a query automaticamente)
	@Query("SELECT t FROM Topico t WHERE t.curso.nome = :nomeCurso")
	List<Topico> carregarPorNomeDoCurso(@Param("nomeCurso") String nomeCurso);
}
