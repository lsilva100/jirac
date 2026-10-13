package com.jirac.jirac.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.lang.reflect.Field;

import org.springframework.stereotype.Service;

import com.jirac.jirac.dtos.AtividadeCreateRequestDTO;
import com.jirac.jirac.dtos.AtividadeUpdateDTO;
import com.jirac.jirac.entity.Atividade;
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

    @Transactional 
    public Atividade atualizar(Long idAtividade, AtividadeUpdateDTO atividadeUpdateDTO)
    {
        Atividade atividade = atividadeRepository.findById(idAtividade).orElseThrow(() -> new AtividadeNotFoundException(idAtividade));

        Field[] camposDto = AtividadeUpdateDTO.class.getDeclaredFields();

        Map<String, Object> camposParaAtualizar = new HashMap<>();
        for (Field campo : camposDto) {
            try {
                if (campo.get(atividadeUpdateDTO) == null)
                    continue;
                camposParaAtualizar.put(campo.getName(), campo.get(atividadeUpdateDTO));
            }
            catch (IllegalAccessException ex){
                continue;
            }
        }

        for (Map.Entry<String, Object> campo : camposParaAtualizar.entrySet()) {
            String propName = campo.getKey();
            Object newValue = campo.getValue();

            try {
                Field atividadeCampo = atividade.getClass().getDeclaredField(propName);
                atividadeCampo.setAccessible(true);
                atividadeCampo.set(atividade, newValue);
            }
            catch (NoSuchFieldException | IllegalAccessException ex){
                continue;
            }
        }
        return atividade;
            
    }

    public void apagar(Long id) {
        atividadeRepository.deleteById(id);
    }

}
