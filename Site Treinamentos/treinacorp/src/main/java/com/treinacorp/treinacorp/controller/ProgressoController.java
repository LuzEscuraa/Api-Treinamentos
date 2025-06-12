package com.treinacorp.treinacorp.controller;

import com.treinacorp.treinacorp.model.Progresso;
import com.treinacorp.treinacorp.repo.ProgressoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/progresso")
public class ProgressoController {

    @Autowired
    private ProgressoRepo repo;

    @PostMapping("/addprogresso")
    public ResponseEntity<Progresso> addProgresso(@RequestBody Progresso progresso) {
        progresso.setId(null);
        progresso.setVersion(0L);
        progresso.setDataUltimoAcesso(LocalDateTime.now());
        return ResponseEntity.ok(repo.save(progresso));
    }

    @PutMapping("/attprogresso/{id}")
    public ResponseEntity<Progresso> attProgresso(@PathVariable Long id, @RequestBody Progresso progresso) {
        return repo.findById(id)
                .map(existingProgresso -> {
                    progresso.setId(id);
                    progresso.setVersion(existingProgresso.getVersion());
                    progresso.setDataUltimoAcesso(LocalDateTime.now());
                    return ResponseEntity.ok(repo.save(progresso));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delprogresso/{id}")
    public ResponseEntity<Void> delProgresso(@PathVariable Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Progresso>> getProgressos() {
        return ResponseEntity.ok(repo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Progresso> getProgressoById(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}