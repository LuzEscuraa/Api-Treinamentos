package com.treinacorp.treinacorp.controller;


import com.treinacorp.treinacorp.model.Usuario;
import com.treinacorp.treinacorp.repo.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

  @Autowired
   UsuarioRepo repo;

    @PostMapping("/addusuario")
    public void addUsuario(@RequestBody Usuario usuario){

        repo.save(usuario);
    }

    @PutMapping("/attusuario")
    public void attUsuario(@RequestBody Usuario usuario){

        repo.save(usuario);
    }
    @DeleteMapping("/delusuario")
    public void delUsuario(@RequestBody Usuario usuario){

        repo.delete(usuario);
}
    @GetMapping
    public List<Usuario> getUsuario(){
        return repo.findAll();
    }

}
