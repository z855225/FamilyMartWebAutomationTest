package FamilyMartWebTestSuite.pages;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentAndShipmentPage {
	
	public static Map<String, String> paymentAndShipmentPageElementHash() {
		Map<String, String> element = new HashMap<String, String>();
		element.put("payAtStoreOptionXpath", "/html/body/div[2]/div[2]/div[1]/div/div/div/div/div[1]/div/ul/li[1]/div");
		element.put("shipToFamilyMartOptionXpath", "/html/body/div[2]/div[2]/div[1]/div/div/div/div/div[2]/div/ul/li/div");
		element.put("nextButtonXpath", "/html/body/div[2]/div[2]/div[1]/div/div/div/div/div[4]/div/button");
		return element;
	}
	
	public static void selectPayAtStore(WebDriver driver) throws InterruptedException {
		Map<String, String> element = paymentAndShipmentPageElementHash();
		driver.findElement(By.xpath(element.get("payAtStoreOptionXpath"))).click();
		Thread.sleep(2000);
	}
	
	public static void selectShipToFamilyMart(WebDriver driver) throws InterruptedException {
		Map<String, String> element = paymentAndShipmentPageElementHash();
		driver.findElement(By.xpath(element.get("shipToFamilyMartOptionXpath"))).click();
		Thread.sleep(2000);
	}
	
	public static void goToPaymentInfoPage(WebDriver driver) throws InterruptedException {
		Map<String, String> element = paymentAndShipmentPageElementHash();
		WebElement target = driver.findElement(By.xpath(element.get("nextButtonXpath")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", target);
		Thread.sleep(2000);
		driver.findElement(By.xpath(element.get("nextButtonXpath"))).click();
		Thread.sleep(2000);
	}

}
