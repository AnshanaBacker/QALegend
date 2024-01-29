package utilities;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtilityClass {
	
	
    public static String getCurrentDateFormatted(String format) {
    	
    	
        DateFormat dateFormat = new SimpleDateFormat(format); // Method to get the current date formatted based on the input format
        Date currentDate = new Date();  // Create a DateFormat object using the provided format
        return dateFormat.format(currentDate);  // Get the current date
        
    }
}