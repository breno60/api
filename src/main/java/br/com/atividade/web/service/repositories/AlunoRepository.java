package br.com.atividade.web.service.repositories;

import br.com.atividade.web.service.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
