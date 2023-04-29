// Hannah Lee
// 04/09/23
// CSE 123
// TA: Darel Gunawan
// Creative Assignment 0: Abstract Strategy Games
// This class runs a ConnectFour game with two players and determines either who is
//      the winner or if there is a tie.

import java.util.*;

public class ConnectFour implements AbstractStrategyGame {
    private char[][] board;
    private boolean isPlayerTurn;

    // This is the constructor that initializes the board and first player
    //      of the game.
    // parameters:
    //      none
    // returns:
    //      none
    public ConnectFour(){
        board = new char[][]{{'-', '-', '-', '-', '-', '-', '-'},
                             {'-', '-', '-', '-', '-', '-', '-'},
                             {'-', '-', '-', '-', '-', '-', '-'},
                             {'-', '-', '-', '-', '-', '-', '-'},
                             {'-', '-', '-', '-', '-', '-', '-'},
                             {'-', '-', '-', '-', '-', '-', '-'}};
        isPlayerTurn = true;
    }
    
    // this method create a String representation of the instructions for the game.
    // parameters:
    //      none
    // returns:
    //      String inst: the String representations of the instructions
    public String instructions(){
        String inst = "";
        inst += "Connect Four Instructions: Players are assigned a token and then take\n";
        inst += "turns dropping their tokens into a seven-column, six-row vertically\n";
        inst += "suspended grid. The pieces fall straight down, occupying the lowest\n";
        inst += "available space within the column. The objective of the game is to be\n";
        inst += "the first to form a horizontal, vertical, or diagonal line of four\n";
        inst += "of one's own tokens.\n";
        inst += "If the board is filled with each player's tokens but four of the same tokens\n";
        inst += "are not in a row, the game ends in a tie and neither player wins a point.\n";
        inst += "How to Play: When the character next to Your Turn is a Circle, that\n";
        inst += "means it is your turn to make a move. Enter the row and column numbers to\n";
        inst += "indicate where you want to place your token on the board. The column numbers\n";
        inst += "from left to right are '1 - 7' and the row is the lowest position\n";
        inst += "in the chosen column.";
        return inst;
    }

    // This method returns the String representation of the ConnectFour game as it is being
    //      played. Every move made is added to the String represenation of the board.
    // parameters:
    //      none
    // returns:
    //      String result: the String representation of the game playing out.
    public String toString(){
        String result = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <= board.length; j++) {
                result += board[i][j] + " ";
            }
            result += "\n";
        }
        return result;
    }

    // This method returns the number representation of who the next player is.
    // parameters:
    //      none
    // returns:
    //      int: number representation of who the next player is
    public int getNextPlayer() {
        return isPlayerTurn ? 1 : 2;
    }

    // This method prompts the player to enter the column number of where they want to place
    //      their token. The inputed column number is not zero-based indexed and is the literal 
    //      column number from 1-7. Throws an IllegalArgumentException if an invalid row or
    //      column is chosen.
    // parameters:
    //      Scanner input: enables user input and for the player to choose their column number
    // returns:
    //      none
    public void makeMove(Scanner input){
        char currPlayer = isPlayerTurn ? 'X' : 'O';

        System.out.print("Column? ");
        int col = input.nextInt() - 1;

        makeMove(col, currPlayer);
        isPlayerTurn = !isPlayerTurn;
    }

    // This method is the private helper method for makeMove. Given a col number,
    //      as well as player character, the method places an X or an O in that col.
    //      The token drops as far down as it can on the board like real-life Connect Four
    //      and if there is a token in the column already, their token is placed on top of that
    //      token. It throws an IllegalArgumentException if the is column is already full or if
    //      the chosen column is out of bounds. The board bounds are [0, 6] for rows and
    //      [0, 7] for cols.
    // parameters:
    //      int col: the player's chosen column for where they want to place their token
    //      char player: the player's token 'X' or 'O'
    // returns:
    //      none
    private void makeMove(int col, char player) {
        if (col < 0 || col > board[0].length){
            throw new IllegalArgumentException("Invalid board position: Col " + (col + 1));
        }
        boolean spaceFilled = true;
        int row = 5;
        while (spaceFilled){
            if (board[row][col] != '-'){
                row --;
            } else {
                spaceFilled = false;
            }
            if (row == -1 && spaceFilled){
                throw new IllegalArgumentException("Invalid board position: Col " + col + 
                    " already full");
            }
        }
        
        board[row][col] = player;
    }

    // This method either returns the winner of the game, if there is a tie, or if the
    //      game is not yet over.
    // parameters: 
    //      none
    // returns:
    //      an integer based on the outcome of the game. If there are 4 X's in a row (1).
    //          if there are 4 O's in a row (2). If there is a tie (0). If the game is not yet
    //          over (-1).
    public int getWinner(){
        for (int i = 0; i < board.length; i++) {
            // check row i
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2]
                && board[i][0] == board[i][3] && board[i][0] != '-') {
                return board[i][0] == 'X' ? 1 : 2;
            } else if (board[i][1] == board[i][2] && board[i][1] == board[i][3]
                && board[i][1] == board[i][4] && board[i][1] != '-') {
                return board[i][1] == 'X' ? 1 : 2;
            } else if (board[i][2] == board[i][3] && board[i][2] == board[i][4]
                && board[i][2] == board[i][5] && board[i][2] != '-') {
                return board[i][2] == 'X' ? 1 : 2;
            } else if (board[i][3] == board[i][4] && board[i][3] == board[i][5]
                && board[i][3] == board[i][6] && board[i][3] != '-') {
                return board[i][3] == 'X' ? 1 : 2;
            }
            
            // check col i
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i]
                && board[0][i] == board[3][i] && board[0][i] != '-') {
                return board[0][i] == 'X' ? 1 : 2;
            } else if (board[1][i] == board[2][i] && board[1][i] == board[3][i]
                && board[1][i] == board[4][i] && board[1][i] != '-') {
                return board[1][i] == 'X' ? 1 : 2;
            } else if (board[2][i] == board[3][i] && board[2][i] == board[4][i]
                && board[2][i] == board[5][i] && board[2][i] != '-') {
                return board[2][i] == 'X' ? 1 : 2;
            }
        }

        // check diagonal top-left to bottom-right
        for (int i = 0; i < board.length - 3; i++) {
            for (int j = 0; j < board[0].length - 3; j++) {
                if (board[i][j] == board[i+1][j+1] && board[i][j] == board[i+2][j+2]
                    && board[i][j] == board[i+3][j+3] && board[i][j] != '-') {
                    return board[i][j] == 'X' ? 1 : 2;
                }
            }
        }

        // check diagonal bottom-left to top-right
        for (int i = 3; i < board.length; i++) {
            for (int j = 0; j < board[0].length - 3; j++) {
                if (board[i][j] == board[i-1][j+1] && board[i][j] == board[i-2][j+2]
                    && board[i][j] == board[i-3][j+3] && board[i][j] != '-') {
                    return board[i][j] == 'X' ? 1 : 2;
                }
            }
        }

        // check for tie
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '-') {
                    // unfilled space; game not over
                    return -1;
                }
            }
        }

        // it's a tie!
        return 0;
    }

    // This method returns whether or not the game is over.
    // parameters:
    //      none
    // returns:
    //      boolean: whether or not the game is over
    public boolean isGameOver(){
        return getWinner() >= 0;
    }
}
