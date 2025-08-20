package com.alura.foro.dominio.topico;

public record DatosRespuestaTopicos(
        Long id,
        String titulo,
        String mensaje,
        String autor,
        String curso) {
}
