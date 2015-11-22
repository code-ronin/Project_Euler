
public class Main_001 {

	public static void main(String[] args) {
		int result=0;
		//Find the natural numbers below 1000 that are multiples of 3 or 5
		for (int i=0; i<1000; i++){
			//If it meets the criteria above, add it to the sum
			if(i%3 == 0){
				result+=i;
			}
			else if(i%5==0){
				result+=i;
			}
		}
		System.out.println(result);
	}

}
