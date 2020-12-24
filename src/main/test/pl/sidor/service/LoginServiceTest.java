package pl.sidor.service;

import com.google.common.base.Optional;
import org.junit.Before;
import org.junit.Test;
import pl.sidor.data.TestData;
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
        when(loginService.findStudentByEmialAndPassword(email, password)).thenReturn(TestData.createStudent());
        Optional<Student> student = loginService.findStudentByEmialAndPassword(email, password);

        // then:
        assertTrue(student.isPresent());
        assertEquals(email, student.get().getEmail());
        assertEquals(password, student.get().getPassword());
    }

    @Test
    public void shouldFindStudentByEmail() {
        // given:
        String email = "nowak@wp.pl";

        // when:
        when(loginService.findStudentByEmail(email)).thenReturn(TestData.createStudent());
        Optional<Student> student = loginService.findStudentByEmail(email);

        // then:
        assertTrue(student.isPresent());
        assertEquals(email, student.get().getEmail());
    }

    @Test
    public void shouldNotFindStudentByEmail() {
        // given:
        String email = "nowak@wp.pl";

        // when:
        when(loginService.findStudentByEmail(email)).thenReturn(Optional.<Student>absent());
        Optional<Student> student = loginService.findStudentByEmail(email);

        // then:
        assertFalse(student.isPresent());
    }
}