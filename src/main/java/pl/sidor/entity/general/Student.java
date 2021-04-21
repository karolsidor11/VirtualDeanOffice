package pl.sidor.entity.general;
import lombok.*;
import pl.sidor.entity.base.BaseEntity;
import pl.sidor.entity.embeded.Address;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Student extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -4620337437464005185L;

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

    @Lob
    private byte[] data;

    @Embedded
    private Address addres;

    @Version
    private Long version;
}
