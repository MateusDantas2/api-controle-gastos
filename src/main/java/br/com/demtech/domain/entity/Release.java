package br.com.demtech.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

/**
 *
 * @author Mateus Dantas
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lancamento")
public class Release {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(name = "descricao")
    @Size(min = 3, max = 50)
    private String description;
    @Column(name = "data_vencimento")
    private LocalDate dueDate;
    @Column(name = "data_pagamento")
    private LocalDate paymentDate;
    @Column(name = "valor")
    private Double value;
    @Column(name = "observacao")
    @Size(min = 3, max = 50)
    private String observation;
    @Enumerated(STRING)
    @Column(name = "tipo")
    private ReleaseType type;
    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id", insertable = false, updatable = false)
    private Category category;
    @ManyToOne
    @JoinColumn(name = "id_pessoa", referencedColumnName = "id", insertable = false, updatable = false)
    private Person person;

    public enum ReleaseType {
        RECEITA, DESPESA
    }
}
