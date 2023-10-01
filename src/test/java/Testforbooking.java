import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pop.classes.MainPage;

public class Testforbooking {
	
	private WebDriver driver;
	@BeforeClass
	public void setproperty()
	{
		System.setProperty("webdriver.chrome.driver", "E:/Testproject/chromedriver_win32/chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("https://www.cleartrip.com/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@BeforeMethod
	public void SearchFlight()
	{
		
		MainPage page = new MainPage(driver);
		page.selectSourcePlace();
		page.selectDestinationPlace();
		
		page.selectDate(driver);
		page.searchFlight();
	}
	
	@Test
	public void Testpage()
	{
		System.out.println("This is test page");
	}
	@AfterMethod
	public void afterMethod()
	{
		driver.close();
	}

}
