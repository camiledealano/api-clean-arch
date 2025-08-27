package com.example.API_CLEAN_ARCH.infrastructure.service;

import com.example.API_CLEAN_ARCH.domain.model.Tarefa;
import com.example.API_CLEAN_ARCH.domain.repository.TarefaRepository;
import com.example.API_CLEAN_ARCH.domain.service.TarefaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TarefaServiceImpl implements TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaServiceImpl(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tarefa> getAllTarefas() {
        return tarefaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Tarefa getTarefaById(Long id) {
        return tarefaRepository.findById(id);
    }

    @Override
    public Tarefa createTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    @Override
    public Tarefa updateTarefa(Long id, Tarefa tarefa) {
        Tarefa tarefaExistente = getTarefaById(id);
        tarefaExistente.setDescricao(tarefa.getDescricao());
        tarefaExistente.setDataLimite(tarefa.getDataLimite());
        tarefaExistente.setTitulo(tarefa.getTitulo());
        tarefaExistente.setPrioridade(tarefa.getPrioridade());
        tarefaExistente.setStatus(tarefa.getStatus());

        return tarefaRepository.save(tarefaExistente);
    }

    @Override
    public void deleteTarefa(Long id) {
        tarefaRepository.deleteById(id);
    }
}
