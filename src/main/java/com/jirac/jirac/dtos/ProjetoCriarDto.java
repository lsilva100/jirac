package com.jirac.jirac.dtos;

import java.time.LocalDateTime;

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
public class ProjetoCriarDto {

    private String nome;
    private String descricao;
    private LocalDateTime dataEncerramento;
    private Prioridade prioridade;
    private StatusProjeto statusProjeto;
    private String emailResponsavel;
}
