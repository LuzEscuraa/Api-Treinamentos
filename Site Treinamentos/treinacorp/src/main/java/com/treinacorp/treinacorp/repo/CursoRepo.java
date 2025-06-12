package com.treinacorp.treinacorp.repo;

import com.treinacorp.treinacorp.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CursoRepo extends JpaRepository<Curso, Long> {
}
