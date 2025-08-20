package com.alura.foro.dominio.topico;

import jakarta.validation.constraints.NotBlank;

public record DatosAgregarTopicos(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        String autor,
        @NotBlank
        String curso) {
}
