package pl.sidor.controller;

import org.junit.Before;
import org.junit.Test;
import pl.sidor.data.TestData;
import pl.sidor.service.RegisterService;

import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RegisterControllerTest {

    private RegisterController controller;
    private RegisterService registerService;

    @Before
    public void setUp() throws Exception {
        controller = new RegisterController();
        registerService = mock(RegisterService.class);
    }

    @Test
    public void shouldReturnAllCountries() {
        // when:
        List<String> allCountries = controller.getAllCountries();

        // then:
        assertNotNull(allCountries);
        assertEquals(allCountries.size(), 250);
        assertTrue(allCountries.contains("Polska"));
    }

    @Test
    public void shouldConfirmRegister() {
        // given:
        doNothing().when(registerService).registerStudent(TestData.createStudent());
        controller.setStudent(TestData.createStudent());
        controller.setRegisterService(registerService);

        // when:
        String adresUrl = controller.confirmRegister();

        // then:
        assertNotNull(adresUrl);
        assertNotNull(controller.getStudent());
        assertEquals(controller.getStudent().getName(), TestData.createStudent().getName());
        assertEquals(controller.getStudent().getLastName(), TestData.createStudent().getLastName());
        assertEquals(controller.getStudent().getEmail(), TestData.createStudent().getEmail());
        assertEquals(controller.getStudent().getAddres(), TestData.createStudent().getAddres());
    }
}