package com.example.ex4.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "Autor")
@Table(name = "tb_autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_autor")
    private String nome;

    @Column(name = "nacionalidade_autor")
    private String nacionalidade;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    public Autor() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
