package com.jirac.jirac.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Length;

import com.jirac.jirac.enums.Cargo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

@Entity
public class Usuario extends Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(min = 3, max = 100)
    private String nome;

    @Length(min = 11, max = 11)
    @Pattern(regexp = "^d{11}$")
    @Column(unique = true)
    private String cpf;

    private LocalDate dataNascimento;

    @Email
    @Column(unique = true)
    private String email;

    @Pattern(regexp = "^d{13}$")
    @Column(unique = true)
    private String telefone;

    private Cargo cargo;

    public Usuario(LocalDateTime dataCriacao, LocalDateTime dataModificacao, String nome,
            @Length(min = 11, max = 11) String cpf, LocalDate dataNascimento, @Email String email,
            @Pattern(regexp = "^d{13}$") String telefone, Cargo cargo) {
        super(dataCriacao, dataModificacao);
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.cargo = cargo;
    }

    public Usuario(String nome, @Length(min = 11, max = 11) String cpf, LocalDate dataNascimento, @Email String email,
            @Pattern(regexp = "^d{13}$") String telefone, Cargo cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.cargo = cargo;
    }

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
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
