package br.com.demtech.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

/**
 *
 * @author Mateus Dantas
 */
@Data
@Entity
@Table(name = "categoria")
public class Category {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "nome", length = 50, unique = true)
    private String name;
}
