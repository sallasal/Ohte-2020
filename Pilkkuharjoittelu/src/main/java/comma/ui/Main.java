/**
 *
 * @author sallasal
 */
package comma.ui;

import comma.domain.*;
import comma.dao.*;
import java.util.*;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        
        Exercise exercise = new Exercise("Elämä on","kuin matka", false);
        ExerciseDaoDb exDao = new ExerciseDaoDb();
        
        
        exDao.alusta();
        exDao.add(exercise);
        
        
    }
}
