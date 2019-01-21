package quickStart.selenium.coreFramework.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime { 

	public static String uniqueStringStamp() {
		
	String uniqueDateTimeStamp; 
	LocalDateTime dateTime = LocalDateTime.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy HH:mm:ss");
	String formattedDate = dateTime.format(formatter);
	 
	uniqueDateTimeStamp = (formattedDate.replace(':', '_')).replace('/', '_');
	return uniqueDateTimeStamp;
	
	}
}
