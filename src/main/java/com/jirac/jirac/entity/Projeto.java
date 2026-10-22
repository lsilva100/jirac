package com.jirac.jirac.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.SoftDelete;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jirac.jirac.enums.Prioridade;
import com.jirac.jirac.enums.StatusProjeto;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Future;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Projeto extends Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    private String descricao;

    @Future
    private LocalDateTime dataEncerramento;

    @Nullable
    private Prioridade prioridade;

    private StatusProjeto status;

    @ManyToOne
    private Usuario responsavel;

    @OneToMany
    @JsonIgnore
    @Nullable
    private List<Atividade> atividades;

    public Projeto(String nome, String descricao, @Future LocalDateTime dataEncerramento, Prioridade prioridade,
            StatusProjeto status, Usuario responsavel) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataEncerramento = dataEncerramento;
        this.prioridade = prioridade;
        this.status = status;
        this.responsavel = responsavel;
    }
}
