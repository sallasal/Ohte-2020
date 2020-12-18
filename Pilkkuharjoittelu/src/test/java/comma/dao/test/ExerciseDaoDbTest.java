/**
 *
 * @author sallasal
 */
package comma.dao.test;

import comma.dao.*;
import comma.domain.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ExerciseDaoDbTest {
    
    private ExerciseDaoDb exerciseDaoDb;
    private UserDaoDb userDaoDb;
    
    public ExerciseDaoDbTest() {
    }
    
    @Before
    public void setUp() throws Exception {
        this.exerciseDaoDb = new ExerciseDaoDb("jdbc:sqlite:commasTest.db");
        this.userDaoDb = new UserDaoDb("jdbc:sqlite:commasTest.db");
        this.userDaoDb.add(new User("daoTestUser", "Dao test user"));
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void initializingAndBringingExercisesWork() throws Exception {
        exerciseDaoDb.deleteAll();
        exerciseDaoDb.initialize();
        assertFalse(exerciseDaoDb.checkIfEmpty());
        
    }

}
