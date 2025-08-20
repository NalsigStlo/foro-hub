package com.alura.foro.controladores;

import com.alura.foro.dominio.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicosControlador {
    @Autowired
    private RepositorioTopico repositorio;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopicos> agregarTopico(@RequestBody @Valid DatosAgregarTopicos datosNuevoTopico,
                                                               UriComponentsBuilder uriComponentsBuilder){
        Topico topico = repositorio.save(new Topico(datosNuevoTopico));
        DatosRespuestaTopicos datosRespuesta = new DatosRespuestaTopicos(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getAutor(), topico.getCurso());

        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuesta);
    }

    @GetMapping
    public ResponseEntity<Page<DatosMostrarTopicos>> mostrarTopicos(@PageableDefault Pageable pagina){
        return ResponseEntity.ok(repositorio.findAllByEstadoTrue(pagina).map(DatosMostrarTopicos::new));
    }

}
