
public class Main {

	public static void main(String[] args) {
		//In how many ways can we choose N out of 2N possible places if the order does not matter?
		//2N Choose N --> N Choose K
		// Product sum from i=1 to K of (N-K +i)/i
		// Here, N = 20 (All paths are 2N or 40, there are 10 R's and 10 D's, so N is 20)
		int gridSize = 20;
		long N = 40;
		long K = 20;
		long value = binomialCoefficient(40, 20);
		System.out.println(value);
	}

	//Binomial Coefficient calculation
	public static long binomialCoefficient (long n, long k){
		long value = 1;
		for (int i = 1; i<= k; i++){
			value *= (n - k + i);
			value /= i;
		}
		return value;
	}
	
}
