import java.util.Random;
import java.util.Scanner;

/**
 * The purpose of this program is to have the user play ROck, Paper, Scissors
 * against a computer
 * @author Christopher McKenzie
 */
public class RockPaperScissors {
    
    /**
     * Asks for user input and returns it in a string.
     * If the user inputs incorrect character, repeats until
     * appropriate input is given.
     * @return Returns rock, paper, scissors, or quit
     */
    public String getHumanMove() {
        Scanner scn = new Scanner(System.in);

        // System.out.println("Please choose 'R', 'P', 'S' or 'Q' to quit: ");
        // char userInput = scn.next().charAt(0);
        String userMove = "";
        while (userMove == "") {
            System.out.println("Please choose 'R', 'P', 'S' or 'Q' to quit: ");
            char userInput = scn.next().charAt(0);
            if (userInput == 'r' || userInput == 'R') {
                userMove = "rock";
                scn.close();
            }
            else if (userInput == 'p' || userInput == 'P') {
                userMove = "paper";
                scn.close();
            }
            else if (userInput == 's' || userInput == 'S') {
                userMove = "scissors";
                scn.close();
            }
            else if (userInput == 'q' || userInput == 'Q') {
                userMove = "quit";
                scn.close();
            }
    
            else { 
                System.out.println("Please enter only 'R', 'P', 'S' or 'Q'");
                scn.close();
            }
            scn.close();
        }


        //scn.close(); //always close scanner object once finished
        return userMove;

    }

    /**
     * Return's the computer's random choice
     * @return Returns rock, paper, or scissors from computer
     */
    public String getComputerMove() {
        String[] choices = {"rock", "paper", "scissors"}; 
        Random random = new Random();
        int idx = random.nextInt(choices.length); // use random index to pick the random move
        String move = choices[idx];
        return move;
    }

    /**
     * Plays Rock, Paper, Scissors game.
     * If user enters 'q' or 'Q', the game will stop.
     * Receives the human's move, the computer's move, and determines the winner.
     * @return Returns True if the user wants to keep playing. Otherwise, returns False and stops
     */
    public boolean playGame() {
        String human = getHumanMove();
        if (human == "quit") {
            System.out.println("Thanks for playing!");
            return false;
        }

        String computer = getComputerMove();

        if (human==computer) {
            System.out.println("Tie - We both chose " + human);
        }

        else if (human == "rock" && computer == "scissors") {
            System.out.println("Rock beats Scissors - You win!");
        }
        else if (human == "rock" && computer == "paper") {
            System.out.println("Paper beats Rock - I win!");
        }

        else if (human == "paper" && computer == "rock") {
            System.out.println("Paper beats Rock - You win!");
        }
        else if (human == "paper" && computer == "scissors") {
            System.out.println("Scissors beats Paper - I win!");
        }

        else if (human == "scissors" && computer == "paper") {
            System.out.println("Scissors beats Paper - You win!");
        }
        else if (human == "scissors" && computer == "rock") {
            System.out.println("Rock beats Scissors - I win!");
        }

        return true;
    
    }
    
    public static void main(String[] args) {
        RockPaperScissors game = new RockPaperScissors();
        // String userMove = game.getHumanMove();
        // String compMove = game.getComputerMove();
        boolean again = true;
        while (again) {
            again = game.playGame();
        }
        //Exception in thread "main" java.util.NoSuchElementException
    }
}
