package com.treinacorp.treinacorp.controller;

import com.treinacorp.treinacorp.model.Curso;
import com.treinacorp.treinacorp.repo.CursoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    CursoRepo   repo;

    @PostMapping("/addcurso")
    public void addCurso(@RequestBody Curso curso){

        repo.save(curso);
    }

    @PutMapping("/attcurso")
    public void attCurso(@RequestBody Curso curso){

        repo.save(curso);
    }
    @DeleteMapping("/delcurso")
    public void delCurso(@RequestBody Curso curso){

        repo.delete(curso);
    }
    @GetMapping
    public List<Curso> getCurso(){
        return repo.findAll();
    }

}
