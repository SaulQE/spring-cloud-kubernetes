package com.esquivel.cursos.clients;

import com.esquivel.cursos.models.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "msvc-usuarios", url = "localhost:8001/api/usuarios")
public interface UsuarioClientRest
{
    @GetMapping("/{id}")
    Usuario findById(@PathVariable Long id);

    @PostMapping
    Usuario save(@RequestBody Usuario usuario);

    @GetMapping("/usuarios-por-curso")
    List<Usuario> findAllByIds(@RequestParam Iterable<Long> ids);

}
