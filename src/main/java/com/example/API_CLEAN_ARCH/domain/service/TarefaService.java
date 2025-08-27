package com.example.API_CLEAN_ARCH.domain.service;

import com.example.API_CLEAN_ARCH.domain.model.Tarefa;

import java.util.List;

public interface TarefaService {
    List<Tarefa> getAllTarefas();
    Tarefa getTarefaById(Long id);
    Tarefa createTarefa(Tarefa tarefa);
    Tarefa updateTarefa(Long id, Tarefa tarefa);
    void deleteTarefa(Long id);
}
