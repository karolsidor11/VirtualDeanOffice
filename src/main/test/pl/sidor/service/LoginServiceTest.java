package pl.sidor.service;

import com.google.common.base.Optional;
import org.junit.Before;
import org.junit.Test;
import pl.sidor.entity.embeded.Adres;
import pl.sidor.entity.general.Student;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoginServiceTest {

    private LoginService loginService;

    @Before
    public void setUp() throws Exception {
        loginService = mock(LoginService.class);
    }

    @Test
    public void shouldNotFindStudent() {
        // given:
        String email = "nowak@wp.pl";
        String password = "fa27ef3ef6570e32a79";

        // when:
        when(loginService.findStudentByEmialAndPassword(email, password)).thenReturn(Optional.<Student>absent());
        Optional<Student> student = loginService.findStudentByEmialAndPassword(email, password);

        // then:
        assertFalse(student.isPresent());
    }

    @Test
    public void shouldFindStudent() {
        // given:
        String email = "nowak@wp.pl";
        String password = "fa27ef3ef6570e32a79";

        // when:
        when(loginService.findStudentByEmialAndPassword(email, password)).thenReturn(createStudent());
        Optional<Student> student = loginService.findStudentByEmialAndPassword(email, password);

        // then:
        assertTrue(student.isPresent());
        assertEquals(email, student.get().getEmail());
        assertEquals(password, student.get().getPassword());
    }

    private Optional<Student> createStudent() {
        return Optional.of(Student.builder()
                .name("Jan")
                .lastName("Nowak")
                .email("nowak@wp.pl")
                .password("fa27ef3ef6570e32a79")
                .gender("mężczyzna")
                .addres(new Adres())
                .build());
    }
}