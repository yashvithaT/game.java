/*
 * Activity 2.2.2
 * 
 * A Player class for the PhraseSolverGame
 */
public class Player
{
    /* attributes */
    private String name;
    private int score;

    /* constructor */
    public Player(String playerName) {
        name = playerName;
        score = 0; // start at 0
    }

    /* accessors */
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    /* mutators */
    public void setName(String newName) {
        name = newName;
    }

    public void addScore(int points) {
        score += points; // increase score by points
    }

    public void resetScore() {
        score = 0; // reset score to 0
    }
}
