package com.sloovitask1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonHelper {
	
	public static WebDriver driver ;
	
	public void launch () {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://stage.outreach.sloovi.com/login");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public void screenshot (String nameWithFormat) throws IOException {
		
		TakesScreenshot ssOfPage1 = (TakesScreenshot)driver;
		File pathObj1 = new File ("C:\\Users\\Bala karthi\\eclipse-workspace\\SlooviTask\\Screenshot" + nameWithFormat);	
		File formtObj1 = ssOfPage1.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(formtObj1, pathObj1);
		
	}
	
	public void refresh() throws AWTException {
		
		Robot robotObj1 = new Robot();
		robotObj1.keyPress(KeyEvent.VK_F5);
	}
	
	public void close() {
		driver.close();
	}
	
	public void relaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://stage.outreach.sloovi.com/login");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public void actionClass(WebElement webelement) {
		
		Actions actObj = new Actions(driver);
		actObj.moveToElement(webelement).perform();
	}
}
