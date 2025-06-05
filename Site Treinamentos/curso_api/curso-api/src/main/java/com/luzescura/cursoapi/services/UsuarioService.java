package com.luzescura.cursoapi.services;


import com.luzescura.cursoapi.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsuarioService {
    private static final Map<Long, Usuario> respository = new HashMap<>();


    public Usuario criar (Usuario usuario){
        Long nextId = respository.keySet().size() + 1L;
        usuario.setId(nextId);
        respository.put(nextId, usuario);
        return usuario;
    }

    public Usuario atualizar(Usuario usuario, Long usuarioId){
        respository.put(usuarioId, usuario);
        return usuario;
    }
    public Usuario getbyId(Long usuarioId){
        return respository.get(usuarioId);
    }
    public List<Usuario> getall(){
        return new ArrayList<>(respository.values());
    }
    public String delete(Long usuarioId){
        respository.remove(usuarioId);
        return "Usuario deletado com sucesso";
    }
}
