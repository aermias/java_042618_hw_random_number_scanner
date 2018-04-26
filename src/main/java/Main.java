import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
// Write a guessing game which prompts a user to guess a mystery number within some range such as 1 - 10
// After every guess the program should display some variation of "too large", "too small", "correct guess", respectively.
// Upon termination, the program should display the number of guesses before successfully guessing correctly.
// A number that is input consecutively, should register as a single guess.

        System.out.println("Pick a number between 1 and 10");

        Scanner sc = new Scanner(System.in);

        int amountOfGuesses = 0,
            minNumber = 1,
            maxNumber = 10,
            numberGuessed = -1;

        int numberToGuess = new Random().nextInt((maxNumber - minNumber) + 1) + minNumber;
        // System.out.println("[The number is " + numberToGuess + "]");

        while (numberGuessed != numberToGuess) {
            try {
                numberGuessed = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Type a valid number");
                continue;
            }

            System.out.println("You guessed " + numberGuessed);

            if (numberGuessed == numberToGuess) {
                System.out.println("You win!");
            } else {
                String relativeLocation = (numberGuessed > numberToGuess) ? "Too big" : "Too small";

                System.out.println(relativeLocation + ", try again");
            }

            amountOfGuesses++;
        }

        boolean oneGuess = amountOfGuesses == 1;

        System.out.println("It took you " + amountOfGuesses + " " + (oneGuess ? "guess" : "guesses"));
    }
}
