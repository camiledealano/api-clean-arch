package com.example.API_CLEAN_ARCH.infrastructure.persistence.repository;

import com.example.API_CLEAN_ARCH.domain.model.Tarefa;
import com.example.API_CLEAN_ARCH.domain.repository.TarefaRepository;
import com.example.API_CLEAN_ARCH.infrastructure.persistence.entity.TarefaEntity;
import com.example.API_CLEAN_ARCH.infrastructure.persistence.mapper.TarefaEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TarefaRepositoryImpl implements TarefaRepository {

    private final TarefaJpaRepository tarefaJpaRepository;
    private final TarefaEntityMapper tarefaEntityMapper;

    public TarefaRepositoryImpl(TarefaJpaRepository tarefaJpaRepository, TarefaEntityMapper tarefaEntityMapper) {
        this.tarefaJpaRepository = tarefaJpaRepository;
        this.tarefaEntityMapper = tarefaEntityMapper;
    }

    @Override
    public List<Tarefa> findAll() {
        return tarefaJpaRepository.findAll().stream()
                .map(tarefaEntityMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Tarefa findById(Long id) {
        return tarefaJpaRepository.findById(id)
                .map(tarefaEntityMapper::toDomain)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com id: " + id));
    }

    @Override
    public Tarefa save(Tarefa user) {
        TarefaEntity userEntity = tarefaEntityMapper.toEntity(user);
        TarefaEntity savedEntity = tarefaJpaRepository.save(userEntity);
        return tarefaEntityMapper.toDomain(savedEntity);
    }

    @Override
    public void deleteById(Long id) {
        tarefaJpaRepository.deleteById(id);
    }
}
