package com.example.API_CLEAN_ARCH.infrastructure.persistence.mapper;

import com.example.API_CLEAN_ARCH.domain.model.Tarefa;
import com.example.API_CLEAN_ARCH.infrastructure.persistence.entity.TarefaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TarefaEntityMapper {
    TarefaEntityMapper INSTANCE = Mappers.getMapper(TarefaEntityMapper.class);

    TarefaEntity toEntity(Tarefa tarefa);
    Tarefa toDomain(TarefaEntity tarefaEntity);
}
