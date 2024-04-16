import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var guessGame = new GuessGame(10, 1, 100);
        Scanner scanner = new Scanner(System.in);

        do {
            guessGame.requestPlayerGuess();

            if (scanner.hasNextInt()) {
                guessGame.guessTheNumber(scanner.nextInt());
            } else {
                System.out.println("Por favor, insira um número válido!\n");
                scanner.next();
            }
        } while (guessGame.getRemainingAttempts() != 0);

        scanner.close();
    }
}
