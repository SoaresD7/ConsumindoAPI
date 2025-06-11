package com.example.apicep.model;

import java.sql.Date;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "funcionarios_por_cargos") 
@Getter
@Setter
@NoArgsConstructor
public class FuncionariosCargoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "funcionario_id", nullable = false, referencedColumnName = "id")
    private FuncionarioModel funcionario_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cargo_id", nullable = false, referencedColumnName = "id")
    private CargoModel cargo_id;

    @Column(length = 255)
    private String detalhes;


    @Temporal(TemporalType.DATE)
    private Date data_inicio;

    @Temporal(TemporalType.DATE)
    private Date data_fim;
}