package pl.sidor.entity.embeded;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Embeddable
public class Address implements Serializable {

    private static final long serialVersionUID = -7038477101261532944L;

    @Column
    @NotNull
    private String country;

    @Column
    @NotNull
    private String city;

    @Column
    private String street;

    @Column
    private String zipCode;

    @Column
    private Integer houseNumber;
}
