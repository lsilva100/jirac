package com.jirac.jirac.dtos;

import java.time.LocalDate;

import com.jirac.jirac.enums.Cargo;

public class UsuarioMostrarDto {
    private String nome;
    private LocalDate nascimento;
    private String email;
    private String telefone;
    private Cargo cargo;

    public UsuarioMostrarDto(String nome, LocalDate nascimento, String email, String telefone, Cargo cargo) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
        this.telefone = telefone;
        this.cargo = cargo;
    }

    public UsuarioMostrarDto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
