/**
 *
 * @author sallasal
 */

package comma.domain;

import comma.dao.*;

public class Exercise {

    private String firstPart;
    private String secondPart;
    private boolean comma;
    private int category;
    private String creator;
    
    
    public Exercise(String firstPart, String secondPart, boolean comma, int category, String creator) {
        this.firstPart = firstPart;
        this.secondPart = secondPart;
        this.comma = comma;
        this.category = category;
        this.creator = creator;
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
    
    public int getCategory() {
        return this.category;
    }
    
    public String getCreator() {
        return this.creator;
    }
    
    @Override
    public String toString() {
        return (this.firstPart + " ______ " + this.secondPart + ". (Vastaus: " + this.comma + ")");
    }
}
