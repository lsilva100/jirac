package com.jirac.jirac.mappers;

import java.util.List;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.jirac.jirac.dtos.AtividadeCreateRequestDTO;
import com.jirac.jirac.dtos.AtividadeMostrarDto;
import com.jirac.jirac.dtos.AtividadeNoProjetoMostrarDto;
import com.jirac.jirac.dtos.AtividadeUpdateDTO;
import com.jirac.jirac.entity.Atividade;

@Mapper(componentModel = "spring")
public interface AtividadeMapper {

    @Mapping(source = "idProjeto", target = "projeto.id")
    @Mapping(source = "idResponsavel", target = "responsavel.id")
    Atividade toEntity(AtividadeCreateRequestDTO atividadeCreateRequestDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "responsavel", ignore = true)
    void updateAtividade(AtividadeUpdateDTO dto, @MappingTarget Atividade entity);

    @Mapping(source = "dataEncerramento", target = "dataEncerramento", dateFormat = "dd-MM-yyyy")
    @Mapping(source = "responsavel.nome", target = "nomeResponsavel")
    @Mapping(source = "projeto.nome", target = "nomeProjeto")
    @Mapping(source = "projeto.descricao", target = "descricaoProjeto")
    AtividadeMostrarDto toDto(Atividade atividade);

    @Mapping(source = "dataEncerramento", target = "dataEncerramento", dateFormat = "dd-MM-yyyy")
    @Mapping(source = "responsavel.nome", target = "nomeResponsavel")
    @Mapping(source = "projeto.nome", target = "nomeProjeto")
    @Mapping(source = "projeto.descricao", target = "descricaoProjeto")
    List<AtividadeMostrarDto> toDtoList(List<Atividade> atividades);

    
    AtividadeNoProjetoMostrarDto paraDtoProjeto(Atividade atividade);

    List<AtividadeNoProjetoMostrarDto> paraDtoProjetoLista(List<Atividade> atividade);

}
