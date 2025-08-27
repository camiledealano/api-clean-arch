package com.example.API_CLEAN_ARCH.infrastructure.controller;

import com.example.API_CLEAN_ARCH.application.dto.TarefaRequest;
import com.example.API_CLEAN_ARCH.application.dto.TarefaResponse;
import com.example.API_CLEAN_ARCH.application.mapper.TarefaMapper;
import com.example.API_CLEAN_ARCH.application.usercases.TarefaUserCase;
import com.example.API_CLEAN_ARCH.domain.model.Tarefa;
import com.example.API_CLEAN_ARCH.domain.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaContoller implements TarefaUserCase {

    private final TarefaService tarefaService;
    private final TarefaMapper tarefaMapper;

    public TarefaContoller(TarefaService tarefaService, TarefaMapper tarefaMapper) {
        this.tarefaService = tarefaService;
        this.tarefaMapper = tarefaMapper;
    }


    @Override
    @GetMapping
    public List<TarefaResponse> getAllTarefas() {
        return tarefaService.getAllTarefas().stream()
                .map(tarefaMapper::toResponse)
                .toList();
    }

    @Override
    @GetMapping("/{id}")
    public TarefaResponse getTarefaById(@PathVariable Long id) {
        Tarefa tarefa = tarefaService.getTarefaById(id);
        return tarefaMapper.toResponse(tarefa);
    }

    @Override
    @PostMapping
    public TarefaResponse createTarefa(@RequestBody TarefaRequest tarefaRequest) {
        Tarefa tarefa = tarefaMapper.toDomain(tarefaRequest);
        Tarefa createdTarefa = tarefaService.createTarefa(tarefa);
        TarefaResponse response = tarefaMapper.toResponse(createdTarefa);

        return ResponseEntity.created(URI.create("/tarefas/" + createdTarefa.getId()))
                .body(response).getBody();
    }

    @Override
    @PutMapping("/{id}")
    public TarefaResponse updateTarefa(@PathVariable Long id, @RequestBody TarefaRequest tarefaRequest) {
        Tarefa user = tarefaMapper.toDomain(tarefaRequest);
        Tarefa updatedTarefa = tarefaService.updateTarefa(id, user);
        return tarefaMapper.toResponse(updatedTarefa);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteTarefa(@PathVariable Long id) {
        tarefaService.deleteTarefa(id);
    }
}
