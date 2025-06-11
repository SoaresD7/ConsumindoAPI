package com.example.apicep.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.apicep.model.FuncionariosCargoModel;
import com.example.apicep.repository.FuncionariosCargoRepository;

@Service
public class FuncionariosCargoService {

    @Autowired
    private FuncionariosCargoRepository repository;

    public List<FuncionariosCargoModel> listarTodos() {
        return repository.findAll();
    }

    public Optional<FuncionariosCargoModel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public FuncionariosCargoModel salvar(FuncionariosCargoModel funcionario) {
        return repository.save(funcionario);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
