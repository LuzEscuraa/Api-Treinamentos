package com.treinacorp.treinacorp.repo;

import com.treinacorp.treinacorp.model.Progresso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface ProgressoRepo extends JpaRepository<Progresso, Long> {

}