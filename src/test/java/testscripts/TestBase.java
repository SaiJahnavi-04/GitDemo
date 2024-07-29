package testscripts;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.ProductPage;

public class TestBase {
	
	WebDriver driver;
	ProductPage apollopages;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("WebDriver.edge.driver", "C:\\Intel\\edgedriver_win64\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
		driver.get("https://www.apollopharmacy.in/");
		
		apollopages = new ProductPage(driver);
	}
	public void mousehover(WebElement element){
		Actions action =new Actions(driver);
		action.moveToElement(element).perform();
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("***Browser is closing be careful..!!***");
		driver.close();
		
	}
	
	public void captureScreenshot(String sName) throws IOException {		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/ScreenShots/"+sName+".png");
		FileUtils.copyFile(source, target);	
	}
}

