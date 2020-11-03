/**
 *
 * @author sallasal
 */

package comma.dao;

import java.sql.*;
import java.util.*;
import comma.domain.*;

public interface ExerciseDao {
    
    public void add(Exercise exercise) throws Exception;
    
    ArrayList<Exercise> listAll() throws SQLException;
    
}
