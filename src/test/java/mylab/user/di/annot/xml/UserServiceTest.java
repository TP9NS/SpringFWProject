package mylab.user.di.annot.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mylab.user.di.annot.UserService;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testUserService() {
        assertNotNull(userService);
        assertNotNull(userService.getUserRepository());
        assertNotNull(userService.getSecurityService());

        assertEquals("MySQL", userService.getUserRepository().getDbType());
        assertTrue(userService.registerUser("abc123", "세훈", "password"));
    }
}