package com.esquivel.usuarios.controllers;

import com.esquivel.usuarios.models.entity.Usuario;
import com.esquivel.usuarios.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    private List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Usuario> usuarioOptional = usuarioService.findById(id);
        if (usuarioOptional.isPresent()) {
            return ResponseEntity.ok(usuarioOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Usuario usuario, BindingResult result) {
        /* Si tiene errores */
        if (result.hasErrors()) {
            return validar(result);
        }
        if (!usuario.getEmail().isEmpty() && usuarioService.findByEmail(usuario.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "Ya existe un usuario con ese email"));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@Valid @RequestBody Usuario newUsuario, BindingResult result, @PathVariable Long id) {
        /* Si tiene errores */
        if (result.hasErrors()) {
            return validar(result);
        }

        Optional<Usuario> usuarioOptional = usuarioService.findById(id);
        if (usuarioOptional.isPresent()) {
            newUsuario.setId(id);
            if (!newUsuario.getEmail().isEmpty() &&
                    !newUsuario.getEmail().equalsIgnoreCase(usuarioOptional.get().getEmail()) &&
                    usuarioService.findByEmail(newUsuario.getEmail()).isPresent()) {
                return ResponseEntity.badRequest().body(Collections.singletonMap("error", "Ya existe un usuario con ese email"));
            }
            return ResponseEntity.ok(usuarioService.update(newUsuario));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Usuario> usuarioOptional = usuarioService.findById(id);
        if (usuarioOptional.isPresent()) {
            usuarioService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    private static ResponseEntity<Map<String, String>> validar(BindingResult result) {
        Map<String, String> errores = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }
}
