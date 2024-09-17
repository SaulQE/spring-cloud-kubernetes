package com.esquivel.cursos.services;

import com.esquivel.cursos.models.Usuario;
import com.esquivel.cursos.models.entity.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService
{
    List<Curso> findAll();
    Optional<Curso> findById(Long id);
    Optional<Curso> findAllByIds(Long id);
    Curso save(Curso curso);
    void deleteById(Long id);
    Curso update(Curso curso);

    void deleteCursoUsuarioById(Long id);

    Optional<Usuario> assignUser(Usuario usuario, Long cursoId);
    Optional<Usuario> createUser(Usuario usuario, Long cursoId);
    Optional<Usuario> deleteUser(Usuario usuario, Long cursoId);
}
