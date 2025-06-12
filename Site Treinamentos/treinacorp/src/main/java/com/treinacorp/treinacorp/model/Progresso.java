package com.treinacorp.treinacorp.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "progresso")
public class Progresso {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "usuario_id", nullable = false)
        private Usuario usuario;

        @ManyToOne
        @JoinColumn(name = "curso_id", nullable = false)
        private Curso curso;

        private boolean concluido;

        private LocalDateTime dataUltimoAcesso;
    }