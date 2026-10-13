package com.jirac.jirac.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.jirac.jirac.dtos.AtividadeCreateRequestDTO;
import com.jirac.jirac.entity.Atividade;

@Mapper (componentModel = "spring")
public interface AtividadeMapper {

    @Mapping (source = "idProjeto", target = "projeto.id")
    @Mapping (source = "idResponsavel", target = "responsavel.id")
    Atividade toEntity(AtividadeCreateRequestDTO atividadeCreateRequestDTO);
}
