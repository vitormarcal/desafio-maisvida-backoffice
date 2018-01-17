package com.vitormarcal.desafio.features.medicos;

import com.vitormarcal.desafio.features.BaseResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoResource implements BaseResource<Medico, String>{

    private final MedicoService medicoService;

    @Autowired
    public MedicoResource(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    @Override
    @GetMapping("/{id}")
    public Medico buscar(@PathVariable  String id) {
        return medicoService.buscar(id);
    }

    @Override
    @GetMapping
    public List<Medico> listar() {
        return medicoService.listar();
    }

    @Override
    @PostMapping
    public ResponseEntity<Medico> salvar(@RequestBody Medico medico) {
        Medico medicoCriado = medicoService.salvar(medico);
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoCriado);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity remover(String id) {
        medicoService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Medico> editar(@PathVariable String id, @RequestBody Medico medico) {
        Medico medicoSalvo = medicoService.editar(id, medico);
        return ResponseEntity.ok(medicoSalvo);
    }
}
