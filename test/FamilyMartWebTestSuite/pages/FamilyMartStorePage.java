package FamilyMartWebTestSuite.pages;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FamilyMartStorePage {
	
	public static Map<String, String> familyMartStorePageElementHash() {
		Map<String, String> element = new HashMap<String, String>();
		element.put("selectStoreByStreetButtonXpath", "//*[@id='menu']/table/tbody/tr/td[1]/a/div/span");
		element.put("taipeiCityButtonXpath", "//*[@id='buttonContentDiv']/div[2]/a/span");
		element.put("songshanDistButtonXpath", "//*[@id='buttonContentDiv']/div[9]/a/span");
		element.put("sec4BadeRdButtonXpath", "//*[@id='buttonContentDiv']/div[3]/a/span");
		element.put("no40ButtonXpath", "//*[@id='content']/table/tbody/tr[2]/td/table[2]/tbody/tr[1]/td[2]/span[1]");
		element.put("storeConfirmButtonXpath", "//*[@id='ctl00_ContentPlaceHolder1_checkStoreLabel']");
		return element;
	}
	
	public static void selectStoreByStreet(WebDriver driver) throws InterruptedException {
		Map<String, String> element = familyMartStorePageElementHash();
		driver.findElement(By.xpath(element.get("selectStoreByStreetButtonXpath"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(element.get("taipeiCityButtonXpath"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(element.get("songshanDistButtonXpath"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(element.get("sec4BadeRdButtonXpath"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(element.get("no40ButtonXpath"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(element.get("storeConfirmButtonXpath"))).click();
	}

}
