/**
 *
 * @author sallasal
 */

package comma.dao;

import comma.domain.*;
import java.sql.*;
import java.util.*;

public interface UserDao {
    
    public Connection connect() throws Exception;
    
    public void add(User user) throws Exception;
    
    public void delete(String username) throws Exception;
    
    public User findByUsername(String username) throws Exception;
    
    public int passedExercisesInCategory(String username, int category) throws Exception;
    
    public void addCompletion(String username, int category, int newCount) throws Exception;
}
