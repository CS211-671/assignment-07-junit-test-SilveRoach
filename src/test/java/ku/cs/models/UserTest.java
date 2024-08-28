package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("Password should not store in plain text")
    public void testPasswordIsNotStoreInPlainText() {
        User user = new User("user01", "plain-p@ssw0rd");
        String actual = user.getPassword();
        String unexpected = "plain-p@ssw0rd";
        assertNotEquals(unexpected, actual);
    }

    @Test
    @DisplayName("Password should be verified by plain text")
    public void testPasswordShouldBeVerified() {
        User user = new User("user01", "plain-p@ssw0rd");
        boolean actual = user.validatePassword("plain-p@ssw0rd");
        assertTrue(actual);
    }
    @Test
    void testIsUsername() {
        User user = new User("user01");

        assertTrue(user.isUsername("user01"));
        assertFalse(user.isUsername("user02"));
    }

    @Test
    void testSetPassword() {
        User user = new User("user01");

        String password = "plain-p@ssw0rd";
        user.setPassword(password);

        assertTrue(user.validatePassword(password));
        assertFalse(user.validatePassword("normal-p@ssw0rd"));
    }
}