import java.util.BitSet;

public class Main_021 {
	public static void main(String[] args) {
		int upperLimit = 100000;
		int sumAmicable = 0;
		int sum1, sum2 = 0;
		//for (int i = 1; i<=upperLimit; i++){
			//Get factors for number 1 and the sum of the factors
			BitSet FactorSet1 = numFactors(220);
			
			sum1 = sumFactors(FactorSet1);
			System.out.println(sum1);
			//Get factors for number 2
			BitSet FactorSet2 = numFactors(sum1);
			sum2 = sumFactors(FactorSet2);
			System.out.println(sum2);
			//Compare the results with dFunction
		//}
	}

	//Calculate Factors for number
	public static BitSet numFactors(int num){
		BitSet FactorBits = new BitSet(num);
		for (int i=1; i<num; i++){
			if(num%i == 0){
				FactorBits.set(i);
			}
		}
		System.out.println(FactorBits);
		return FactorBits;
	}
	//Calculate sum of factors
	public static int sumFactors(BitSet numFactors){
		int result = 0;
		while(!numFactors.isEmpty()){
			int value = numFactors.nextSetBit(0);
			numFactors.clear(value);
			result = result + value;
		}
		//System.out.println(result);
		return result;
	}
	// Sum of proper divisors of n
	public static int dnFunction(int n){
		int result = 0;
		for (int i = 1; i < n; i++){
			if (n%i == 0){
				result += i;
			}
		}
		return result;
	}
	
	//Sieve of Eratosthenes
	public static BitSet ESieve (int upperLimit){
		//Store prime numbers as an index in a bit array
		BitSet PrimeBits = new BitSet(upperLimit+1);
		for (int i=2; i<upperLimit+1; i++){
			PrimeBits.set(i);
		}
		//Run the sieve
		int count = 1;
		for (int i=2; i<upperLimit/2; i++){
			if(PrimeBits.get(i)){
				for(int j=i; j <= upperLimit; j+=i){
					PrimeBits.clear(j+i);
				}
			}
		}
		//PrimeBits.clear(4);
		System.out.println(PrimeBits);
		//System.out.println(PrimeBits.size());
		System.out.println("The number of prime numbers less than "+ upperLimit + " is " + PrimeBits.cardinality());
		return PrimeBits;
	}
}
