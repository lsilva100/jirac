package com.jirac.jirac.dtos;

import com.jirac.jirac.enums.Prioridade;
import com.jirac.jirac.enums.StatusProjeto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AtividadeNoProjetoMostrarDto {

    private String nome;
    private String descricao;
    private Prioridade prioridade;
    private StatusProjeto status;
}
