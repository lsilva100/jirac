package com.jirac.jirac.entity;

import java.time.LocalDateTime;

import com.jirac.jirac.enums.Prioridade;
import com.jirac.jirac.enums.StatusProjeto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Future;

@Entity
public class Atividade extends Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private String descricao;

    private Prioridade prioridade;
    private StatusProjeto status;
    @Future
    private LocalDateTime dataEncerramento;

    @ManyToOne
    private Usuario responsavel;

    @ManyToOne
    private Projeto projeto;

    public Atividade(String nome, String descricao, Prioridade prioridade, StatusProjeto status,
            @Future LocalDateTime dataEncerramento, Usuario responsavel, Projeto projeto) {
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = status;
        this.dataEncerramento = dataEncerramento;
        this.responsavel = responsavel;
        this.projeto = projeto;
    }

    public Atividade(LocalDateTime dataCriacao, LocalDateTime dataModificacao, String nome, String descricao,
            Prioridade prioridade, StatusProjeto status, @Future LocalDateTime dataEncerramento, Usuario responsavel,
            Projeto projeto) {
        super(dataCriacao, dataModificacao);
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = status;
        this.dataEncerramento = dataEncerramento;
        this.responsavel = responsavel;
        this.projeto = projeto;
    }

    public Atividade() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public StatusProjeto getStatus() {
        return status;
    }

    public void setStatus(StatusProjeto status) {
        this.status = status;
    }

    public LocalDateTime getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(LocalDateTime dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

}
