import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		BigInteger num = fileParser();
		System.out.println(num);

	}

	//Sum 
	@SuppressWarnings("resource")
	public static BigInteger fileParser(){
		BigInteger num = new BigInteger("0");
		String val = "";
		//Create Scanner to read file
		Scanner inFile1 = null;
	    try {
			inFile1 = new Scanner(new File("Numbers.txt")).useDelimiter("\\r\\n");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	    while (inFile1.hasNext()) {
	    	val = inFile1.next();
	    	num = num.add(new BigInteger(val));
	    }
	    inFile1.close();
		return num;
	}
	
	

}
