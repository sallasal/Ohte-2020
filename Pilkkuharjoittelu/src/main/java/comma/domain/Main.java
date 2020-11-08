/**
 *
 * @author sallasal
 */
package comma.domain;

import comma.domain.*;
import comma.dao.*;
import comma.ui.*;
import java.util.*;
import java.sql.*;
import javafx.application.Application;

public class Main {

    public static void main(String[] args) {
        ExerciseDaoDb exDao = new ExerciseDaoDb();
        exDao.alusta();
        
        Application.launch(CommaGUI.class);

        //TESTAILUUN
        //Exercise exercise = new Exercise("Elämä on","kuin matka", false);
        //Exercise exercise2 = new Exercise("Voimme päättää vain siitä", "mitä teemme sillä ajalla, joka meille annetaan", true);
        //exDao.add(exercise);
        //exDao.add(exercise2);
//        ArrayList<Exercise> lista = exDao.listAll();
//
//        for (Exercise ex : lista) {
//            System.out.println(ex.toString());
//        }

    }
}
