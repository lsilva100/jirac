package com.jirac.jirac.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.SoftDelete;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jirac.jirac.enums.Prioridade;
import com.jirac.jirac.enums.StatusProjeto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Future;

@Entity
@SoftDelete(columnName = "deletado")
public class Projeto extends Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String descricao;

    @Future
    private LocalDateTime dataEncerramento;

    private Prioridade prioridade;

    private StatusProjeto status;

    @ManyToOne
    private Usuario responsavel;

    @OneToMany
    @JsonIgnore
    private List<Atividade> atividades;

    public Projeto(String nome, String descricao, @Future LocalDateTime dataEncerramento, Prioridade prioridade,
            StatusProjeto status, Usuario responsavel, List<Atividade> atividades) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataEncerramento = dataEncerramento;
        this.prioridade = prioridade;
        this.status = status;
        this.responsavel = responsavel;
        this.atividades = atividades;
    }

    public Projeto(LocalDateTime dataCriacao, LocalDateTime dataModificacao, String nome, String descricao,
            @Future LocalDateTime dataEncerramento, Prioridade prioridade, StatusProjeto status, Usuario responsavel,
            List<Atividade> atividades) {
        super(dataCriacao, dataModificacao);
        this.nome = nome;
        this.descricao = descricao;
        this.dataEncerramento = dataEncerramento;
        this.prioridade = prioridade;
        this.status = status;
        this.responsavel = responsavel;
        this.atividades = atividades;
    }

    public Projeto() {
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

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

}
