package pl.sidor.data;

import com.google.common.base.Optional;
import pl.sidor.entity.embeded.Adres;
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
                .build();
    }

    public static Adres createAdres() {
        Adres adres = new Adres();
        adres.setCountry("Polska");
        adres.setCity("Lublin");
        adres.setStreet("Zana");
        adres.setZipCode("21-080");
        adres.setHouseNumber(22);
        return adres;
    }
}
