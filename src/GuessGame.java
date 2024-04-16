import java.util.Random;

public class GuessGame {
    private int remainingAttempts;
    private final int minRange;
    private final int maxRange;
    private final int randomNumber;

    public GuessGame(int attempts, int minRange, int maxRange) {
        this.remainingAttempts = attempts;
        this.minRange = minRange;
        this.maxRange = maxRange;
        this.randomNumber = this.generateRandomNumber();
    }

    private int generateRandomNumber() {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(maxRange - minRange + 1) + minRange;
    }

    private void decreaseAttempts() {
        this.remainingAttempts = this.remainingAttempts - 1;

        if (this.remainingAttempts == 0) {
            System.out.println("Eu venci!!!");
        } else {
            System.out.printf("Tentativas restantes: %d \n\n", this.remainingAttempts);
        }
    }

    public int getRemainingAttempts() {
        return this.remainingAttempts;
    }

    public void requestPlayerGuess() {
        System.out.printf("Informe um número entre %d e %d: \n", this.minRange, this.maxRange);
    }

    public void guessTheNumber(int input) {
        if (input == this.randomNumber) {
            System.out.println("Parabéns, você me venceu!!!");
            this.remainingAttempts = 0;
        } else if (input < this.randomNumber) {
            System.out.println("Não foi dessa vez... O número informado é menor do que o esperado");
            this.decreaseAttempts();
        } else {
            System.out.println("Não foi dessa vez... O número informado é maior do que o esperado");
            this.decreaseAttempts();
        }
    }
}
