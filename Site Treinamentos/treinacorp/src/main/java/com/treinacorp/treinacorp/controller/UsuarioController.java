package com.treinacorp.treinacorp.controller;


import com.treinacorp.treinacorp.model.Usuario;
import com.treinacorp.treinacorp.repo.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepo repo;

    @PostMapping("/addusuario")
    public ResponseEntity<Usuario> addUsuario(@RequestBody Usuario usuario) {
        usuario.setId(null);
        usuario.setVersion(0L);
        return ResponseEntity.ok(repo.save(usuario));
    }

    @PutMapping("/attusuario/{id}")
    public ResponseEntity<Usuario> attUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return repo.findById(id)
                .map(existingUsuario -> {
                    usuario.setId(id);
                    usuario.setVersion(existingUsuario.getVersion());
                    return ResponseEntity.ok(repo.save(usuario));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delusuario/{id}")
    public ResponseEntity<Void> delUsuario(@PathVariable Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuario() {
        return ResponseEntity.ok(repo.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}