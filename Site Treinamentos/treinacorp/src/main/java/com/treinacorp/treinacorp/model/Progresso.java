
package com.treinacorp.treinacorp.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "progresso", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"usuario_id", "curso_id"})
})
public class Progresso {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "progresso_seq")
        @SequenceGenerator(name = "progresso_seq", sequenceName = "progresso_seq", allocationSize = 1)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "usuario_id", nullable = false)
        private Usuario usuario;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "curso_id", nullable = false)
        private Curso curso;

        private boolean concluido;

        @Column(nullable = false)
        private LocalDateTime dataUltimoAcesso;

        @CreationTimestamp
        @Column(nullable = false, updatable = false)
        private LocalDateTime dataCriacao;

        @UpdateTimestamp
        @Column(nullable = false)
        private LocalDateTime dataAtualizacao;

        @Version
        private Long version;
}
