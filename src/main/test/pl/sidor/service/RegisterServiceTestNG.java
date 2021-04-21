package pl.sidor.service;

import org.junit.Assert;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.sidor.data.TestData;
import pl.sidor.entity.general.Student;

import static org.mockito.Mockito.*;

public class RegisterServiceTestNG {

    @Mock
    private RegisterService registerService;

    @BeforeMethod
    public void testRegisterStudent() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testName() {
        // given:
        Student student = TestData.createStudent();

        // when:
        when(registerService.registerStudent(student)).thenReturn(true);
        boolean result = registerService.registerStudent(student);

        // then:
        Assert.assertTrue(result);
        verify(registerService, times(1)).registerStudent(student);
    }
}