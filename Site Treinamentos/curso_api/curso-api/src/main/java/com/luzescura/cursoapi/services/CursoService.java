package com.luzescura.cursoapi.services;

import com.luzescura.cursoapi.model.Curso;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CursoService {
    private static final Map<Long, Curso> respository = new HashMap<>();

    public Curso criar (Curso curso){

        Long nextId = respository.keySet().size() + 1L;
        curso.setId(nextId);
        respository.put(nextId, curso);
        return curso;
    }

    public Curso atualizar(Curso curso, Long cursoId){
        respository.put(cursoId, curso);
        return curso;
    }

    public Curso getbyId(Long cursoId){
        return respository.get(cursoId);
    }
    public List<Curso> getall(){
        return new ArrayList<>(respository.values());
    }
    public String delete(Long cursoId){
        respository.remove(cursoId);
        return "Curso deletado com sucesso";
    }
}
