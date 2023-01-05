package BasicTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Launch {
	
	@Test
	public void simpleLaunch() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\apoor\\Documents\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://visa.vfsglobal.com/ind/en/swe/login");
		Thread.sleep(5000);		
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/input[@placeholder='jane.doe@email.com']")));	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='mat-button-wrapper']")));	
		driver.findElement(By.xpath("//div/input[@placeholder='jane.doe@email.com']")).sendKeys("gurdeep.singh.elux@gmail.com");
		driver.findElement(By.xpath("//div/input[@formcontrolname='password']")).sendKeys("Mskohli@2");		
		driver.findElement(By.xpath("//span[@class='mat-button-wrapper']")).click();
		driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Active application(s)']")));
		driver.findElement(By.xpath("//div[text()='Active application(s)']")).click();
	
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='mat-focus-indicator btn mat-btn-lg btn-brand-orange d-none d-lg-inline-block position-absolute top-n3 right-0 z-index-999 mat-raised-button mat-button-base']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c85-4 ng-star-inserted']")).click();
		driver.findElement(By.xpath("//span[text()=' Joint Visa Application Centre for Sweden Operations, New Delhi ']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c85-8 ng-star-inserted']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Visiting Family or Friends']")).click();
		
		Thread.sleep(3000);
		WebElement slotNotAvailable = driver.findElement(By.xpath("//div[text()=' No appointment slots are currently available. Please try another application centre if applicable ']"));
		Assert.assertEquals(true, slotNotAvailable.isDisplayed());	
		
		driver.quit();
//		test workflow run
	
	}

}



