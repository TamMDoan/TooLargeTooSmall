import java.util.Scanner;

/**
 * Created by iyasuwatts on 10/17/17.
 */
public class Main {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int numberToGuess = (int) (Math.random() * 100) +1;
        int numberGuessed = 0;
        boolean keepGuesing = true;
        int numberOfGuesses = 0;

        System.out.println("\n**** Welcome to Guess That Number! ****\n");

        while(keepGuesing){

            // try-catch block to catch inputs that would break our code (i.e. anything not an int)
            try {
                System.out.println("\nPlease enter a number between 1 and 100: ");
                numberGuessed = input.nextInt();
            }
            catch(Exception e){
                System.out.println("This is not a number!");
                input.next();
                continue;
            }

            // guessing logic
            if(numberGuessed < 1 || numberGuessed > 100){
                System.out.println("A number between 1 and 100, please!");
            }
            else{
                numberOfGuesses++;
                if(numberGuessed > numberToGuess){
                    System.out.println("Too high!");
                }
                else if(numberGuessed < numberToGuess){
                    System.out.println("Too small!");
                }
                else{
                    System.out.println("You got it! " + numberGuessed + " is correct! It took " + numberOfGuesses + " tries to guess it.");
                    keepGuesing = false;
                }
            }
        }



        
    }
}
