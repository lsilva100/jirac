package com.jirac.jirac.dtos;

import java.time.LocalDateTime;

import com.jirac.jirac.enums.Prioridade;
import com.jirac.jirac.enums.StatusProjeto;

import jakarta.validation.constraints.Future;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor 
@AllArgsConstructor 
@Getter 
@Setter 
public class AtividadeUpdateDTO {

    private String nome;

    private String descricao;

    private Prioridade prioridade;
    
    private StatusProjeto status;

    @Future
    private LocalDateTime dataEncerramento;

    private Long idResponsavel;
  
}
