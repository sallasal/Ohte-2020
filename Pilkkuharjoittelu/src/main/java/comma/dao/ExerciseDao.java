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
    
    List<Exercise> list() throws SQLException;
    
}
