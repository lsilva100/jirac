package com.jirac.jirac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jirac.jirac.dtos.ProjetoCriarDto;
import com.jirac.jirac.dtos.ProjetoMostrarDto;
import com.jirac.jirac.dtos.ProjetoUpdateDTO;
import com.jirac.jirac.entity.Projeto;
import com.jirac.jirac.entity.Usuario;
import com.jirac.jirac.exceptions.ProjetoMustHaveUserException;
import com.jirac.jirac.exceptions.ProjetoNotFoundException;
import com.jirac.jirac.mappers.ProjetoMapper;
import com.jirac.jirac.repository.ProjetoRepository;
import com.jirac.jirac.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class ProjetoService {

    private final ProjetoRepository projetoRepository;
    private final UsuarioRepository usuarioRepository;
    private final ProjetoMapper projetoMapper;

    public ProjetoService(ProjetoRepository projetoRepository, UsuarioRepository usuarioRepository, ProjetoMapper projetoMapper) {
        this.projetoRepository = projetoRepository;
        this.usuarioRepository = usuarioRepository;
        this.projetoMapper = projetoMapper;
    }

    @Transactional
    public ProjetoMostrarDto salvar(ProjetoCriarDto projetoCriarDto) {
        Projeto p = projetoMapper.toEntity(projetoCriarDto);
        p.setResponsavel(usuarioRepository.findByEmail(projetoCriarDto.getEmailResponsavel()).get());
        projetoRepository.save(p);
        return projetoMapper.toMostrarDto(p);
    }

    @Transactional
    public ProjetoMostrarDto atualizar(Long id, ProjetoUpdateDTO projetoUpdateDTO) {
        Projeto projeto = projetoRepository.findById(id).orElseThrow(() -> new ProjetoNotFoundException(id));

        if (projetoUpdateDTO.getIdResponsavel() != null) {
            Usuario responsavel = usuarioRepository.findById(projetoUpdateDTO.getIdResponsavel()).orElseThrow(() -> new ProjetoMustHaveUserException(projetoUpdateDTO.getIdResponsavel()));
            projeto.setResponsavel(responsavel);
        }

        projetoMapper.updateProjeto(projetoUpdateDTO, projeto);
        return projetoMapper.toMostrarDto(projeto);
    }

    public List<Projeto> listar() {
        return projetoRepository.findAll();
    }

    public Optional<Projeto> buscar(Long id) {
        return projetoRepository.findById(id);
    }

    public void apagar(Long id) {
        projetoRepository.deleteById(id);
    }

    public Optional<Projeto> encontrarNome(String nome) {
        return projetoRepository.findByNome(nome);
    }
}
