package pop.classes;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

	@FindBy(xpath="//input[contains(@placeholder,'Where from')]")
	private WebElement input1;
	
	@FindBy(xpath="(//p[contains(text(),'Bangalore')])[1]")
	private WebElement Bangaloredropdown;
	
	
	@FindBy(xpath="//input[contains(@placeholder,'Where to')]")
	private WebElement input2;
	
	@FindBy(xpath="(//p[contains(text(),'Delhi')])[1]")
	private WebElement Delhidropdown;
	
	@FindBy(xpath="(//button[contains(@class,'flex flex-middle')])[3]")
	private WebElement fromDate;

	@FindBy(xpath="(//div[contains(@aria-selected,'true')])[1]//div/div")
	private WebElement todayDate;
	
	@FindBy(xpath="(//div[contains(@aria-selected,'true')])[3]")
	private WebElement returnDate;

	@FindBy(xpath="(//span[contains(text(),'Search')])[1]")
	private WebElement searchbtn;
	public MainPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void selectSourcePlace()
	{
		input1.sendKeys("Bangalore");
		Bangaloredropdown.click();
		
	}
	public void selectDestinationPlace()
	{
		input2.sendKeys("Delhi");
		Delhidropdown.click();
	}
	public void selectDate(WebDriver driver)
	{
		fromDate.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", todayDate);
		todayDate.click();
		returnDate.click();
		
	}
	public void searchFlight()
	{
		searchbtn.click();
	}
}
