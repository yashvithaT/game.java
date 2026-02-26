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

    /* simple game loop */
    public void play() {
        boolean solved = false;
        int currentPlayer = 1;
        Scanner input = new Scanner(System.in);

        while (!solved) {
            System.out.println("\nCurrent phrase: " + board.getSolvedPhrase());
            board.setLetterValue();
            System.out.println("Current letter value: " + board.getCurrentLetterValue());

            Player player = (currentPlayer == 1) ? player1 : player2;
            System.out.println(player.getName() + "'s turn. Enter a letter or guess the phrase:");
            String guess = input.nextLine().toUpperCase();

            if (guess.length() == 1) { // single letter
                if (board.guessLetter(guess)) {
                    System.out.println("Correct!");
                    player.addScore(board.getCurrentLetterValue());
                } else {
                    System.out.println("Wrong!");
                }
            } else { // attempt to solve
                if (board.isSolved(guess)) {
                    System.out.println("Correct!");
                    player.addScore(1000); // bonus for solving
                    solved = true;
                } else {
                    System.out.println("Incorrect phrase.");
                }
            }

            System.out.println(player1.getName() + " score: " + player1.getScore());
            System.out.println(player2.getName() + " score: " + player2.getScore());

            // switch player
            currentPlayer = (currentPlayer == 1) ? 2 : 1;
        }

        System.out.println("\nGAME OVER! Final scores:");
        System.out.println(player1.getName() + ": " + player1.getScore());
        System.out.println(player2.getName() + ": " + player2.getScore());
    }
}
