package br.com.atividade.web.service.controllers;



import br.com.atividade.web.service.models.Aluno;
import br.com.atividade.web.service.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @GetMapping()
    public ResponseEntity<List<Aluno>> getAlunos () {
        return new ResponseEntity<List<Aluno>>(alunoService.listarAlunos(), HttpStatus.FOUND);
    }

    @GetMapping("{rdm}")
    public ResponseEntity<Optional<Aluno>> alunoPorId (@PathVariable int rdm) {
        return new ResponseEntity<>(alunoService.alunoPorId(rdm), HttpStatus.OK);
    }

    @PostMapping("/criar")
    public ResponseEntity<Aluno> criarAluno (@RequestBody Aluno aluno) {
        return new ResponseEntity<>(alunoService.criarAluno(aluno), HttpStatus.CREATED);
    }

    @PutMapping("/atualizar{rdm}")
    public ResponseEntity<Optional<Aluno>> atualizarAluno (@PathVariable int rdm, @RequestBody Aluno aluno) {
        if (alunoService.atualizarAluno(rdm, aluno)) {
            return new ResponseEntity<>(alunoService.alunoPorId(rdm), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(alunoService.alunoPorId(rdm), HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{rdm}")
    public ResponseEntity<List<Aluno>> deletarAluno (@PathVariable int rdm) {
        if (alunoService.deletarAluno(rdm)) {
            return new ResponseEntity<>(alunoService.listarAlunos(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(alunoService.listarAlunos(), HttpStatus.OK);
    }

}
