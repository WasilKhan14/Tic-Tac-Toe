import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {


        static int playerScore = 0;
        static int computerScore = 0;
        static Scanner input  = new Scanner(System.in);

    /*
           _ | _ | _
           _ | _ | _
             |   |

             help ful indicies
     */


   public static void main(String[] args) {
    char[][] gameboard = {{'_','|','_','|','_'},{'_','|','_','|','_'},{'_','|','_','|','_'}};
    printBoard(gameboard);
    System.out.println("---------------------------");
    boolean gameOver = false;
    boolean playAgain = true;

    while(playAgain){

    while(!gameOver){
        playerMove(gameboard);
        gameOver = isGameOver(gameboard);
        if(gameOver){
            break;
        }

        computerMove(gameboard);
        gameOver = isGameOver(gameboard);
        if(gameOver){
            break;
        }
    }
    System.out.println("Player Score: "+ playerScore);
    System.out.println("Computer Score: "+computerScore);
    System.out.println("Would you like to play again? Y/N");
    input.nextLine();
    String result = input.nextLine();

    switch(result){
        case "Y":
        case "y":
            playAgain = true;
            System.out.println("Dope!! Let's play again");
            resetBoard(gameboard);
            gameOver = false;
            printBoard(gameboard);
            break;
        case "N":
        case "n":
            playAgain = false;
            System.out.println("Thanks for playing ");
            break;
        default:
            break;
    }
    
    }
   }

public static void printBoard(char[][] gameboard)
   {
    for(char[] row : gameboard)
    {
        for(char c : row){
            System.out.print(c);
        }
        System.out.println();
    }
   }

   public static void updateBoard(int position, int player, char [][] gameboard){

    char character;

    if(player == 1)
    {
        character = 'X';
    }
    else{
        character = 'O';
    }

    switch(position)
    {

        case 1:
            gameboard[0][0] = character;
            printBoard(gameboard);
            break;
        case 2:
            gameboard[0][2] = character;
            printBoard(gameboard);
            break;
        case 3:
            gameboard[0][4] = character;
            printBoard(gameboard);
            break;
        case 4:
            gameboard[1][0] = character;
            printBoard(gameboard);
            break;
        case 5:
            gameboard[1][2] = character;
            printBoard(gameboard);
            break;
        case 6:
            gameboard[1][4] = character;
            printBoard(gameboard);
            break;
        case 7:
            gameboard[2][0] = character;
            printBoard(gameboard);
            break;
        case 8:
            gameboard[2][2] = character;
            printBoard(gameboard);
            break;
        case 9:
            gameboard[2][4] = character;
            printBoard(gameboard);
            break;
        default:
            break;
    }
   }

   public static void playerMove(char[][] gameboard){

    System.out.println("Please make a move. (1 - 9)");

    int move = input.nextInt();

    boolean result = isValidMove(move, gameboard);

    while(!result){
        System.out.println("Sorry! Invalid Move. Try again");
        move = input.nextInt();
        result = isValidMove(move, gameboard);
    }

    System.out.println("Player moved at position " + move);
    updateBoard(move, 1, gameboard);
   }

   public static boolean isValidMove(int move , char[][] gameboard)
   {

        switch(move){
            case 1:
                if(gameboard[0][0] == '_'){
                    return true;
                }
                else{
                    return false;
                }
            case 2:
                if(gameboard[0][2] == '_'){
                    return true;
                }
                else{
                    return false;
                }
            case 3:
                if(gameboard[0][4] == '_'){
                    return true;
                }
                else{
                    return false;
                }
            case 4:
                if(gameboard[1][0] == '_'){
                    return true;
                }
                else{
                    return false;
                }
            case 5:
                if(gameboard[1][2] == '_'){
                    return true;
                }
                else{
                    return false;
                }
            case 6:
                if(gameboard[1][4] == '_'){
                    return true;
                }
                else{
                    return false;
                }
            case 7:
                if(gameboard[2][0] == '_'){
                    return true;
                }
                else{
                    return false;
                }
            case 8:
                if(gameboard[2][2] == '_'){
                    return true;
                }
                else{
                    return false;
                }
            case 9:
                if(gameboard[2][4] == '_'){
                    return true;
                }
                else{
                    return false;
                }
            default:
                return false;
        }
   }

   public static void computerMove(char [][] gameboard)
   {

         Random rand = new Random();
         int move = rand.nextInt(9)+1;

         boolean result = isValidMove(move, gameboard);

         while(!result){
            move = rand.nextInt(9)+1;
            result = isValidMove(move, gameboard);
         }

         System.out.println("Computer moved at position "+ move);
         updateBoard(move, 2, gameboard);
   }

   public static boolean isGameOver(char[][] gameboard)
   {

        // Horizontal win
        if(gameboard[0][0] == 'X' && gameboard[0][2] == 'X' && gameboard[0][4] == 'X'){
            System.out.println("PLAYER WINS !!!");
            playerScore++;
            return true;
        }
        if(gameboard[0][0] == 'O' && gameboard[0][2] == 'O' && gameboard[0][4] == 'O'){
            System.out.println("COMPUTER WINS !!!");
           computerScore++;
            return true;
        }
          if(gameboard[1][0] == 'X' && gameboard[1][2] == 'X' && gameboard[1][4] == 'X'){
            System.out.println("PLAYER WINS !!!");
           playerScore++;
            return true;
        }
        if(gameboard[1][0] == 'O' && gameboard[1][2] == 'O' && gameboard[1][4] == 'O'){
            System.out.println("COMPUTER WINS !!!");
             computerScore++;
            return true;
        }
          if(gameboard[2][0] == 'X' && gameboard[2][2] == 'X' && gameboard[2][4] == 'X'){
            System.out.println("PLAYER WINS !!!");
            playerScore++;
            return true;
        }
        if(gameboard[2][0] == 'O' && gameboard[2][2] == 'O' && gameboard[2][4] == 'O'){
            System.out.println("COMPUTER WINS !!!");
             computerScore++;
            return true;
        }

        // VERTICAL WINS 
          if(gameboard[0][0] == 'X' && gameboard[1][0] == 'X' && gameboard[2][0] == 'X'){
            System.out.println("PLAYER WINS !!!");
            playerScore++;
            return true;
        }
        if(gameboard[0][0] == 'O' && gameboard[1][0] == 'O' && gameboard[2][0] == 'O'){
            System.out.println("COMPUTER WINS !!!");
             computerScore++;
            return true;
        }
         if(gameboard[0][2] == 'X' && gameboard[1][2] == 'X' && gameboard[2][2] == 'X'){
            System.out.println("PLAYER WINS !!!");
            playerScore++;
            return true;
        }
        if(gameboard[0][2] == 'O' && gameboard[1][2] == 'O' && gameboard[2][2] == 'O'){
            System.out.println("COMPUTER WINS !!!");
             computerScore++;
            return true;
        }
         if(gameboard[0][4] == 'X' && gameboard[1][4] == 'X' && gameboard[2][4] == 'X'){
            System.out.println("PLAYER WINS !!!");
            playerScore++;
            return true;
        }
        if(gameboard[0][4] == 'O' && gameboard[1][4] == 'O' && gameboard[2][4] == 'O'){
            System.out.println("COMPUTER WINS !!!");
             computerScore++;
            return true;
        }
        // Diagonal wins

         if(gameboard[0][0] == 'X' && gameboard[1][2] == 'X' && gameboard[2][4] == 'X'){
            System.out.println("PLAYER WINS !!!");
            playerScore++;
            return true;
        }
        if(gameboard[0][0] == 'O' && gameboard[1][2] == 'O' && gameboard[2][4] == 'O'){
            System.out.println("COMPUTER WINS !!!");
             computerScore++;
            return true;
        }
         if(gameboard[0][4] == 'X' && gameboard[1][2] == 'X' && gameboard[2][0] == 'X'){
            System.out.println("PLAYER WINS !!!");
            return true;
        }
        if(gameboard[0][4] == 'O' && gameboard[1][2] == 'O' && gameboard[2][0] == 'O'){
            System.out.println("COMPUTER WINS !!!");
            return true;
        }

        // return tie game

        if(gameboard[0][0] != '_' && gameboard[0][2] != '_' && gameboard[0][4] != '_' && 
        gameboard[1][0] != '_' && gameboard[1][2] != '_' && gameboard[1][4] != '_' && 
        gameboard[2][0] != '_' && gameboard[2][2] != '_' && gameboard[2][4] != '_'){
            System.out.println("It's a tie !");
            return true;
        }
    return false;
   }

   public static void resetBoard(char[][] gameboard){

        gameboard[0][0] = '_';
        gameboard[0][2] = '_';
        gameboard[0][4] = '_';
        gameboard[1][0] = '_';
        gameboard[1][2] = '_';
        gameboard[1][4] = '_';
        gameboard[2][0] = '_';
        gameboard[2][2] = '_';
        gameboard[2][4] = '_';
   }


}