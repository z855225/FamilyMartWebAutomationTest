package FamilyMartWebTestSuite.pages;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SalePage {
	
	public static Map<String, String> salePageElementHash() {
		Map<String, String> element = new HashMap<String, String>();
		element.put("immediatelyBuyButtonXpath", "//*[@id='SalePageIndexController']/div/section[1]/div[2]/div[2]/div/div/div/div[2]/button[2]");
		return element;
	}
	
	public static void immediatelyBuy(WebDriver driver) throws InterruptedException {
		Map<String, String> element = salePageElementHash();
		driver.findElement(By.xpath(element.get("immediatelyBuyButtonXpath"))).click();
	}

}
