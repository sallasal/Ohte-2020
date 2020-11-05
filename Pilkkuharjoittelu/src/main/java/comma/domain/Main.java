/**
 *
 * @author sallasal
 */
package comma.domain;

import comma.domain.*;
import comma.dao.*;
import java.util.*;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        
        //Allaoleva on testikoodia, jolla testaan eri metodeja.
        Exercise exercise = new Exercise("Elämä on","kuin matka", false);
        ExerciseDaoDb exDao = new ExerciseDaoDb();
        
        Exercise exercise2 = new Exercise("Voimme päättää vain siitä", "mitä teemme sillä ajalla, joka meille annetaan", true);
        
        
        exDao.alusta();
        exDao.add(exercise);
        exDao.add(exercise2);
        ArrayList<Exercise> lista = exDao.listAll();
        
        for (Exercise ex: lista) {
            System.out.println(ex.toString());
        }
        
        
    }
}
