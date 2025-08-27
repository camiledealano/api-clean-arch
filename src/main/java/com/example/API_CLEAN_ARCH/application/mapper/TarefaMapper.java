package com.example.API_CLEAN_ARCH.application.mapper;

import com.example.API_CLEAN_ARCH.application.dto.TarefaRequest;
import com.example.API_CLEAN_ARCH.application.dto.TarefaResponse;
import com.example.API_CLEAN_ARCH.domain.model.Tarefa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TarefaMapper {
    TarefaMapper INSTANCE = Mappers.getMapper(TarefaMapper.class);

    @Mapping(target = "id", ignore = true)
    Tarefa toDomain(TarefaRequest tarefaRequest);

    TarefaResponse toResponse(Tarefa tarefa);
}
