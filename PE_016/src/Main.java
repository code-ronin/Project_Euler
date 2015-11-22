import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		long result = 0;
		
		int exponent = 1000;
		BigInteger num0, num1, num2, num3;
		num0 = new BigInteger("0");
		num1 = new BigInteger("2");
		num2 = num1.pow(exponent);
		num3 = new BigInteger("10");
		
		while (num2.compareTo(num0) == 1){
			result += (num2.mod(num3)).intValue();
			num2 = num2.divide(num3);
		}
		
		System.out.println(result);
	}

}
