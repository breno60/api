package br.com.atividade.web.service.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Aluno {

    @Id
    private int rdm;
    private String nome;
    private String curso;

    public Aluno(int rdm, String nome, String curso) {
        this.rdm = rdm;
        this.nome = nome;
        this.curso = curso;
    }

    public Aluno() {

    }

}
