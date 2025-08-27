package com.example.API_CLEAN_ARCH.infrastructure.persistence.repository;

import com.example.API_CLEAN_ARCH.infrastructure.persistence.entity.TarefaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaJpaRepository extends JpaRepository<TarefaEntity, Long> {
}
