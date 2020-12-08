/**
 *
 * @author sallasal
 */
package comma.domain;

/**
 * Class defines User objects and their class variables
 */
public class User {

    private String username;
    private String name;
    private int completedCtg1;
    private int completedCtg2;
    private int completedCtg3;

    /**
     * Creates blank user with default class variable values
     */
    public User() {
        this.username = null;
        this.name = null;
        this.completedCtg1 = 0;
        this.completedCtg2 = 0;
        this.completedCtg3 = 0;
    }

    /**
     * Creates user with username and name parameters, otherwise defauls values
     *
     * @param username Username for the new user
     * @param name Full name for the new user
     */
    public User(String username, String name) {
        this.username = username;
        this.name = name;
        this.completedCtg1 = 0;
        this.completedCtg2 = 0;
        this.completedCtg3 = 0;
    }

    /**
     * Creates user with all possible variables defined
     *
     * @param username Username for the new user
     * @param name Full name for the new user
     * @param completed1 Amount of exercises completed in main clause category
     * @param completed2 Amount of exercises completed in subordinate clause category
     * @param completed3 Amount of exercises completed in other cases category
     */
    public User(String username, String name, int completed1, int completed2, int completed3) {
        this.username = username;
        this.name = name;
        this.completedCtg1 = completed1;
        this.completedCtg2 = completed2;
        this.completedCtg3 = completed3;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Fetches number of passed exercises in defined category
     *
     * @param category category number from which the value is going to be
     * fetched. Default -1, if no category is defined.
     *
     * @return integer that shows how many exercises are completed from defined
     * category for this user
     */
    public int getExercises(int category) {
        if (category == 1) {
            return this.completedCtg1;
        } else if (category == 2) {
            return this.completedCtg2;
        } else if (category == 3) {
            return this.completedCtg3;
        }

        return -1;
    }

    /**
     * Sets new number of passed exercises in defined category for user
     *
     * @param category category number from which the value is going to be
     * fetched
     * @param newCount new vcount to be set to class varible
     */
    public void setExercises(int category, int newCount) {
        if (category == 1) {
            this.completedCtg1 = newCount;
        }
        if (category == 2) {
            this.completedCtg2 = newCount;
        }
        if (category == 3) {
            this.completedCtg3 = newCount;
        }
    }

}
