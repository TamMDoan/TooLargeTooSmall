import java.util.Scanner;

/**
 * Created by iyasuwatts on 10/17/17.
 */
public class Main {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int numberGuessed;
        String play;
        boolean keepGuessing = true;
        boolean keepPlaying = true;
        int numberOfGuesses = 0;

        System.out.println("\n**** Welcome to Guess That Number! ****\n");

        while(keepPlaying) {

            int numberToGuess = (int) (Math.random() * 100) + 1;

            while (keepGuessing) {

                // try-catch block to catch inputs that would break our code (i.e. anything not an int)
                try {
                    System.out.println("\nPlease enter a number between 1 and 100: ");
                    numberGuessed = input.nextInt();
                } catch (Exception e) {
                    System.out.println("This is not a number!");
                    input.next();
                    continue;
                }

                // guessing logic
                if (numberGuessed < 1 || numberGuessed > 100) {
                    System.out.println("A number between 1 and 100, please!");
                } else {
                    numberOfGuesses++;
                    if (numberGuessed > numberToGuess) {
                        System.out.println("Too high!");
                    } else if (numberGuessed < numberToGuess) {
                        System.out.println("Too small!");
                    } else {
                        System.out.println("You got it! " + numberGuessed + " is correct! It took " + numberOfGuesses + " tries to guess it.");
                        keepGuessing = false;
                    }
                }
            }

            // logic for playing again
            System.out.println("Would you like to play again? Y/N: ");
            play = input.next();

            if (play.equals("N") || play.equals("n")) {
                System.out.println("Thank you for playing!");
                keepPlaying = false;
            } else if (play.equals("Y") || play.equals("y")) {
                System.out.println("Starting new game...");
                keepGuessing = true;
                numberOfGuesses = 0;
            } else {
                System.out.println("Y or N not inputted... quitting game...");
                keepPlaying = false;
            }

        }
    }
}
