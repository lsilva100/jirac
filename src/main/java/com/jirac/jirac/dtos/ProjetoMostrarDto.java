package com.jirac.jirac.dtos;

import java.time.LocalDateTime;

import com.jirac.jirac.enums.Prioridade;
import com.jirac.jirac.enums.StatusProjeto;

public class ProjetoMostrarDto {
    private String nome;
    private String descricao;
    private LocalDateTime dataEncerramento;
    private Prioridade prioridade;
    private StatusProjeto status;
    private String emailResponsavel;

    public ProjetoMostrarDto(String nome, String descricao, LocalDateTime dataEncerramento, Prioridade prioridade,
            StatusProjeto status, String emailResponsavel) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataEncerramento = dataEncerramento;
        this.prioridade = prioridade;
        this.status = status;
        this.emailResponsavel = emailResponsavel;
    }

    public ProjetoMostrarDto() {
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

    public LocalDateTime getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(LocalDateTime dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
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

    public String getEmailResponsavel() {
        return emailResponsavel;
    }

    public void setEmailResponsavel(String emailResponsavel) {
        this.emailResponsavel = emailResponsavel;
    }

}
