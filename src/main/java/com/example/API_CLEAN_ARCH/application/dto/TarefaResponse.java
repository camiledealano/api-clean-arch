package com.example.API_CLEAN_ARCH.application.dto;

import com.example.API_CLEAN_ARCH.domain.model.enums.Prioridade;
import com.example.API_CLEAN_ARCH.domain.model.enums.Status;

import java.time.LocalDate;

public class TarefaResponse {

    private Long id;
    private String titulo;
    private String descricao;
    private Prioridade prioridade;
    private Status status;
    private LocalDate dataLimite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(LocalDate dataLimite) {
        this.dataLimite = dataLimite;
    }
}
