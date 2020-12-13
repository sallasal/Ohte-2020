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


public class CommaServiceExerciseTest {

    private CommaService commaService;

    public CommaServiceExerciseTest() {
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
    public void returnsOneRandomObject() throws Exception {
        Exercise ex = commaService.getRandomExercise();
        assertNotNull(ex);
    }

    @Test
    public void createExerciseWorksCorrectly() throws Exception {
        String firstpart = "There are two parts in test sentence";
        String secondpart = "that are tested.";
        int comma = 1;
        int category = 2;
        boolean testCreation = commaService.createExercise(firstpart, secondpart, comma, category, commaService.getUsername());
        assertEquals(true, testCreation);
    }
    
    @Test
    public void validateInputCatchesTooLongFirstpart() throws Exception {
        String firstpart = "Sed perspiciatis unde omnis iste natus error sit "
                + "voluptatem accusantium doloremque laudantium, totam rem "
                + "aperiam, eaque ipsa quae ab illo inventore veritatis et quasi "
                + "architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam volupt";
        String secondpart = "This is OK.";
        int comma = 0;
        int category = 3;
        boolean testFirstPart = commaService.createExercise(firstpart, secondpart, comma, category, commaService.getUsername());
        assertEquals(false, testFirstPart);
    }
    
    @Test
    public void validateInputCathchesTooShortSecondPart() throws Exception {
        String firstpart = "Now this is OK";
        String secondpart = "B";
        int comma = 1;
        int category = 1;
        boolean testSecondPart = commaService.createExercise(firstpart, secondpart, comma, category, commaService.getUsername());
        assertEquals(false, testSecondPart);
    }
    
    @Test
    public void validateInputCatchesWrongCommaValue() throws Exception {
        String firstpart = "This is OK again";
        String secondpart = "This too is OK";
        int comma = -1;
        int category = 2;
        boolean testCommaValue = commaService.createExercise(firstpart, secondpart, comma, category, commaService.getUsername());
        assertEquals(false, testCommaValue);
    }
    
    @Test
    public void validateInputCatchesWrongCategoryValue() throws Exception {
        String firstpart = "This is OK again";
        String secondpart = "And so is this";
        int comma = 0;
        int category = 4;
        boolean testCategoryValue = commaService.createExercise(firstpart, secondpart, comma, category, commaService.getUsername());
        assertEquals(false, testCategoryValue);
    }

    @Test
    public void getsCompletedExercisesCorrectly() throws Exception {
        int completedInCat2 = commaService.getCompletedExercises(2);
        assertEquals(0, commaService.getCompletedExercises(2));
    }

}
