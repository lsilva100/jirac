package com.jirac.jirac.dtos;

import java.time.LocalDateTime;

import com.jirac.jirac.enums.Prioridade;
import com.jirac.jirac.enums.StatusProjeto;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Future;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor 
@AllArgsConstructor 
@RequiredArgsConstructor 
@Getter 
@Setter 
public class AtividadeCreateRequestDTO {

    private String nome;

    private String descricao;

    private Prioridade prioridade;
    
    private StatusProjeto status;

    @Future
    private LocalDateTime dataEncerramento;

    private Long idResponsavel;

    @Nonnull 
    private Long idProjeto;
    
}
