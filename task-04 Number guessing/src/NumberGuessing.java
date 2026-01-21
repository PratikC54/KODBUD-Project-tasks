import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {

    static int generatedRandomNumber, guessCount;

    public static void randomNumber() {
        Random random = new Random();
        generatedRandomNumber =  random.nextInt(100);
    }

    public static void guess(Scanner sc) {
        boolean resume = true;
        while (resume) {
            System.out.print("Enter your guess : ");
            int guess = sc.nextInt();
            if (guess > generatedRandomNumber) {
                System.out.println("Too high. Please guess lower number");
                guessCount++;
            } else if (guess < generatedRandomNumber) {
                System.out.println("Too low. Please guess higher number");
                guessCount++;
            }
            else {
                System.out.println("Guessed correctly");
                guessCount++;
                resume = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        randomNumber();
        guess(sc);
        System.out.println("User guessed in "+guessCount+" times");
    }
}
