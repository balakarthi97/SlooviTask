package com.sloovitask1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SlooviTask extends CommonHelper {
	
	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		
		CommonHelper chobj = new CommonHelper();
		chobj.launch();
		
//Scenario: TS_001 
//Test case: TC_001_01 |Validate system behavior when invalid email id and valid password is entered.|
		driver.findElement(By.xpath("//input [@name = 'email']")).sendKeys("smithwills1989xx123@gmail.com" , Keys.TAB , "12345678" , Keys.ENTER);
		WebElement alertMsg1 = driver.findElement(By.xpath("//div [contains (@class , 'Message-danger alert ')]")); String
		message1 = alertMsg1.getText(); System.out.println(message1);
		chobj.screenshot("\\Loginpage1.png"); 
		chobj.close();
				 
				
//Scenario: TS_001
//Test case: TC_001_02 |Validate system behavior when valid email id and invalid password is entered.|
		chobj.relaunch();
		driver.findElement(By.xpath("//input [@name = 'email']")).sendKeys("smithwills1989@gmail.com" , Keys.TAB , "12345678000" , Keys.ENTER);
		WebElement alertMsg2 = driver.findElement(By.xpath("//div [contains (@class , 'Message-danger alert ')]"));
		String message2 = alertMsg2.getText();
		System.out.println(message2);
		chobj.screenshot("\\Loginpage2.png");
		chobj.close();
				
//Scenario: TS_001
//Test case: TC_001_03 |Validate system behavior when invalid email id format and valid password are entered.|
		chobj.relaunch();
		driver.findElement(By.xpath("//input [@name = 'email']")).sendKeys("smithwills1989xx123" , Keys.TAB , "12345678" , Keys.ENTER);
		chobj.screenshot("\\Loginpage3.png");
		chobj.close();
				
//Scenario: TS_001
//Test case: TC_001_04 |Validate system behavior when email id and password are not entered and click login.|
		chobj.relaunch();
		driver.findElement(By.xpath("//button[@class = 'btn btn-primary']")).sendKeys( Keys.ENTER);
		chobj.screenshot("\\Loginpage4.png");
		chobj.close();
		
		
//Scenario: TS_001
//Test case: TC_001_05 |Validate system behavior when invalid email id and valid password is entered.|
		chobj.relaunch();
		driver.findElement(By.xpath("//input [@name = 'email']")).sendKeys("smithwills1989@gmail.com" , Keys.TAB , "12345678" , Keys.ENTER);
		Thread.sleep(1000);
		chobj.screenshot("\\Loginpage5.png");
		
//Scenario: TS_002
//Test case: TS_002_01 
		
		driver.findElement(By.xpath("(//span [@class = 'Menu_itemText'])[6]")).click();
		WebElement slooviLeads = driver.findElement(By.xpath("//td [@title= 'Sloovi']"));
		chobj.actionClass(slooviLeads);
		slooviLeads.click();
		
//LeadModule
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button [@data-testid = 'add-task']")).click();
		
		WebElement textObj = driver.findElement(By.xpath("//input [@id = 'undefined_task_msg']"));
		textObj.click();
		Thread.sleep(3000);
		Actions actionObj = new Actions (driver);
		actionObj.doubleClick(textObj).perform();
		textObj.sendKeys("Task Demo");
		
		WebElement dateObj = driver.findElement(By.xpath("//input [@name = 'task_date']"));
		Actions actionObj2 = new Actions (driver);
		actionObj2.contextClick(dateObj).perform();
		
		Robot robObj = new Robot ();
		
		for(int i=1; i<=8; i++) {
		
		robObj.keyPress(KeyEvent.VK_DOWN);
		robObj.keyRelease(KeyEvent.VK_DOWN); }
		
		robObj.keyPress(KeyEvent.VK_ENTER);
		robObj.keyRelease(KeyEvent.VK_ENTER);
		
		dateObj.sendKeys("07/20/2022");
		
		driver.findElement(By.xpath("//input [@name = 'task_time']")).click();
		driver.findElement(By.xpath("//div [@data-placement = 'bottom-start']//li")).click();
		driver.findElement(By.xpath("//button[@type= 'submit']")).click();
		chobj.screenshot("\\LeadModule.png");

//Scenario: TS_003
//Test case: TS_003_01 	
//OptionsModule
		
		driver.findElement(By.xpath("//button [@data-testid = 'add-undefined']")).click();
		
		WebElement dateObj3 = driver.findElement(By.xpath("(//div [@class = 'InputField__fieldContainer'])[5]"));
		Actions actObj23= new Actions(driver);
		actObj23.moveToElement(dateObj3);

		WebElement dateObj2 = driver.findElement(By.xpath("(//input [@type = 'text'])[4]"));
		dateObj2.sendKeys("22/07/2022");
		
		WebElement sliderObj = driver.findElement(By.xpath("//input [@type = 'range']"));
		Actions actObj2 = new Actions(driver);
		actObj2.dragAndDropBy(sliderObj, 20, 0).perform();
		WebElement valueObj = driver.findElement(By.xpath("//input [@type = 'number']"));
		Actions actionObj3 = new Actions (driver);
		actionObj3.doubleClick(valueObj).perform();
		valueObj.sendKeys("100");
		driver.findElement(By.xpath("(//input [@type = 'search'])[2]"));
		driver.findElement(By.xpath("(//div [@class = 'Select__inputWrapper'])[3]")).click();
		driver.findElement(By.xpath("(//div [@data-popper-arrow = 'true']/parent :: div//ul//li)[2]")).click();
		
		WebElement contObj = driver.findElement(By.xpath("(//div [@class = 'Select__inputWrapper'])[3]"));
		contObj.click();
		driver.findElement(By.xpath("//ul [@class = 'Select__list']/li")).click();
		
		driver.findElement(By.xpath("//textarea [@name= 'msg']")).sendKeys("Task Completed");
		driver.findElement(By.xpath("(//button[@type= 'submit'])[1]")).click();
		chobj.screenshot("\\OptionsModule.png");
	}
}
