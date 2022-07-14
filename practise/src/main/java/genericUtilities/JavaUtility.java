package genericUtilities;

import java.util.Date;
import java.util.Random;

/**
 * its Contains Java Specific lLibraries Like getRandomdata & getSystemDate etc
 * @author HP
 *
 */
public class JavaUtility {
/**
 * its used to generate the random number with in the range of 1000
 * @return
 */
	public int getRandomNumber() {
		Random random = new Random();
		int randNum = random.nextInt(1000);
		return randNum;
	}
	/**
	 * its used to get Current  system DateAnd Time in IST Format
	 * @return
	 */
	public String getSystemDateAndTimeInISTFormat() {
		Date date=new Date();
		return date.toString();
	}
	/**
	 * its used to get current system date based on DD-MM-YYYY format
	 * @return
	 */
	public String getSystemDateAndTimeInStandardFormat() {
		Date date=new Date();
		String dateAndTime = date.toString();
		String yyyy = dateAndTime.split(" ")[5];
		String DD = dateAndTime.split(" ")[2];
		int MM = date.getMonth()+1;
		String finalFormat = yyyy+"/"+DD+"/"+"/"+MM;
		return finalFormat;
		
	}
}
