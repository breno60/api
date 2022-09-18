package br.com.atividade.web.service.services;

import br.com.atividade.web.service.models.Aluno;
import br.com.atividade.web.service.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    public List<Aluno> listarAlunos () {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> alunoPorId (int id) {
        return alunoRepository.findById(id);
    }

    public Aluno criarAluno (Aluno aluno) {
        return alunoRepository.save(aluno);
    }

//    public boolean atualizarAluno (int rdm, Aluno aluno) {
//        Optional<Aluno> alunoEncontrado = this.alunoPorId(rdm);
//        boolean notFound = true;
//        if (alunoEncontrado.isPresent()) {
//            Aluno alunoAtualizado = alunoEncontrado.get();
//
//            alunoAtualizado.setNome(aluno.getNome());
//            alunoAtualizado.setCurso(aluno.getCurso());
//            notFound = false;
//        }
//
//        return notFound;
//    }

    public Optional<Aluno> atualizarAluno (int rdm, Aluno alunoAtualizado) {

        Optional<Aluno> alunoEncontrado = alunoRepository.findById(rdm);
        return alunoEncontrado.map(aluno -> {
            aluno.setNome(alunoAtualizado.getNome());
            aluno.setCurso(alunoAtualizado.getCurso());
            return aluno;
        });
    
    }

    public boolean deletarAluno (int id) {
        Optional<Aluno> alunoEncontrado = this.alunoPorId(id);
        boolean notFound = true;
        if (alunoEncontrado.isPresent()) {
            alunoRepository.deleteById(id);
            notFound = false;
        }
        return notFound;
    }

}
