package br.com.demtech.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Mateus Nascimento
 */
@Getter @Setter
@Embeddable
public class Address {

    @Column(name = "logradouro", length = 50)
    private String street;

    @Column(name = "numero", length = 20)
    private String number;

    @Size(min = 1, max = 20)
    @Column(name = "complemento", length = 20)
    private String complement;

    @Column(name = "bairro", length = 20)
    private String district;

    @Column(name = "cep", length = 10)
    private String zipCode;

    @Column(name = "cidade", length = 30)
    private String city;

    @Column(name = "estado", length = 20)
    private String state;
}
