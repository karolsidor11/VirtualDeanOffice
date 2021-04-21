package pl.sidor.data;

import com.google.common.base.Optional;
import pl.sidor.entity.embeded.Address;
import pl.sidor.entity.general.Student;

public class TestData {

    public static Optional<Student> createOptionalStudent() {
        return Optional.of(Student.builder()
                .name("Jan")
                .lastName("Nowak")
                .email("nowak@wp.pl")
                .password("fa27ef3ef6570e32a79")
                .gender("mężczyzna")
                .addres(createAdres())
                .build());
    }

    public static Student createStudent() {
        return Student.builder()
                .name("Jan")
                .lastName("Nowak")
                .email("nowak@wp.pl")
                .password("fa27ef3ef6570e32a79")
                .gender("mężczyzna")
                .addres(createAdres())
                .data(new byte[]{0, 1})
                .build();
    }

    public static Address createAdres() {
        Address address = new Address();
        address.setCountry("Polska");
        address.setCity("Lublin");
        address.setStreet("Zana");
        address.setZipCode("21-080");
        address.setHouseNumber(22);
        return address;
    }
}
