package com.luzescura.cursoapi.controller;


import com.luzescura.cursoapi.model.Curso;
import com.luzescura.cursoapi.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value= "/cursos", produces = MediaType.APPLICATION_JSON_VALUE)
public class CursoController {
    @Autowired
    private CursoService service;



    @PostMapping
    @ResponseBody
    public Curso criar(@RequestBody Curso curso){

        return service.criar(curso);
    }

    @PutMapping("/{cursoId}")
    @ResponseBody
    public Curso atualizar(@RequestBody Curso curso,
                           @PathVariable("cursoId") Long cursoId){

        return service.atualizar(curso, cursoId);
    }

    @GetMapping
    @ResponseBody
    public List<Curso> getall(){

        return service.getall();
    }

    @DeleteMapping("/{cursoId}")
    @ResponseBody
    public String delete(@PathVariable("cursoId") Long cursoId){

        return service.delete(cursoId);
    }
}
