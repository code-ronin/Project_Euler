import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Create 2D Array to hold values, and fill the array
		int[][] grid = new int[20][20];
		gridParser(grid, 20, 20);

		//Calculate largest product of four adjacent values
			//Horizontal result
		int r1 = horizontal(grid, 20, 20);
		System.out.println(r1);
			//Vertical result
		int r2 = vertical(grid, 20, 20);
		System.out.println(r2);
			//Diagonal (/)
		int r3 = diag_1(grid, 20, 20);
		System.out.println(r3);
			//Diagonal (\)
		int r4 = diag_2(grid, 20, 20);
		System.out.println(r4);
	}
	//Horizontal product calculator
	public static int horizontal(int[][] grid, int row_max, int col_max){
		int result = 0;
		int row = 0;
		int col = 0;
		while (true){
			if (col == (col_max-3)){
				col = 0;
				row++;
				if (row == row_max){
					break;
				}
			}
			if ((grid [row][col] * grid [row][col+1] * grid [row][col+2] * grid [row][col+3]) > result){
				result = (grid [row][col] * grid [row][col+1] * grid [row][col+2] * grid [row][col+3]);
			}
			col++;
		}
		return result;
	}
	//Vertical product calculator
	public static int vertical(int[][] grid, int row_max, int col_max){
		int result = 0;
		int row = 0;
		int col = 0;
		while (true){
			if (row == (row_max-3)){
				row = 0;
				col++;
				if (col == col_max){
					break;
				}
			}
			if ((grid [row][col] * grid [row+1][col] * grid [row+2][col] * grid [row+3][col]) > result){
				result = (grid [row][col] * grid [row+1][col] * grid [row+2][col] * grid [row+3][col]);
			}
			row++;
		}
		return result;
	}
	//Diagonal (/) product calculator
	public static int diag_1(int[][] grid, int row_max, int col_max){
		int result = 0;
		int row = row_max-1;
		int col = 0;
		while (true){
			if (col == (col_max-3)){
				col = 0;
				row--;
				if (row == 2){
					break;
				}
			}
			if ((grid [row][col] * grid [row-1][col+1] * grid [row-2][col+2] * grid [row-3][col+3]) > result){
				result = (grid [row][col] * grid [row-1][col+1] * grid [row-2][col+2] * grid [row-3][col+3]);
			}
			col++;
		}
		return result;
	}
	//Diagonal (\)
	public static int diag_2(int[][] grid, int row_max, int col_max){
		int result = 0;
		int row = 0;
		int col = 0;
		while (true){
			if (col == (col_max-3)){
				col = 0;
				row++;
				if (row == (row_max-3)){
					break;
				}
			}
			if ((grid [row][col] * grid [row+1][col+1] * grid [row+2][col+2] * grid [row+3][col+3]) > result){
				result = (grid [row][col] * grid [row+1][col+1] * grid [row+2][col+2] * grid [row+3][col+3]);
			}
			col++;
		}
		return result;
	}
	//Turn array in text file to a 2D array in Java
	@SuppressWarnings("resource")
	public static int[][] gridParser(int[][] grid, int row_max, int col_max){
		//Create Scanner to read file
		Scanner inFile1 = null;
	    try {
			inFile1 = new Scanner(new File("Grid.txt")).useDelimiter("\\s+");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	    //String to hold value from file
	    String num = "";
	    int row = 0;	//Grid Coordinates
	    int col = 0;	//Grid Coordinates
	    //Grab numbers from text file and remove leading zeroes from the numbers if they include any
	    while (inFile1.hasNext()) {
	    	num = inFile1.next();
	    	if (num.charAt(0) == '0'){
	    		num = Character.toString(num.charAt(1));
	    	}
	    	//Add numbers into the array
	    	if (col == col_max){
	    		col = 0;
	    		row++;
	    	}
	    	grid [row][col] = Integer.parseInt(num);
	    	col++;
	    }
	    inFile1.close();
		return grid;
	}
	
	

}
