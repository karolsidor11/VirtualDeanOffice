package pl.sidor.entity.general;
import lombok.*;
import pl.sidor.entity.base.BaseEntity;
import pl.sidor.entity.embeded.Adres;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student extends BaseEntity implements Serializable {

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String gender;

    @Embedded
    private Adres addres;
}
