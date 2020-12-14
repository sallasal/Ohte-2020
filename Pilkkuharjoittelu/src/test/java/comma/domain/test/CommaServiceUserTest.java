/**
 *
 * @author sallasal
 */

package comma.domain.test;

import comma.domain.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class CommaServiceUserTest {

    private CommaService commaService;

    public CommaServiceUserTest() {
    }

    @Before
    public void setUp() throws Exception {

        this.commaService = new CommaService("jdbc:sqlite:commasTest.db");
        this.commaService.createUser("TestUser1", "TestUser1 for testing");
        this.commaService.setUser(new User("TestUser1", "TestUser1 for testing"));
    }

    @After
    public void tearDown() throws Exception {
        commaService.deleteUser("TestUser1");
        commaService.deleteUser("TestUser2");
    }

    @Test
    public void returnsNameCorrectly() {
        String name = commaService.getName();
        assertEquals("TestUser1 for testing", name);
    }

    @Test
    public void validateUsernameReturnsTrue() throws Exception {
        boolean returnValue = commaService.validateUsername("TestUser1");
        assertTrue(returnValue);
    }

    @Test
    public void validateUsernameReturnsFalse() throws Exception {
        boolean returnValue = commaService.validateUsername("TestUser42");
        assertFalse(returnValue);
    }
    
    @Test
    public void validateUsernameRejectsProgram() throws Exception {
        boolean validateUsername = commaService.validateUsername("program");
        assertFalse(validateUsername);
    }
    
    @Test
    public void validateUsernameRejectsTooLong() throws Exception {
        String tooLongUsername = "This username is definitely too long for this program.";
        boolean validateUsername = commaService.validateUsername(tooLongUsername);
        assertFalse(validateUsername);
    }

    @Test
    public void createUserReturnsTrue() throws Exception {
        boolean returnValue = commaService.createUser("TestUser2", "Test user 2");
        assertTrue(returnValue);
    }

    @Test
    public void createUserChecksUsername() throws Exception {
        boolean returnValue = commaService.createUser("TestUser1", "Should not work");
        assertFalse(returnValue);
    }
    
    @Test
    public void userCreationTracksTooShortInput() throws Exception {
        String username = "T";
        String name = "This is OK";
        boolean testUsername = commaService.createUser(username, name);
        assertEquals(false, testUsername);
    }
    
    @Test
    public void createUserTracksTooLongInput() throws Exception {
        String username = "This is OK";
        String name = "But this is much too long string to be a name in this program";
        boolean testName = commaService.createUser(username, name);
        assertFalse(testName);
    }
    
    @Test
    public void createUserRejectsProgram() throws Exception {
        String username = "program";
        String name = "Good name input this is";
        boolean testProgram = commaService.createUser(username, name);
        assertFalse(testProgram);
    }

    @Test
    public void getUsernameReturnsCorrectly() throws Exception {
        String palautettava = commaService.getUsername();
        System.out.println(palautettava);
    }
    
        @Test
    public void deletingUserWorks() throws Exception {
        commaService.createUser("TestUser3", "Test user 3");
        commaService.deleteUser("TestUser3");
        boolean returnValue = commaService.validateUsername("TestUser3");
        assertFalse(returnValue);
    }

    @Test
    public void nullingUserWorks() throws Exception {
        this.commaService.nullUser();
        assertNull(this.commaService.getUser());
        this.commaService.setUser(new User("TestUser1", "TestUser1 for testing"));
    }

}
