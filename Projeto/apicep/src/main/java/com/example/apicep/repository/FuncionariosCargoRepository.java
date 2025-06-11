package com.example.apicep.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository; 

import com.example.apicep.model.FuncionariosCargoModel;

@Repository
public interface FuncionariosCargoRepository extends JpaRepository<FuncionariosCargoModel, Long> {
}

