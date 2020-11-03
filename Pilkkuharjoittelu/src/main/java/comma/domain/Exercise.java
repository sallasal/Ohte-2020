/**
 *
 * @author sallasal
 */

package comma.domain;

public class Exercise {

    private String firstPart;
    private String secondPart;
    private boolean comma;
    
    public Exercise() {
        this.firstPart = null;
        this.secondPart = null;
        this.comma = false;
    }
    
    public Exercise(String firstPart, String secondPart, boolean comma) {
        this.firstPart = firstPart;
        this.secondPart = secondPart;
        this.comma = comma;
    }
    
    public String getFirstPart() {
        return this.firstPart;
    }
    
    public String getSecondPart() {
        return this.secondPart;
    }
    
    public boolean getComma() {
        return this.comma;
    }
    
    @Override
    public String toString() {
        return(this.firstPart + " ______ " + this.secondPart + ". (Vastaus: " + this.comma + ")");
    }
}
