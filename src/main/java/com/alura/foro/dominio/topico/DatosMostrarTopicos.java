package com.alura.foro.dominio.topico;

import java.time.LocalDate;

public record DatosMostrarTopicos(Long id, String titulo, String mensaje, String autor, String curso, LocalDate fechaCreacion, boolean estado) {
        public DatosMostrarTopicos(Topico topico) {
            this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getAutor(), topico.getCurso(), topico.getFechaCreacion(), topico.isEstado());
        }
}