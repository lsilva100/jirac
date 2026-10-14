package com.jirac.jirac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jirac.jirac.dtos.ProjetoCriarDto;
import com.jirac.jirac.dtos.ProjetoMostrarDto;
import com.jirac.jirac.entity.Projeto;
import com.jirac.jirac.enums.StatusProjeto;
import com.jirac.jirac.repository.ProjetoRepository;
import com.jirac.jirac.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class ProjetoService {

    private final ProjetoRepository projetoRepository;
    private final UsuarioRepository usuarioRepository;

    public ProjetoService(ProjetoRepository projetoRepository, UsuarioRepository usuarioRepository) {
        this.projetoRepository = projetoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public ProjetoMostrarDto salvar(ProjetoCriarDto projetoCriarDto) {
        Projeto p = new Projeto(projetoCriarDto.getNome(), projetoCriarDto.getDescricao(),
                projetoCriarDto.getDataEncerramento(), projetoCriarDto.getPrioridade(), StatusProjeto.EM_ANDAMENTO,
                usuarioRepository.findByEmail(projetoCriarDto.getEmailResponsavel()).get());
        projetoRepository.save(p);
        return new ProjetoMostrarDto(p.getNome(), p.getDescricao(),
                p.getDataEncerramento(), p.getPrioridade(), p.getStatus(),
                p.getNome());
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
