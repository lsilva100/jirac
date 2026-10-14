package com.jirac.jirac.dtos;

import java.time.LocalDateTime;

import com.jirac.jirac.enums.Prioridade;
import com.jirac.jirac.enums.StatusProjeto;

public class ProjetoCriarDto {

    private String nome;
    private String descricao;
    private LocalDateTime dataEncerramento;
    private Prioridade prioridade;
    private StatusProjeto statusProjeto;
    private String emailResponsavel;

    public ProjetoCriarDto(String nome, String descricao, LocalDateTime dataEncerramento, Prioridade prioridade,
            StatusProjeto statusProjeto, String emailResponsavel) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataEncerramento = dataEncerramento;
        this.prioridade = prioridade;
        this.statusProjeto = statusProjeto;
        this.emailResponsavel = emailResponsavel;
    }

    public ProjetoCriarDto() {
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

    public StatusProjeto getStatusProjeto() {
        return statusProjeto;
    }

    public void setStatusProjeto(StatusProjeto statusProjeto) {
        this.statusProjeto = statusProjeto;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public String getEmailResponsavel() {
        return emailResponsavel;
    }

    public void setEmailResponsavel(String emailResponsavel) {
        this.emailResponsavel = emailResponsavel;
    }

}
