import java.util.Scanner;
import java.util.Random;

public class Player {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] phrases = {"HELLO", "WORLD", "COMPUTER", "CODING"};
        String phrase = phrases[random.nextInt(phrases.length)];

        StringBuilder guessed = new StringBuilder();
        for (int i = 0; i < phrase.length(); i++) guessed.append("_");

        System.out.println("Welcome!");
        System.out.print("Enter Player 1 name: ");
        String player1 = scanner.nextLine().trim();
        System.out.print("Enter Player 2 name: ");
        String player2 = scanner.nextLine().trim();

        int score1 = 0, score2 = 0;
        boolean player1Turn = true;
        boolean gameWon = false;

        while (!gameWon && guessed.toString().contains("_")) {
            System.out.print("\nCurrent Phrase: ");
            for (int i = 0; i < guessed.length(); i++) System.out.print(guessed.charAt(i) + " ");
            System.out.println();
            System.out.println(player1 + "'s Score: " + score1 + " | " + player2 + "'s Score: " + score2);

            String currentPlayer = player1Turn ? player1 : player2;
            System.out.print(currentPlayer + ", enter a letter or full phrase: ");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.isEmpty()) continue;

            boolean correct = false;

            if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                char guess = input.charAt(0);
                for (int i = 0; i < phrase.length(); i++) {
                    if (phrase.charAt(i) == guess && guessed.charAt(i) == '_') {
                        guessed.setCharAt(i, guess);
                        correct = true;
                        if (player1Turn) score1++;
                        else score2++;
                    }
                }
                System.out.println(correct ? "Correct!" : "Not in phrase!");
            } else {
                if (input.equals(phrase)) {
                    guessed = new StringBuilder(phrase);
                    int points = phrase.length();
                    if (player1Turn) score1 += points;
                    else score2 += points;
                    System.out.println("You guessed the phrase correctly!");
                    gameWon = true;
                } else {
                    System.out.println("You guessed the phrase incorrectly!");
                }
            }

            if (!gameWon) player1Turn = !player1Turn;
        }

        System.out.print("\nPhrase guessed: ");
        for (int i = 0; i < guessed.length(); i++) System.out.print(guessed.charAt(i) + " ");
        System.out.println();

        if (score1 > score2) System.out.println(player1 + " wins with " + score1 + " points!");
        else if (score2 > score1) System.out.println(player2 + " wins with " + score2 + " points!");
        else System.out.println("It's a tie! Both players have " + score1 + " points.");

        scanner.close();
    }
}
