import java.math.BigInteger;

public class Main_020 {
	public static void main(String[] args) {
		BigInteger start = new BigInteger("100");
		for (int i = 99; i>=1; i--){
			String num = String.valueOf(i);
			BigInteger holder = new BigInteger(num);
			start = start.multiply(holder);
		}
		//System.out.println(start);
		//Add up the digits
		BigInteger num0 = new BigInteger("0");
		BigInteger result = new BigInteger("0");
		int holder = 0;
		BigInteger num10 = new BigInteger("10");
		while (start.compareTo(num0) == 1){
			//holder = (start.mod(num10)).intValue();
			//String num = String.valueOf((start.mod(num10)).intValue());
			BigInteger value = new BigInteger(String.valueOf((start.mod(num10)).intValue()));
			result = result.add(value);
			start = start.divide(num10);
		}
		
		System.out.println(result);
	}
}
