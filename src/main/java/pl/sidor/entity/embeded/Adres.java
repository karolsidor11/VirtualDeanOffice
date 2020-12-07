package pl.sidor.entity.embeded;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Adres {

    @Column
    private String country;

    @Column
    private String city;

    @Column
    private String street;

    @Column
    private String zipCode;

    @Column
    private Integer houseNumber;
}
