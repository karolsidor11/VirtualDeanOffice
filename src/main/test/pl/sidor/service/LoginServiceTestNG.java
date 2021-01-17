package pl.sidor.service;

import com.google.common.base.Optional;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.sidor.data.TestData;
import pl.sidor.entity.general.Student;

import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

public class LoginServiceTestNG {

    @Mock
    private LoginService loginService;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShouldFindStudentByEmialAndPassword() {
        // given:
        String email = "nowak@wp.pl";
        String password = "fa27ef3ef6570e32a79";

        // when:
        when(loginService.findStudentByEmialAndPassword(email, password)).thenReturn(TestData.createOptionalStudent());
        Optional<Student> result = loginService.findStudentByEmialAndPassword(email, password);

        // then:
        assertNotNull(result);
        assertTrue(result.isPresent());
        assertEquals(result.get().getEmail(), email);
        assertEquals(result.get().getPassword(), password);
    }

    @Test
    public void testNotFindStudentByEmialAndPassword() {
        // given:
        String email = "nowak11@wp.pl";
        String password = "fa27ef3ef6570e32a79";

        // when:
        when(loginService.findStudentByEmialAndPassword(email, password)).thenReturn(Optional.<Student>absent());
        Optional<Student> result = loginService.findStudentByEmialAndPassword(email, password);

        // then:
        assertNotNull(result);
        assertFalse(result.isPresent());
    }

    @Test
    public void testShouldFindStudentByEmail() {
        // given:
        String email = "nowak@wp.pl";

        // when:
        when(loginService.findStudentByEmail(email)).thenReturn(TestData.createOptionalStudent());
        Optional<Student> result = loginService.findStudentByEmail(email);

        // then:
        assertNotNull(result);
        assertTrue(result.isPresent());
        assertEquals(result.get().getEmail(), email);
    }

    @Test
    public void testNotFindStudentByEmail() {
        // given:
        String email = "nowak11@wp.pl";

        // when:
        when(loginService.findStudentByEmail(email)).thenReturn(Optional.<Student>absent());
        Optional<Student> result = loginService.findStudentByEmail(email);

        // then:
        assertNotNull(result);
        assertFalse(result.isPresent());
    }
}