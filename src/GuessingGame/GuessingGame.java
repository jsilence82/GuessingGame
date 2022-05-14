package GuessingGame;

import javax.swing.*;
//imports interface

public class GuessingGame {
    public static void main(String[] args){
        int computerNumber = (int) (Math.random()*100 + 1);
        int userAnswer = 0;
        //This print is for testing only. Deactivate before finalizing.
        System.out.println("The correct number is: " + computerNumber);
        // Intial try count set at 10, will be deducted with each attempt
        int count = 10;
        int score = 100;

        // Loop for game. After each try, the count variable is deducted by 1.
        // After the try counter hits 0, the game ends with a break.
        while (userAnswer != computerNumber)
        {
            String response = JOptionPane.showInputDialog(null,
                    "Guess a number between 1 and 100", "Guessing Game", 3);
            userAnswer = Integer.parseInt(response);
            JOptionPane.showMessageDialog(null, ""+ determineGuess(userAnswer, computerNumber, count, score));
            count--;
            if(count==-1)
                break;
        }
    }

    public static String determineGuess(int userAnswer, int computerNumber, int count, int score){
        //checks if the try counter reached 0
        if(count == 0) {
            return "Sorry. You didn't get the right number.\nThe correct number is: " + computerNumber;
        }
        //checks user number against computer number
        if (userAnswer <=0 || userAnswer >100) {
            return "Uh, do over.\nGuess a number between 1 and 10";
        }
        if (userAnswer == computerNumber ){
            return "Correct!\nTotal Guesses: " + count + "\nYou're score: " + (count * score);
        }
        if (userAnswer > computerNumber) {
            return "Woops. Too high. Guess again.\nTries left: " + count;
        }
        if (userAnswer < computerNumber) {
            return "Not quite. Too low. Guess again.\nTries left: " + count;
        }
        return null;
    }
}

