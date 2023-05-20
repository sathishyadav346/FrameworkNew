package genericLibraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class contains reusable method to perform java related operations
 * @author HP
 *
 */
public class JavaUtility {
	/**
	 * This method generates and returns random number within specified limit
	 * @param limit
	 * @return
	 */
	
	
	public int generateRandomNumber(int limit) {
		Random random = new Random();
		return random.nextInt(limit);
		
		
	}
	/**
	 * this method is used to return current time 
	 * @return
	 */
	
	public String getCurrentTime() {
		
		Date date = new Date();
		SimpleDateFormat sdf = SimpleDateFormat("dd_MM_yy_hh_mm_sss");
		return sdf.format(date);
		
		
	}
	
	
	private SimpleDateFormat SimpleDateFormat(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
