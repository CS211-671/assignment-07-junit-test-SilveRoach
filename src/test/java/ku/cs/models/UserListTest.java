package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {

    @Test
    @DisplayName("User should be found in UserList")
    public void testUserListFindUser() {
        // TODO: add 3 users to UserList
        UserList userlist = new UserList();
        userlist.addUser("Apple","AppleFarm");
        userlist.addUser("Banana","BananaFarm");
        userlist.addUser("Cantaloupe","CantaloupeFarm");
        // TODO: find one of them
        User exist = userlist.findUserByUsername("Banana");

        // TODO: assert that UserList found User
        String expected = "Banana";
        String actual = exist.getUsername();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("User can change password")
    public void testUserCanChangePassword() {
        // TODO: add 3 users to UserList
        UserList userlist = new UserList();
        userlist.addUser("Apple","AppleFarm");
        userlist.addUser("Banana","BananaFarm");
        userlist.addUser("Cantaloupe","CantaloupeFarm");

        // TODO: change password of one user
        boolean actual = userlist.changePassword("Cantaloupe", "CantaloupeFarm", "FarmingWithCantaloupe");

        // TODO: assert that user can change password
        assertTrue(actual);
    }

    @Test
    @DisplayName("User with correct password can login")
    public void testUserListShouldReturnObjectIfUsernameAndPasswordIsCorrect() {
        // TODO: add 3 users to UserList
        UserList userlist = new UserList();
        userlist.addUser("Apple","AppleFarm");
        userlist.addUser("Banana","BananaFarm");
        userlist.addUser("Cantaloupe","CantaloupeFarm");

        // TODO: call login() with correct username and password
        User expected = userlist.findUserByUsername("Apple");
        User actual = userlist.login("Apple", "AppleFarm");

        // TODO: assert that User object is found
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("User with incorrect password cannot login")
    public void testUserListShouldReturnNullIfUsernameAndPasswordIsIncorrect() {
        // TODO: add 3 users to UserList
        UserList userlist = new UserList();
        userlist.addUser("Apple","AppleFarm");
        userlist.addUser("Banana","BananaFarm");
        userlist.addUser("Cantaloupe","CantaloupeFarm");

        // TODO: call login() with incorrect username or incorrect password
        User actual = userlist.login("Apple", "FarmWithApple");

        // TODO: assert that the method return null
        assertNull(actual);
    }

}