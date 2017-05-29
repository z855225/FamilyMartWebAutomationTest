package FamilyMartWebTestSuite.pages;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	public static Map<String, String> homePageElementHash() {
		Map<String, String> element = new HashMap<String, String>();
		element.put("officialRecommendButtonLinkText", "人氣推薦");
		return element;
	}
	
	public static void goToOfficialRecommendPage(WebDriver driver) throws InterruptedException {
		Map<String, String> element = homePageElementHash();
		driver.findElement(By.linkText(element.get("officialRecommendButtonLinkText"))).click();
		Thread.sleep(2000);
	}

}
