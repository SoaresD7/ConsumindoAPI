package com.example.apicep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apicep.model.FuncionariosCargoModel;
import com.example.apicep.service.FuncionariosCargoService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/funcionarioscargos")
public class FuncionariosCargoController {

    @Autowired
    private FuncionariosCargoService service;

    @GetMapping
    public List<FuncionariosCargoModel> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionariosCargoModel> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                      .map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public FuncionariosCargoModel salvar(@RequestBody FuncionariosCargoModel funcionario) {
        return service.salvar(funcionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionariosCargoModel> atualizar(@PathVariable Long id, @RequestBody FuncionariosCargoModel funcionario) {
        if (!service.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        funcionario.setId(id);
        return ResponseEntity.ok(service.salvar(funcionario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!service.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
