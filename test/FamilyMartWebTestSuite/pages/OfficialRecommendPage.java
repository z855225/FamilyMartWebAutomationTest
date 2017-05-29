package FamilyMartWebTestSuite.pages;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OfficialRecommendPage {
	
	public static Map<String, String> hotSaleRankingPageElementHash() {
		Map<String, String> element = new HashMap<String, String>();
		element.put("Top1SaleItemXpath", "/html/body/div[2]/div[2]/div[2]/div[1]/div/section[2]/div/div/ul/li[8]/div/a/div/div/div[2]");
		return element;
	}
	
	public static void goToTop1SalePage(WebDriver driver) throws InterruptedException {
		Map<String, String> element = hotSaleRankingPageElementHash();
		
		//跳過限時搶購商品
		WebElement target = driver.findElement(By.xpath(element.get("Top1SaleItemXpath")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", target);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath(element.get("Top1SaleItemXpath"))).click();
	}

}
