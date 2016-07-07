import com.google.gdata.client.spreadsheet.*;
import com.google.gdata.data.spreadsheet.*;
import com.google.gdata.util.*;

import java.io.IOException;
import java.net.*;
import java.util.*;

public class Spreadsheet {
	 public static final String GOOGLE_ACCOUNT_USERNAME = "nikhilesh1060@gmail.com"; // Fill in google account username
     public static final String GOOGLE_ACCOUNT_PASSWORD = "9896175536"; // Fill in google account password
     public static final String SPREADSHEET_URL = "https://spreadsheets.google.com/feeds/spreadsheets/109BFRClapgjksWlxlOKE_jJM5b5enKhsqODjkqlPvow"; //Fill in google spreadsheet URI

  public static void main(String[] args)
      throws AuthenticationException, MalformedURLException, IOException, ServiceException {

//	  GoogleOAuthParameters oauthParameters = new GoogleOAuthParameters();
//	 CLID "901137608676-ottug314pvo7bab6p7ns6i5a40ttopl1.apps.googleusercontent.com"
//	 CS "xOShesj56Jg3A9ar6fTmUBt4"
	  
    SpreadsheetService service =
        new SpreadsheetService("PrintGoogleSpreadsheetDemo");
    
    service.setUserCredentials(GOOGLE_ACCOUNT_USERNAME, GOOGLE_ACCOUNT_PASSWORD);

    // TODO: Authorize the service object for a specific user (see other sections)

    // Define the URL to request.  This should never change.
//    URL SPREADSHEET_FEED_URL = new URL(
//        "https://spreadsheets.google.com/feeds/spreadsheets/private/full");
    
    URL SPREADSHEET_FEED_URL = new URL(SPREADSHEET_URL);
    
    
    SpreadsheetEntry spreadsheet = service.getEntry(SPREADSHEET_FEED_URL, SpreadsheetEntry.class);
    URL listFeedUrl = ((WorksheetEntry) spreadsheet.getWorksheets().get(0)).getListFeedUrl();
service.seta
    // Print entries
    ListFeed feed = (ListFeed) service.getFeed(listFeedUrl, ListFeed.class);
    for(ListEntry entry : feed.getEntries())
    {
      System.out.println("new row");
      for(String tag : entry.getCustomElements().getTags())
      {
        System.out.println("     "+tag + ": " + entry.getCustomElements().getValue(tag));
      }
    }

    // Make a request to the API and get all spreadsheets.
//    SpreadsheetFeed feed = service.getFeed(SPREADSHEET_FEED_URL,
//        SpreadsheetFeed.class);
//    List<SpreadsheetEntry> spreadsheets = feed.getEntries();
//
//    if (spreadsheets.size() == 0) {
//      // TODO: There were no spreadsheets, act accordingly.
//    }
//
//    // TODO: Choose a spreadsheet more intelligently based on your
//    // app's needs.
//    SpreadsheetEntry spreadsheet = spreadsheets.get(0);
//    System.out.println(spreadsheet.getTitle().getPlainText());
//
//    // Make a request to the API to fetch information about all
//    // worksheets in the spreadsheet.
//    List<WorksheetEntry> worksheets = spreadsheet.getWorksheets();
//
//    // Iterate through each worksheet in the spreadsheet.
//    for (WorksheetEntry worksheet : worksheets) {
//      // Get the worksheet's title, row count, and column count.
//      String title = worksheet.getTitle().getPlainText();
//      int rowCount = worksheet.getRowCount();
//      int colCount = worksheet.getColCount();
//
//      // Print the fetched information to the screen for this worksheet.
//      System.out.println("\t" + title + "- rows:" + rowCount + " cols: " + colCount);
//    }
  }
}