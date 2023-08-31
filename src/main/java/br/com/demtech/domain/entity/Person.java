package br.com.demtech.domain.entity;

import br.com.demtech.domain.model.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

/**
 *
 * @author Mateus Dantas
 */
@Getter @Setter
@Entity
@Table(name = "pessoa")
public class Person {
    @Id
    @GeneratedValue(strategy = IDENTITY)
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
