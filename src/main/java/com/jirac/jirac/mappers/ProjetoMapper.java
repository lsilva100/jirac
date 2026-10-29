package com.jirac.jirac.mappers;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.jirac.jirac.dtos.ProjetoCriarDto;
import com.jirac.jirac.dtos.ProjetoMostrarDto;
import com.jirac.jirac.dtos.ProjetoUpdateDTO;
import com.jirac.jirac.entity.Projeto;

@Mapper (componentModel = "spring", uses = {AtividadeMapper.class})
public interface ProjetoMapper {

    @Mapping (source = "statusProjeto", target = "status")
    @Mapping (target = "responsavel", ignore = true)
    Projeto toEntity(ProjetoCriarDto projetoCriarDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping (target = "responsavel", ignore = true)
    void updateProjeto(ProjetoUpdateDTO dto, @MappingTarget Projeto entity);

    @Mapping (source = "responsavel.email", target = "emailResponsavel")
    ProjetoMostrarDto toMostrarDto(Projeto projeto);

    @Mapping (source = "responsavel.email", target = "emailResponsavel")
    List<ProjetoMostrarDto> toDtoList(List<Projeto> projeto);
}
