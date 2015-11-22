
public class Main {

	public static void main(String[] args) {
		long curr_num = 0;
		long curr_count = 1;
		
		while (factorCount(curr_num) < 500){
			System.out.println(curr_num);
			curr_num = curr_num + curr_count;
			curr_count++;
		}
		System.out.println(curr_num);
	}
	
	public static long factorCount(long n){
		long count = 0;
		long sqrt = (long) Math.sqrt(n);
		for (long i = 1; i <= sqrt; i++){
			if (n%i == 0){
				count+=2;
			}
		}
		//Correction if number is a perfect square
		if (sqrt * sqrt == n){
			count--;
		}
		return count;
		
	}

}
