package pl.sidor.entity.general;
import lombok.*;
import pl.sidor.entity.base.BaseEntity;
import pl.sidor.entity.embeded.Adres;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Student extends BaseEntity implements Serializable {

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String lastName;

    @Column
    @NotNull
    private String email;

    @Column
    @NotNull
    private String password;

    @Column
    private String gender;

    @Embedded
    private Adres addres;

    @Version
    private Long version;
}
