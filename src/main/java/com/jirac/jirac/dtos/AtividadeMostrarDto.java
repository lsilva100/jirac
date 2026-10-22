package com.jirac.jirac.dtos;

import com.jirac.jirac.enums.Prioridade;
import com.jirac.jirac.enums.StatusProjeto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AtividadeMostrarDto {
    private String nome;
    private String descricao;
    private Prioridade prioridade;
    private StatusProjeto status;
    private String dataEncerramento;
    private String nomeResponsavel;
    private String nomeProjeto;
    private String descricaoProjeto;
}
