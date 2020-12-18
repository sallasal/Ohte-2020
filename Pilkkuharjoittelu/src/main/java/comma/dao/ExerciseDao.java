/**
 *
 * @author sallasal
 */
package comma.dao;

import java.sql.*;
import java.util.*;
import comma.domain.*;

/**
 * This is an interface that is used to initialize the database and to perform
 * exercise related database actions
 */
public interface ExerciseDao {

    /**
     * Initializes database and brings default exercises, if necessary
     * @throws java.lang.Exception
     */
    public void initialize() throws Exception;

    /**
     * Adds new exercise to Exercise table
     * @param exercise Exercise object that is to be added
     * @throws java.lang.Exception
     */
    public void add(Exercise exercise) throws Exception;


    /**
     * Lists all the exercises from db except the ones created by defined user
     * @param username Username that is excluded from search
     * @return ArrayList that contains all Exercise objects that meet requirements
     * @throws java.sql.SQLException
     */
    public ArrayList<Exercise> listAll(String username) throws SQLException;

}
