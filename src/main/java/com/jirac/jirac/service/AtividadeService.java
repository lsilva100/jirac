package com.jirac.jirac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jirac.jirac.dtos.AtividadeCreateRequestDTO;
import com.jirac.jirac.entity.Atividade;
import com.jirac.jirac.mappers.AtividadeMapper;
import com.jirac.jirac.repository.AtividadeRepository;
import com.jirac.jirac.repository.ProjetoRepository;
import com.jirac.jirac.repository.UsuarioRepository;
import com.jirac.jirac.exceptions.*;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;



@Service
@RequiredArgsConstructor  
@Getter 
@Setter 
public class AtividadeService {

    private final AtividadeRepository atividadeRepository;
    private final ProjetoRepository projetoRepository;
    private final UsuarioRepository usuarioRepository;
    private final AtividadeMapper atividadeMapper;


    public Atividade salvar(AtividadeCreateRequestDTO atividadeCreateRequestDTO) {
        
        Long idProjeto = atividadeCreateRequestDTO.getIdProjeto();

        projetoRepository.findById(idProjeto).orElseThrow(() -> new AtividadeMustHaveProjectException(idProjeto));

        Atividade atividade = atividadeMapper.toEntity(atividadeCreateRequestDTO);

        return atividadeRepository.save(atividade);

    }

    public List<Atividade> listar() {
        return atividadeRepository.findAll();
    }

    public Optional<Atividade> buscar(Long id) {
        return atividadeRepository.findById(id);
    }

    public void apagar(Long id) {
        atividadeRepository.deleteById(id);
    }

}
