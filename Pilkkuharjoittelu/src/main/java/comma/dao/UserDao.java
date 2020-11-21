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
    
    public void findByUsername(String username) throws Exception;
    
    public void findByName(String name) throws Exception;
    
    public int getCompletedExercises(String username) throws Exception;
}
