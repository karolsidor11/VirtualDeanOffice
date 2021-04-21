package pl.sidor.controller;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.sidor.data.TestData;
import pl.sidor.service.RegisterService;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

public class RegisterControllerTestNG {

    private RegisterController controller;
    private RegisterService service;

    @BeforeMethod
    public void setUp() {
        service = mock(RegisterService.class);
        controller = new RegisterController();
        controller.setRegisterService(service);
    }

    @Test
    public void shouldReturnCountries() {
        // when:
        List<String> allCountries = controller.getAllCountries();

        // then:
        assertNotNull(allCountries);
        assertEquals(allCountries.size(), 250);
        assertTrue(allCountries.contains("Polska"));
    }

    @Test
    public void shouldConfirmRegister(){
        // given:
        when(service.registerStudent(TestData.createStudent())).thenReturn(true);
        controller.setStudent(TestData.createStudent());
        controller.setAddress(TestData.createAdres());

        // when:
        String url = controller.confirmRegister();

        // then:
        assertNotNull(url);
        assertNotNull(controller.getStudent());
        assertEquals(controller.getStudent().getName(), TestData.createStudent().getName());
        assertEquals(controller.getStudent().getLastName(), TestData.createStudent().getLastName());
        assertEquals(controller.getStudent().getEmail(), TestData.createStudent().getEmail());
        assertEquals(controller.getStudent().getAddres(), TestData.createStudent().getAddres());
    }
}