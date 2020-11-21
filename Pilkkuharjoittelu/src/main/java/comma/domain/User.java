
/**
 *
 * @author sallasal
 */
package comma.domain;

public class User {
    
    private String username;
    private String name;
    private int completedExercises;
    
    public User() {
        this.username = null;
        this.name = null;
        this.completedExercises = 0;
    }
    
    public User(String username, String name) {
        this.username = username;
        this.name = name;
        this.completedExercises = 0;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public int getExercises() {
        return this.completedExercises;
    }
    
    public void setExercises(int newCount) {
        this.completedExercises = newCount;
    }
    
}
