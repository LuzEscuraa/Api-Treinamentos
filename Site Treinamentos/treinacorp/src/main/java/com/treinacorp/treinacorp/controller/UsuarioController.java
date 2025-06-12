package com.treinacorp.treinacorp.controller;


import com.treinacorp.treinacorp.model.Usuario;
import com.treinacorp.treinacorp.repo.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepo repo;

    @PostMapping("/addusuario")
    public ResponseEntity<?> addUsuario(@RequestBody Usuario usuario) {

        if (repo.existsByEmail(usuario.getEmail())) {
            return ResponseEntity.badRequest()
                    .body(new ErrorResponse("Email já cadastrado"));
        }

        try {
            usuario.setId(null);
            usuario.setVersion(0L);
            Usuario saved = repo.save(usuario);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(new ErrorResponse("Erro ao cadastrar usuário: " + e.getMessage()));
        }
    }

    private static class ErrorResponse {
        private String message;

        public ErrorResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
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
    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody Usuario loginData) {
        return repo.findByEmailAndSenha(loginData.getEmail(), loginData.getSenha())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }


}