/*
 * Activity 2.2.2
 *
 * The runner for the PhraseSolverGame
 */
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Player 1 name: ");
        String name1 = input.nextLine();

        System.out.print("Enter Player 2 name: ");
        String name2 = input.nextLine();

        PhraseSolver p = new PhraseSolver(name1, name2);
        p.play();
    }
}
