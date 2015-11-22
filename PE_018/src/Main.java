import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Get triangle depth
		int lines = countLines();
		// Place the grid into a triangle
		int[][] grid= getTriangle();
		// Solve for max value
		// 1. Using the bottom --> top approach
		for (int i = lines -2; i>= 0; i--){
			for (int j = 0; j<= i; j++){
				grid [i][j] += Math.max(grid[i+1][j], grid [i+1][j+1]);
			}
		}
		System.out.println(grid [0][0]); //Asnswer will be here (at the top)
		
	}
	
//Function to read each line of the pyramid and place these into an array
	public static int[][] getTriangle(){
		int count = countLines();
		int[][] grid = new int[count][];	//Create 2D array here
		
		// 2. Populate the grid
		//Create Scanner to read file
		Scanner inFile1 = null;
	    try {
			inFile1 = new Scanner(new File("triangle.txt")).useDelimiter("\\s+");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	    
		for(int i = 0; i < grid.length; i++)
		{
			grid[i] = new int[i+1];

		    for(int j = 0; j < grid[i].length; j++)
		    {
		    	String num = inFile1.next();
		    	if (num.charAt(0) == '0'){
		    		num = Character.toString(num.charAt(1));
		    	}
		        grid[i][j] = Integer.parseInt(num);
		    }
		}
	    inFile1.close();
	    // Print array to TEST
	    //System.out.println(Arrays.deepToString(grid));
		return grid;
	}
	
//Count number of lines in text file	
	public static int countLines(){
		//1. count # of lines in text file to develop size for 2d array
		int count = 0;
		FileInputStream fstream = null;
		try {
			fstream = new FileInputStream("triangle.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		try {
			while ((strLine = br.readLine()) != null)   {
			  count++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//TEST LINE
		//System.out.println(count);	
		return count;
	}
}
