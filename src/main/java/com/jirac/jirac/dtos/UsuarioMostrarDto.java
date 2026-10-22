package com.jirac.jirac.dtos;

import java.time.LocalDate;

import com.jirac.jirac.enums.Cargo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioMostrarDto {
    private String nome;
    private LocalDate nascimento;
    private String email;
    private String telefone;
    private Cargo cargo;
}
