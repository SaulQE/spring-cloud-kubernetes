package com.esquivel.cursos.services;

import com.esquivel.cursos.entity.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService
{
    List<Curso> findAll();
    Optional<Curso> findById(Long id);
    Curso save(Curso curso);
    void deleteById(Long id);
    Curso update(Curso curso);
}
