package pl.sidor.controller;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class LoginControllerTestNG {

    @Mock
    private LoginController controller;

    @BeforeMethod
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
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