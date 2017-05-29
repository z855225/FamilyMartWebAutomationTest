package FamilyMartWebTestSuite.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Actions {
	
	public static String takeScreenShot(WebDriver driver) {  
	    Date systemTime = new Date();
	    SimpleDateFormat systemTimeFormat = new SimpleDateFormat("yyyMMdd_HH-mm-ss");
	    String time = systemTimeFormat.format(systemTime);
	    String fileDir = "/Users/River_Lin/Documents/workspace/testreport/ScreenShot/" + time + ".jpeg";
		
	    try {
	    	File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	
	    	FileUtils.copyFile(scrfile, new File(fileDir));
	    	
	    }
	    
	    catch(Exception e) {
	    	System.out.println("screen shot error:" + e.getMessage());
	    }
		
		return fileDir;
	}

}
