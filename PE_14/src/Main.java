
public class Main {

	public static void main(String[] args) {
		long start_num = 0;
		long seq_len = 0;
		long sequence;
		
		for (int i =2; i <= 1000000; i++){
			int length = 1;
			sequence = i;
			while (sequence != 1){
				if ((sequence%2) == 0){
					sequence = sequence /2;
				}
				else{
					sequence = sequence *3 + 1;
				}
				length++;
			}
			
			if (length > seq_len){
				seq_len = length;
				start_num = i;
			}
		}
		System.out.println("Staring num " + start_num + " with length " + seq_len);
	}

}
