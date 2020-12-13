/**
 *
 * @author sallasal
 */
package comma.domain.test;

import comma.dao.*;
import comma.domain.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ExerciseDaoDbTest {
    
    private ExerciseDaoDb exerciseDao;
    private UserDaoDb userDao;
    
    public ExerciseDaoDbTest() {
    }
    
    @Before
    public void setUp() throws Exception {
        this.exerciseDao = new ExerciseDaoDb("jdbc:sqlite:commasTest.db");
        this.userDao = new UserDaoDb("jdbc:sqlite:commasTest.db");
        this.userDao.add(new User("daoTestUser", "Dao test user"));
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void initializationAndExerciseBringingWorks() {
        Exercise testEx = exerciseDao.get("Elämä on");
        assertEquals("kuin matka.", testEx.getSecondPart());
    }
    
    @Test
    public void getExerciseReturnsNullCorrectly() {
        Exercise tryGet = exerciseDao.get("This first part should not exist in test db.");
        assertNull(tryGet);
    }

}
