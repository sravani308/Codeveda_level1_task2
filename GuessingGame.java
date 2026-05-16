import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int randomNumber;
        int userGuess;
        int attempts;
        final int MAX_ATTEMPTS = 5;

        char playAgain;

        System.out.println("======================================================");
        System.out.println("              JAVA NUMBER GUESSING GAME               ");
        System.out.println("======================================================");

        do {

            randomNumber = random.nextInt(100) + 1;
            attempts = 0;

            System.out.println("\n------------------------------------------------------");
            System.out.println("RULES OF THE GAME");
            System.out.println("------------------------------------------------------");
            System.out.println("1. Guess a number between 1 and 100");
            System.out.println("2. You only have 5 attempts");
            System.out.println("3. Hints will be provided");
            System.out.println("------------------------------------------------------");

            boolean guessedCorrectly = false;

            while (attempts < MAX_ATTEMPTS) {

                try {

                    System.out.print("\nEnter Your Guess: ");
                    userGuess = sc.nextInt();

                    attempts++;

                    if (userGuess < 1 || userGuess > 100) {

                        System.out.println("Please enter a number between 1 and 100.");
                        continue;
                    }

                    if (userGuess == randomNumber) {

                        System.out.println("\n==================================================");
                        System.out.println("          CONGRATULATIONS! YOU WON!");
                        System.out.println("==================================================");
                        System.out.println("Correct Number : " + randomNumber);
                        System.out.println("Attempts Used  : " + attempts);
                        System.out.println("==================================================");

                        guessedCorrectly = true;
                        break;

                    } else if (userGuess > randomNumber) {

                        System.out.println("Too High!");

                    } else {

                        System.out.println("Too Low!");
                    }

                    System.out.println("Remaining Attempts: " + (MAX_ATTEMPTS - attempts));

                } catch (InputMismatchException e) {

                    System.out.println("Invalid Input! Please enter numbers only.");
                    sc.nextLine();
                }
            }

            if (!guessedCorrectly) {

                System.out.println("\n==================================================");
                System.out.println("                 GAME OVER");
                System.out.println("==================================================");
                System.out.println("Correct Number Was : " + randomNumber);
                System.out.println("Better Luck Next Time!");
                System.out.println("==================================================");
            }

            System.out.print("\nDo You Want To Play Again? (y/n): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("\n======================================================");
        System.out.println("          THANK YOU FOR PLAYING THE GAME              ");
        System.out.println("======================================================");

        sc.close();
    }
}