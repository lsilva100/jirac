package com.jirac.jirac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jirac.jirac.dtos.AtividadeCreateRequestDTO;
import com.jirac.jirac.dtos.AtividadeUpdateDTO;
import com.jirac.jirac.entity.Atividade;
import com.jirac.jirac.entity.Usuario;
import com.jirac.jirac.mappers.AtividadeMapper;
import com.jirac.jirac.repository.AtividadeRepository;
import com.jirac.jirac.repository.ProjetoRepository;
import com.jirac.jirac.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

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


    @Transactional 
    public Atividade salvar(AtividadeCreateRequestDTO atividadeCreateRequestDTO) {
        
        Long idProjeto = atividadeCreateRequestDTO.getIdProjeto();

        projetoRepository.findById(idProjeto).orElseThrow(() -> new AtividadeMustHaveProjectException(idProjeto));

        Atividade atividade = atividadeMapper.toEntity(atividadeCreateRequestDTO);

        return atividadeRepository.save(atividade);

    }

    public List<Atividade> listar() {
        return atividadeRepository.findAll();
    }

    public Optional<List<Atividade>> listarEmAtraso() {

        return atividadeRepository.findAtrasado();
    
    }

    public Optional<Atividade> buscar(Long id) {
        return atividadeRepository.findById(id);
    }

    @Transactional 
    public Atividade atualizar(Long idAtividade, AtividadeUpdateDTO atividadeUpdateDTO)
    {
        Atividade atividade = atividadeRepository.findById(idAtividade).orElseThrow(() -> new AtividadeNotFoundException(idAtividade));

        if (atividadeUpdateDTO.getIdResponsavel() != null) {
            Usuario responsavel = usuarioRepository.findById(atividadeUpdateDTO.getIdResponsavel()).orElseThrow(() -> new AtividadeMustHaveUserException(atividadeUpdateDTO.getIdResponsavel()));
            atividade.setResponsavel(responsavel);
        }

        atividadeMapper.updateAtividade(atividadeUpdateDTO, atividade);
        return atividade;
            
    }

    public void apagar(Long id) {
        atividadeRepository.deleteById(id);
    }

}
