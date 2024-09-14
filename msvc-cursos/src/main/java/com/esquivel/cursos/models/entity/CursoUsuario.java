package com.esquivel.cursos.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "cursos_usuarios")
@AllArgsConstructor
@NoArgsConstructor
public class CursoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Long usuarioId;

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (!(obj instanceof CursoUsuario)) return false;
        CursoUsuario cursoUsuario = (CursoUsuario) obj;
        return this.usuarioId != null && this.usuarioId.equals(cursoUsuario.usuarioId);
    }
}
