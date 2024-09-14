package com.esquivel.cursos.services;

import com.esquivel.cursos.clients.UsuarioClientRest;
import com.esquivel.cursos.models.Usuario;
import com.esquivel.cursos.models.entity.Curso;
import com.esquivel.cursos.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioClientRest usuarioClientRest;

    @Override
    @Transactional(readOnly = true)
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Curso> findById(Long id) {
        return cursoRepository.findById(id);
    }

    @Override
    @Transactional
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        cursoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Curso update(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public Optional<Usuario> assignUser(Usuario usuario, Long cursoId) {
        return Optional.empty();
    }

    @Override
    public Optional<Usuario> createUser(Usuario usuario, Long cursoId) {
        return Optional.empty();
    }

    @Override
    public Optional<Usuario> deleteUser(Usuario usuario, Long cursoId) {
        return Optional.empty();
    }
}
