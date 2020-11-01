/**
 *
 * @author sallasal
 */
package comma.ui;

import comma.domain.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Exercise exercise1 = new Exercise("Minä olen fiksumpi", "kuin sinä.", false);
        
        System.out.println("Harjoitellaan pilkkuja.");
        System.out.println("---");
        System.out.println("Ensimmäinen lause:");
        System.out.println(exercise1.getFirstPart() + "______" + exercise1.getSecondPart());
        System.out.println("Tuleeko pilkku? (y/n)");
        String answer = scanner.nextLine();
        
        if (answer.equals("n") && !exercise1.getComma()) {
            System.out.println("Hienoa!");
        } else {
            System.out.println("Huonoa.");
        }
    }
}
