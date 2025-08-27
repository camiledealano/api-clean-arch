package com.example.API_CLEAN_ARCH.domain.repository;

import com.example.API_CLEAN_ARCH.domain.model.Tarefa;

import java.util.List;

public interface TarefaRepository {

    List<Tarefa> findAll();
    Tarefa findById(Long id);
    Tarefa save(Tarefa user);
    void deleteById(Long id);
}
