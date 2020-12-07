package pl.sidor.controller;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoginControllerTest {

    private LoginController controller;

    @Before
    public void setUp() throws Exception {
        controller = mock(LoginController.class);
    }

    @Test
    public void checkLoginDetails() {
        // given:
        String email = "nowak@wp.pl";
        String password = "fa27ef3ef6570e32a79";

        // when:
        when(controller.getEmail()).thenReturn(email);
        when(controller.getPassword()).thenReturn(password);
        when(controller.checkLoginDetails()).thenReturn("standard");
        String response = controller.checkLoginDetails();

        // then:
        assertNotNull(response);
        assertEquals(email, controller.getEmail());
        assertEquals(password, controller.getPassword());
    }

    @Test
    public void checkLoginDetailsFails() {
        // given:
        String email = "nowak@wp.pl";
        String password = "fa27ef3ef6570e32a79";

        // when:
        when(controller.getEmail()).thenReturn(email);
        when(controller.getPassword()).thenReturn(password);
        when(controller.checkLoginDetails()).thenReturn("");
        String response = controller.checkLoginDetails();

        // then:
        assertNotNull(response);
        assertEquals(response, "");
    }
}