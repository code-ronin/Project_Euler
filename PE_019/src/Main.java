import java.util.Calendar;

public class Main {

	public static void main(String[] args) {
		int sundays = 0;
		
		for (int year = 1901; year <= 2000; year++){
			for(int month = 1; month <= 12; month++){
				Calendar startDate = Calendar.getInstance();
				startDate.set(year, month, 1);
				if (startDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
					sundays++;
				}
			}
		}
		
		System.out.println(sundays);

	}

}
