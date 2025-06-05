package com.luzescura.cursoapi.controller;


import com.luzescura.cursoapi.model.Usuario;
import com.luzescura.cursoapi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value= "/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @PostMapping
    @ResponseBody
    public Usuario criar(@RequestBody Usuario usuario){

        return service.criar(usuario);
    }

    @PutMapping("/{usuarioId}")
    @ResponseBody
    public Usuario atualizar(@RequestBody Usuario usuario,
                           @PathVariable("usuarioId") Long usuarioId){

        return service.atualizar(usuario, usuarioId);
    }

    @GetMapping
    @ResponseBody
    public List<Usuario> getall(){

        return service.getall();
    }

    @DeleteMapping("/{usuarioId}")
    @ResponseBody
    public String delete(@PathVariable("usuarioId") Long usuarioId){

        return service.delete(usuarioId);
    }



}
