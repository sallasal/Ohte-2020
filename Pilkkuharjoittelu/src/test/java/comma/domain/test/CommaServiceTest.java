package comma.domain.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import comma.domain.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sallasal
 */
public class CommaServiceTest {

    CommaService commaService;

    public CommaServiceTest() {
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
    public void createUserReturnsTrue() throws Exception {
        boolean returnValue = commaService.createUser("TestUser2", "Test user 2");
        assertTrue(returnValue);
    }

    @Test
    public void returnsOneRandomObject() throws Exception {
        Exercise ex = commaService.getRandomExercise();
        assertNotNull(ex);
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

    @Test
    public void createUserChecksUsername() throws Exception {
        boolean returnValue = commaService.createUser("TestUser1", "Should not work");
        assertFalse(returnValue);
    }

    @Test
    public void getUsernameReturnsCorrectly() throws Exception {
        String palautettava = commaService.getUsername();
        System.out.println(palautettava);
    }

    @Test
    public void createExerciseWorksCorrectly() throws Exception {
        String firstpart = "Testilauseessa on kaksi osaa";
        String secondpart = "joita testataan.";
        int comma = 1;
        int category = 2;
        commaService.createExercise(firstpart, secondpart, comma, category, commaService.getUsername());
        Exercise ex = commaService.getExercise(firstpart);
        assertEquals("joita testataan.", ex.getSecondPart());
    }

    @Test
    public void getsCompletedExercisesCorrectly() throws Exception {
        int completedInCat2 = commaService.getCompletedExercises(2);
        assertEquals(0, commaService.getCompletedExercises(2));
    }

    @Test
    public void addsCompletionCorrectlyToCtg1() throws Exception {
        int completed = commaService.getCompletedExercises(1);
        completed++;
        commaService.addCompletion(1);
        assertEquals(completed, commaService.getCompletedExercises(1));
    }

    @Test
    public void addsCompletionCorrectlyToCtg2() throws Exception {
        int completed = commaService.getCompletedExercises(2);
        completed++;
        commaService.addCompletion(2);
        assertEquals(completed, commaService.getCompletedExercises(2));
    }

    @Test
    public void addsCompletionCorrectlyToCtg3() throws Exception {
        int completed = commaService.getCompletedExercises(3);
        completed++;
        commaService.addCompletion(3);
        assertEquals(completed, commaService.getCompletedExercises(3));
    }

    @Test
    public void checkPrizeReturnsCorrectString() throws Exception {
        commaService.createUser("WinnerUser", "Winner user ");
        for (int i = 0; i < 20; i++) {
            commaService.addCompletion(3);
        }
        assertEquals("Erikoistapausten esitaistelija", commaService.checkPrize(3));
        commaService.deleteUser("WinnerUser");
    }

    @Test
    public void checkNewPrizeWorksForCat1() throws Exception {
        commaService.createUser("WinnerUser", "Winner user ");
        for (int i = 0; i < 3; i++) {
            commaService.addCompletion(1);
        }
        assertEquals("Onnea! Ansaitsit Päälauseiden pääministeri -palkinnon!", commaService.checkNewPrize(1));
        commaService.deleteUser("WinnerUser");
    }

    @Test
    public void checkNewPrizeWorksForCat2() throws Exception {
        commaService.createUser("WinnerUser", "Winner user ");
        for (int i = 0; i < 3; i++) {
            commaService.addCompletion(2);
        }
        assertEquals("Onnea! Ansaitsit Sivulauseiden saalistaja -palkinnon!", commaService.checkNewPrize(2));
        commaService.deleteUser("WinnerUser");
    }

    @Test
    public void checkNewPrizeWorksForCat3() throws Exception {
        commaService.createUser("WinnerUser", "Winner user ");
        for (int i = 0; i < 3; i++) {
            commaService.addCompletion(3);
        }
        assertEquals("Onnea! Ansaitsit Erikoistapausten esitaistelija -palkinnon!", commaService.checkNewPrize(3));
        commaService.deleteUser("WinnerUser");
    }
}
