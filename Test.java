import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Test {
public static void main(String[] args) {
	System.out.println("hello");
	String s="this is a test Enquiry; find new <> check";
	System.out.println(s.split("[;<]")[1]);
	
	String date,  pattern="h:mm a,MMM d, yyyy";
	 DateFormat format = new SimpleDateFormat(pattern);
     try {
         format.parse(null);
     } catch (ParseException e) {
     }
}
}
