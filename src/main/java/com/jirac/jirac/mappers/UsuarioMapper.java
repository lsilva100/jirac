package com.jirac.jirac.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.jirac.jirac.dtos.UsuarioEditarDto;
import com.jirac.jirac.dtos.UsuarioLoginDto;
import com.jirac.jirac.dtos.UsuarioMostrarDto;
import com.jirac.jirac.entity.Usuario;

@Mapper (componentModel = "spring")
public interface UsuarioMapper {

    @Mapping (source = "nascimento", target = "dataNascimento")
    Usuario toEntity(UsuarioLoginDto usuarioLoginDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping (source = "nascimento", target = "dataNascimento")
    void updateUsuario(UsuarioEditarDto dto, @MappingTarget Usuario entity);

    @Mapping (source = "dataNascimento", target = "nascimento")
    UsuarioMostrarDto toMostrarDto(Usuario usuario);
}
