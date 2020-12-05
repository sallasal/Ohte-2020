/**
 *
 * @author sallasal
 */
package comma.domain;

public class User {

    private String username;
    private String name;
    private int completedCtg1;
    private int completedCtg2;
    private int completedCtg3;

    public User() {
        this.username = null;
        this.name = null;
        this.completedCtg1 = 0;
        this.completedCtg2 = 0;
        this.completedCtg3 = 0;
    }

    public User(String username, String name) {
        this.username = username;
        this.name = name;
        this.completedCtg1 = 0;
        this.completedCtg2 = 0;
        this.completedCtg3 = 0;
    }

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
