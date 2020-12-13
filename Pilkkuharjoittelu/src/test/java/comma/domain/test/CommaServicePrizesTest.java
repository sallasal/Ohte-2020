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


public class CommaServicePrizesTest {

    private CommaService commaService;

    public CommaServicePrizesTest() {
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
    public void checkPrizeWorksForCat1() throws Exception {
        commaService.createUser("WinnerUser", "Winner user ");
        for (int i = 0; i < 20; i++) {
            commaService.addCompletion(1);
        }
        assertEquals("Päälauseiden pääministeri", commaService.checkPrize(1));
        commaService.deleteUser("WinnerUser");
    }

    @Test
    public void checkPrizeWorksForCat2() throws Exception {
        commaService.createUser("WinnerUser", "Winner user ");
        for (int i = 0; i < 20; i++) {
            commaService.addCompletion(2);
        }
        assertEquals("Sivulauseiden saalistaja", commaService.checkPrize(2));
        commaService.deleteUser("WinnerUser");
    }

    @Test
    public void checkPrizeWorksForCat3() throws Exception {
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
