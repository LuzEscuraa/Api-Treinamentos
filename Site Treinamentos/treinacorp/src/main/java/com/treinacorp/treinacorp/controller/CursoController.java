package com.treinacorp.treinacorp.controller;

import com.treinacorp.treinacorp.model.Curso;
import com.treinacorp.treinacorp.repo.CursoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoRepo repo;

    @PostMapping("/addcurso")
    public ResponseEntity<Curso> addCurso(@RequestBody Curso curso) {
        curso.setId(null);
        return ResponseEntity.ok(repo.save(curso));
    }

    @PutMapping("/attcurso/{id}")
    public ResponseEntity<Curso> attCurso(@PathVariable Long id, @RequestBody Curso curso) {
        return repo.findById(id)
                .map(existingCurso -> {
                    curso.setId(id);
                    curso.setVersion(existingCurso.getVersion());
                    return ResponseEntity.ok(repo.save(curso));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delcurso/{id}")
    public ResponseEntity<Void> delCurso(@PathVariable Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Curso>> getCursos() {
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}