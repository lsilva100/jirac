package com.jirac.jirac.entity;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import com.jirac.jirac.enums.Cargo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor 
@AllArgsConstructor 
@Getter 
@Setter 
@Entity
public class Usuario extends Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(min = 3, max = 100)
    private String nome;

    @Length(min = 11, max = 11)
    @Pattern(regexp = "^d{11}$")
    @Column(unique = true)
    private String cpf;

    private LocalDate dataNascimento;

    @Email
    @Column(unique = true)
    private String email;

    @Pattern(regexp = "^d{13}$")
    @Column(unique = true)
    private String telefone;

    private Cargo cargo;

}
