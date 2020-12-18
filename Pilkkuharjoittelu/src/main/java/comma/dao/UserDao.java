/**
 *
 * @author sallasal
 */
package comma.dao;

import comma.domain.*;


/**
 * This interface is used to perform database actions related to User table
 */
public interface UserDao {

    /**
     * Adds new user to User table
     * @param user User object that is to be added to db
     * @throws java.lang.Exception
     */
    public void add(User user) throws Exception;

    /**
     * Deletes an user from database based on username information
     * @param username username that defines deleted row
     * @throws java.lang.Exception
     */
    public void delete(String username) throws Exception;

    /**
     * Find a user based on username information
     * @param username username that defines returned user
     * @return User object that matches to defined username
     * @throws java.lang.Exception
     */
    public User findByUsername(String username) throws Exception;

    /**
     * Returns amount of passed exercises in defined category for defined user
     * @param username Username that exercises are checked for
     * @param category category from which the exercise amount is checked
     * @return int amount of passed exercises in category
     * @throws java.lang.Exception
     */
    public int passedExercisesInCategory(String username, int category) throws Exception;

    /**
     * Adds completion to user when exercise is passed
     * @param username defines user that completion is added to
     * @param category defines category that completion is added to
     * @param newCount is the amount that is added to defined category for user
     * @throws java.lang.Exception
     */
    public void addCompletion(String username, int category, int newCount) throws Exception;
}
