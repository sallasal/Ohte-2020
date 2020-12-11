/**
 *
 * @author sallasal
 */

package comma.dao;

import java.sql.*;
import java.util.*;
import comma.domain.*;

public interface ExerciseDao {
    
    public Connection connect(String dbLocation) throws Exception;
    
    public void initialize() throws Exception;
    
    public void add(Exercise exercise) throws Exception;
    
    public Exercise get(String firstpart) throws Exception;
    
    public ArrayList<Exercise> listAll(String username) throws SQLException;
    
}
