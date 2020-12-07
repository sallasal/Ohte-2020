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
        FakeUserDaoDb userDao = new FakeUserDaoDb();
        FakeExerciseDaoDb exerciseDao = new FakeExerciseDaoDb();
        
        this.commaService = new CommaService(userDao, exerciseDao);
        commaService.createUser("TestUser1","test user 1");     
    }

    @After
    public void tearDown() throws Exception {
        commaService.deleteUser("TestUser1");
        commaService.deleteUser("TestUser2");
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
    public void deletingUserWorks() throws Exception {
        commaService.createUser("TestUser3", "Test user 3");
        commaService.deleteUser("TestUser3");
        boolean returnValue = commaService.validateUsername("TestUser3");
        assertFalse(returnValue);
    }
    
    @Test
    public void createUserChecksUsername() throws Exception {
        boolean returnValue = commaService.createUser("TestUser1", "Should not work");
        assertFalse(returnValue);
    }

    // This must be rewritten without testing random
    @Test
    public void returnsOneRandomObject() throws Exception {
        Exercise ex = commaService.getRandomExercise();
        assertNotNull(ex);
    }
}
