package com.example.API_CLEAN_ARCH.application.usercases;

import com.example.API_CLEAN_ARCH.application.dto.TarefaRequest;
import com.example.API_CLEAN_ARCH.application.dto.TarefaResponse;

import java.util.List;

public interface TarefaUserCase {

    List<TarefaResponse> getAllTarefas();
    TarefaResponse getTarefaById(Long id);
    TarefaResponse createTarefa(TarefaRequest tarefaRequest);
    TarefaResponse updateTarefa(Long id, TarefaRequest tarefaRequest);
    void deleteTarefa(Long id);
}
