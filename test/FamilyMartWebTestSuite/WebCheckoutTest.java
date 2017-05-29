package FamilyMartWebTestSuite;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import FamilyMartWebTestSuite.pages.*;
import FamilyMartWebTestSuite.common.Actions;
import org.testng.annotations.BeforeTest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class WebCheckoutTest {
	
    public static WebDriver driver;
    public static ExtentReports report;
    public static ExtentTest test;

    @BeforeTest
    public void beforeTest() throws InterruptedException {
    	report = new ExtentReports("/Users/River_Lin/Documents/workspace/testreport/FamilyMartWebReport.html", false);
    	test = report.startTest("Checkout Test", "首頁 > 人氣推薦商品 > 第一個產品 > 立即結帳 > 選取超商取貨付款 > 填寫資料，並選取任一個門市");
    	System.setProperty("webdriver.chrome.driver", "/Users/River_Lin/Documents/workspace/chromedriver");
    	
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("start-fullscreen");
    	Map<String, Object> prefs = new HashMap<String, Object>();
    	prefs.put("credentials_enable_service", false);
    	prefs.put("profile.password_manager_enabled", false);
    	options.setExperimentalOption("prefs", prefs);
    	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
    	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
    	driver = new ChromeDriver(capabilities);
    	
    	String currentWindowHandle = driver.getWindowHandle();
    	((JavascriptExecutor)driver).executeScript("alert('Test')"); 
    	driver.switchTo().alert().accept();
    	driver.switchTo().window(currentWindowHandle);
    	
    	driver.navigate().to("http://mart.family.com.tw");
    	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
	
    @Test
    public void checkout() throws Exception {
    	
    	try{
	    	HomePage.goToOfficialRecommendPage(driver);
	    	
	    	OfficialRecommendPage.goToTop1SalePage(driver);
	    	
	    	SalePage.immediatelyBuy(driver);
	    	
	    	LoginPage.login(driver, "account", "password");
	    	
	    	ShoppingCartConfirmPage.goToPaymentAndShipmentPage(driver);
	    	
	    	PaymentAndShipmentPage.selectPayAtStore(driver);
	    	PaymentAndShipmentPage.selectShipToFamilyMart(driver);
	    	PaymentAndShipmentPage.goToPaymentInfoPage(driver);
	    	PaymentInfoPage.enterName(driver, "林老師");
	    	PaymentInfoPage.enterPhoneNumber(driver, "0912345678");
	    	PaymentInfoPage.selectStore(driver);
	    	
	    	FamilyMartStorePage.selectStoreByStreet(driver);
	    	
	    	PaymentInfoPage.enterEmail(driver, "rivertest62@gmail.com");
	    		
	    	test.log(LogStatus.PASS, "The Test Result: PASS");
	        Thread.sleep(1000);
	        String fileDir = Actions.takeScreenShot(driver);
		test.log(LogStatus.INFO, "image: " +  test.addScreenCapture(fileDir));
    	}

    	catch(Exception e) {
	    	  System.out.println("error tset");
	    	  test.log(LogStatus.FAIL, e.getMessage());
	    	  String fileDir = Actions.takeScreenShot(driver);
	    	  test.log(LogStatus.INFO, "error image: " +  test.addScreenCapture(fileDir));
	}
    }
  
    @AfterTest
    public void afterTest() {
    	report.endTest(test);
	report.flush();
    	driver.close();
    }

}
