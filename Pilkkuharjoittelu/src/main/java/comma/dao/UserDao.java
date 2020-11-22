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
    
    public User findByName(String name) throws Exception;
    
    public int getCompletedExercises(String username) throws Exception;
}
