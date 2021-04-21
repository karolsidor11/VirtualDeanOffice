package pl.sidor.service;

import org.junit.Before;
import org.junit.Test;
import pl.sidor.data.TestData;
import pl.sidor.entity.general.Student;

import static org.mockito.Mockito.*;

public class RegisterServiceTest {

    private RegisterService registerService;

    @Before
    public void setUp() throws Exception {
        registerService = mock(RegisterService.class);
    }

    @Test
    public void shouldRegisterStudent() {
        // given:
        Student student = TestData.createStudent();

        // when:
        when(registerService.registerStudent(TestData.createStudent())).thenReturn(true);
        registerService.registerStudent(student);

        // then:
        verify(registerService, times(1)).registerStudent(student);
    }
}