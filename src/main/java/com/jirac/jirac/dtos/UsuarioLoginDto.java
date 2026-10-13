package com.jirac.jirac.dtos;

import java.time.LocalDate;

import com.jirac.jirac.enums.Cargo;

public class UsuarioLoginDto {
    private String nome;
    private String cpf;
    private LocalDate nascimento;
    private String email;
    private String telefone;
    private Cargo cargo;

    public UsuarioLoginDto(String nome, String cpf, LocalDate nascimento, String email, String telefone, Cargo cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.email = email;
        this.telefone = telefone;
        this.cargo = cargo;
    }

    public UsuarioLoginDto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

}
