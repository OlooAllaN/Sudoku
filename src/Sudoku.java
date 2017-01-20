import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author allanoloo 
 * CS: 220 Date:
 * 4/9/2015 Lab 4
 */

public class Sudoku {
	private int[][] grid;
	final int ROW = 9;
	final int COLUMN = 9;
	final int BOXSIZE = 3;

	/**
	 * Constructor default grid 9x9 demonstrated in constants.
	 * 
	 */
	public Sudoku() {
		grid = new int[ROW][COLUMN];

	}

	/**
	 * This constructor will have array list in parameters.
	 * @param
	 * 
	 */
	public Sudoku(int[][] grid) {
		this.grid = grid;

	}

	/**
	 * Josh Sauder CS scientist  - Helped me understand how to execute a code to update my Sudoku from file.
	 * 
	 * Updates the the grid with new values from file.
	 * @param values inserted by the users.
	 * 
	 */
	public Sudoku(String values) {
		int count = 0;
		grid = new int[ROW][COLUMN];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = Integer.valueOf(values.substring(count, count + 1));
				count += 2;
			}
		}
	}

	public void printMySudoku() {
		System.out.println("=================");
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					System.out.print(" |");

				} else
					System.out.print(grid[i][j] + "|");
			}
			System.out.println("");
		}
		System.out.println("==================");

	}

	/**
	 * Mutator checks each column and row, and if equal to zero value will be
	 * inserted.
	 * 
	 * @param topLeftRow
	 * @param topLeftCol
	 **/

	public boolean insertVal(int r, int c, int val) {
		r--;
		c--;
		if (grid[r][c] == 0) {
			if (checkRow(r, val) && checkCol(c, val) && checkBox(r, c, val)){
				grid[r][c] = val;
				return true;
			}
			return false;
		} else {
			return false;
		}
	}

	/**
	 * Removes values and changes it zero.
	 * 
	 * @param r represents row.
	 * @param c represents column.
	 * @param val
	 * @return r and c equal val will return true and change to 0.
	 */

	public boolean removeVal(int r, int c, int val) {
		if (grid[r][c] == val) {
			grid[r][c] = 0;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks the value indicated by column and row.
	 * @param r
	 * @param val
	 * @return
	 * 
	 */

	public boolean checkRow(int r, int val) {
		for (int i = 0; i < grid.length; i++) {
			if (grid[r][i] == val) {
				return false;
			}
		}
		return true;
	}

	public boolean checkCol(int c, int val) {
		for (int i = 0; i < grid.length; i++) {
			if (grid[i][c] == val) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Allows the Soduku game to be saved after entered values.
	 * @return
	 * @throws FileNotFoundException
	 */
	public String savedGame() throws FileNotFoundException {
		String saveString = "";
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (i == 8 && j == 8)
					saveString += grid[i][j];
				else
					saveString += grid[i][j] + ",";

			}
		}
		return saveString;
	}
	
	
	/**
	 * Inserts values starting from the upper left corner.
	 * @param topLeftRow stands for upper left row in a box
	 * @param TopLeftCol stands for the upper left column.
	 * @param val
	 * @return
	 * 
	 */
	public boolean checkBox(int topLeftRow, int TopLeftCol, int val) {
		topLeftRow = topLeftRow / BOXSIZE;
		TopLeftCol = TopLeftCol / BOXSIZE;
		for (int currentRow = topLeftRow; currentRow <= topLeftRow + 2; currentRow++) {
			for (int currentColumn = TopLeftCol; currentColumn < TopLeftCol + BOXSIZE; currentColumn++) {
				if (grid[currentRow][currentColumn] == val) {
					return false;
				}

			}
		}
		return true;

	}

	/**
	 * Checks the grid[][] if it is filled.
	 * @return
	 * 
	 */

	public boolean filledBox() {
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid.length; c++) {
				if (grid[r][c] == 0) {
					return false;
				}
			}

		}
		return true;
	}

}
