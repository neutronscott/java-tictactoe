import java.util.Scanner;

public class tictactoe {
	private static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		char[] board = new char[] {'0','1','2','3','4','5','6','7','8'};
		char[] playerPiece = new char[]{ 'X', 'O' };
		int BOARD_SIZE = 9;
		int BOARD_WIDTH = 3;
		boolean gameOver = false;
		boolean win = false;
		boolean draw = false;
		int moves = 0;
		int playerTurn = 0;
		char currentPiece;

		do {
			System.out.printf(" %c | %c | %c \n", board[0], board[1], board[2]);
			System.out.printf("----+----+----\n");
			System.out.printf(" %c | %c | %c \n", board[3], board[4], board[5]);
			System.out.printf("----+----+----\n");
			System.out.printf(" %c | %c | %c \n", board[6], board[7], board[8]);

			// GET playerMove
			currentPiece = playerPiece[playerTurn];
			System.out.print(currentPiece + " move: ");
			int playerMove = in.nextInt();
			
      if (board[playerMove] == playerPiece[0] ||
          board[playerMove] == playerPiece[1]) {
        System.out.println("Invalid move.");
      } else {
  			board[playerMove] = currentPiece;
			  moves++;
  
  			// check the horizontal wins
  			for (int i = 0; i < BOARD_WIDTH; i++) {
  				if (board[i] == board[i+3] && board[i+3] == board[i+6]) {
  					win = true;
  				}
  			}
  			// check the vertical wins
  			for (int i = 0; i < BOARD_SIZE; i += BOARD_WIDTH) {
  				if (board[i] == board[i+1] && board[i+1] == board[i+2]) {
  					win = true;
  				}
  			}
  			// check 2 diag wins
  			if (board[0] == board[4] && board[4] == board[8]) {
  				win = true;
  			}
  			if (board[2] == board[4] && board[4] == board[6]) {
  				win = true;
  			}
  
  			// also check if draw (out of moves)
  			if (moves == BOARD_SIZE) {
  				draw = true;
  			}
  			// this just flip-flops between 0 and 1
  			// could also implement as an if/else
  			playerTurn = (playerTurn + 1) % 2;
  			gameOver = win || draw;
      } // if invalidMove
 		} while (gameOver == false);

		// now we care if the game ended from win or draw

		// we update currentPiece at beginning, and playerTurn at end...
		// so once we exit our loop playerTurn is too far ahead
		// could rewind, or just keep a nicely named extra variable, currentPeice
		// a step behind
		if (draw == true) {
			System.out.println("No winner.");
		} else {
			System.out.println(currentPiece + " wins!");
		}
	}
}
