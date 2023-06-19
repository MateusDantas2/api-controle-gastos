package br.com.demtech.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Mateus Nascimento
 */
@Getter @Setter
@Entity
@Table(name = "pessoa")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 50)
    @Column(name = "nome")
    private String name;

    @Embedded
    private Address address;

    @NotNull
    @Column(name = "ativo")
    private Boolean active;
}
