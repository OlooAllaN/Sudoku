import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * @author allanoloo
 * CS: 220
 * Date: 4/9/2015
 * Lab 4
 */
public class SudokuTester {
	/**
	 * This class prints out my Soduku board and allows interactions with the user.
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		int [][] grid = {
				{5,3,0,0,7,0,0,0,0}, 
				{6,0,0,1,9,5,0,0,0},
				{0,9,8,0,0,0,0,6,0},
				{8,0,0,0,6,0,0,0,3},
				{4,0,0,8,0,3,0,0,1},
				{7,0,0,0,2,0,0,0,6},
				{0,6,0,0,0,0,2,8,0},
				{0,0,0,4,1,9,0,0,5},
				{0,0,0,0,8,0,0,7,9}
		};
		
		Sudoku board = new Sudoku(grid);
		
		
		
		/** Testing the Methods booleans whether returns expected value.
		 * 
		System.out.print(board.checkRow(0,1));
		System.out.println(" Expected: False");
		System.out.print(board.checkRow(0,5));
		System.out.println(" Expected: True");
		System.out.print(board.checkCol(0,6));
		System.out.println(" Expected: True");
		System.out.print(board.checkCol(0,3));
		System.out.println("  Expected: False");
		System.out.print(board.checkBox(1,1,6));
		System.out.println(" Expected: True");
		System.out.print(board.checkBox(2, 3, 4));
		System.out.println(" Expected: False");
		System.out.print(board.insertVal(1,1,6));
		System.out.println(" Expected: False");
		System.out.print(board.insertVal(0, 3, 2));
		System.out.println(" Expected: True");
		System.out.print(board.removeVal(0, 1, 3));
		System.out.println(" Expected: True");
		System.out.print(board.removeVal(1, 0, 4));
		System.out.println(" Expected: False");
		System.out.println(board.filledBox()); 
		System.out.println(board.savedGame());
		*/
	
		
		/**
		 *  Receives user input.
		 */
		Scanner systemIn = new Scanner(System.in);
		System.out.println("\n Welcome To The Sudoku Game ");
		boolean done = false;
		board.printMySudoku();
		while(!done){
			System.out.println("Press \"L\" to Load the game or \"P\" to play.");
			String l = systemIn.next();
			if (l.matches("L")) { 
				System.out.println("Please Enter your file name.");
				String file = systemIn.next();
				loadGame(file);
				
				
			}
			System.out.println("Please enter row number.");
			int row = systemIn.nextInt();
			System.out.println("Please enter column number.");
			int column = systemIn.nextInt();
			System.out.println("Please enter the number you want to insert.");
			int number = systemIn.nextInt();
			if(board.insertVal(row, column, number))
				board.printMySudoku();
			else System.out.println("Invalid move");
			
			/**
			 * Output file that updates after user inserts values in the game.
			 * 
			 */
			PrintWriter outPutFile = new PrintWriter("savedgame");
			outPutFile.println(board.savedGame());
			outPutFile.close();
			done = board.filledBox();
			
		}
		systemIn.close();
	}
	/**
	 * Load game method which allows the user to import a saved game.
	 * @param file 
	 */
	public static void loadGame (String file) {
		try {
			File input = new File(file);
			Scanner in = new Scanner(input);
		    Sudoku board = new Sudoku(in.next());
			in.close();
			board.printMySudoku();
			} catch (FileNotFoundException  exception) {
				System.out.println("File cannot be found, Try again!");
				
			}
	}

}

