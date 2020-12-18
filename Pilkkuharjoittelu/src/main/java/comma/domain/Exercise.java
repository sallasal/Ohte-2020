/**
 * @author sallasal
 */
package comma.domain;

/**
 * Class defines Exercise objects and their class variables
 */
public class Exercise {

    private String firstPart;
    private String secondPart;
    private boolean comma;
    private int category;
    private String creator;

    /**
     * Creates new Exercise object
     *
     * @param firstPart String for sentence part before comma place
     * @param secondPart String for sentence part after comma place
     * @param comma true if comma is needed, false otherwise
     * @param category Integer for exercise category: 1 = main clause, 2 =
     * subordinate clause, 3 = some other case
     * @param creator String for username of exercise creator ("program" for
     * default sentence)
     */
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

}
