
package neljansuora.domain;


public class User {
    
    private String name;
    private int wins;
    private int losses;

    public User(String name) {
        this.name = name;
        this.wins = 0;
        this.losses = 0;
    }

    public String getName() {
        return this.name;
    }

    public String getNameModified() {
        String editedName = this.name.trim().toUpperCase();
        return editedName;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }
        
        
        

    @Override
    public String toString() {
        return this.name + ";" + this.wins + ";" + this.losses;
    }
}