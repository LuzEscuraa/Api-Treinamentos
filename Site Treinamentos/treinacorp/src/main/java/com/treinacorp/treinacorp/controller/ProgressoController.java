package com.treinacorp.treinacorp.controller;

import com.treinacorp.treinacorp.model.Progresso;
import com.treinacorp.treinacorp.repo.ProgressoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/progresso")
public class ProgressoController {

    @Autowired
    private ProgressoRepo repo;

    @PostMapping("/registrar")
    public Progresso registrar(@RequestBody Progresso progresso) {
        progresso.setDataUltimoAcesso(LocalDateTime.now());
        return repo.save(progresso);
    }
}