package com.esquivel.usuarios.service;

import com.esquivel.usuarios.models.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService
{
    List<Usuario> findAll();
    Optional<Usuario> findById(Long id);
    Usuario save(Usuario usuario);
    void deleteById(Long id);
    Usuario update(Usuario usuario);
    List<Usuario> findAllByIds(Iterable<Long> ids);

    Optional<Usuario> findByEmail(String email);
}
