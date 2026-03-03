/*
 * Activity 2.2.2
 *
 * The PhraseSolver class for the PhraseSolverGame
 */
import java.util.Scanner;

public class PhraseSolver
{
    /* attributes */
    private Board board;
    private Player player1;
    private Player player2;

    /* constructor */
    public PhraseSolver(String name1, String name2) {
        board = new Board();
        player1 = new Player(name1);
        player2 = new Player(name2);
    }
    public void play() {
        boolean solved = false;
        int currentPlayer = 1;
        Scanner input = new Scanner(System.in);

        board.setLetterValue();

        while (!solved) {
            System.out.println("\nCurrent phrase: " + board.getSolvedPhrase());
            System.out.println("Current letter value: " + board.getCurrentLetterValue());

            Player player = (currentPlayer == 1) ? player1 : player2;
            System.out.println(player.getName() + "'s turn. Enter a letter or guess the phrase:");
            String guess = input.nextLine().toLowerCase();

            if (guess.length() == 1) {
                if (board.guessLetter(guess)) {
                    System.out.println("Correct!");
                    player.addScore(board.getCurrentLetterValue());
                } else {
                    System.out.println("Wrong!");
                }
            } else { 
                if (board.isSolved(guess)) {
                    System.out.println("Correct!");
                    player.addScore(1000); 
                    solved = true;
                } else {
                    System.out.println("Incorrect phrase.");
                }
            }

            System.out.println(player1.getName() + " score: " + player1.getScore());
            System.out.println(player2.getName() + " score: " + player2.getScore());

    
            currentPlayer = (currentPlayer == 1) ? 2 : 1;
        }

        System.out.println("\nGAME OVER! Final scores:");
        System.out.println(player1.getName() + ": " + player1.getScore());
        System.out.println(player2.getName() + ": " + player2.getScore());
    }
}
