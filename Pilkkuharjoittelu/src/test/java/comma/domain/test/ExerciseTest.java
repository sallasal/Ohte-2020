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


public class ExerciseTest {
    
    Exercise testExercise;
    
    public ExerciseTest() {
    }
    
    @Before
    public void setUp() {
        this.testExercise = new Exercise("First part", "Second part", false, 1, "Program test");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void returnsCorrectCreator() {
        String testCreator = testExercise.getCreator();
        assertEquals("Program test", testCreator);
    }
    
    @Test
    public void toStringWorks() {
        String testString = testExercise.toString();
        assertEquals("First part ______ Second part. (Vastaus: false)", testString);
    }
    
    @Test
    public void returnsCorrectFirstPart() {
        String testFirstPart = testExercise.getFirstPart();
        assertEquals("First part", testFirstPart);
    }
    
    @Test
    public void returnsCorrectSecondPart() {
        String testSecondPart = testExercise.getSecondPart();
        assertEquals("Second part", testSecondPart);
    }
    
    @Test
    public void returnsCorrectComma() {
        assertEquals(false, testExercise.getComma());
    }
    
    @Test
    public void returnsCorrectCategory() {
        int testCategory = testExercise.getCategory();
        assertEquals(1, testCategory);
    }
}
