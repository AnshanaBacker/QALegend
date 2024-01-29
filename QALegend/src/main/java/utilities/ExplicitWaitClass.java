package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitClass {

	public void PresenceOfElementLocatedById(WebDriver driver,String locator)
	{
		WebDriverWait wait=new WebDriverWait (driver,Duration.ofMillis(10));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(locator)));
		
	}
	public void presenceOfElementLocatedByXpath(WebDriver driver,String locator)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}
	public void elementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void elementToBeClickableById(WebDriver driver,String locator)	
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofMillis(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.id(locator)));
	}
	
	
	
	
}
