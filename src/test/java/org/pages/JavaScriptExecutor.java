package org.pages;

import org.base.LibGlobal;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class JavaScriptExecutor extends LibGlobal{
	public static WebElement element;
	@Test
	private void testCases() {

		driver.navigate().to("http://demo.automationtesting.in/Windows.html");
		WebElement openMultiple = driver.findElement(By.xpath("//*[text()='Open Seperate Multiple Windows']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", openMultiple);
		
		WebElement btnclik = driver.findElement(By.xpath("//button[@onclick='multiwindow()']"));
		javaScriptClick(btnclik);
		
		driver.navigate().to("https://letskodeit.teachable.com/p/practice");
		WebElement multiSelect = driver.findElement(By.id("multiple-select-example"));
		Select s = new Select(multiSelect);
		s.selectByValue("orange");
		s.selectByValue("peach");
		
		driver.navigate().to("https://www.makemytrip.com/");
		WebElement fromCity = driver.findElement(By.xpath("//label[@for='fromCity']"));
		click(fromCity);
		WebElement frmcity = driver.findElement(By.xpath("//input[@placeholder='From']"));
		frmcity.sendKeys("chennai");
		frmcity.sendKeys(Keys.DOWN);
		frmcity.sendKeys(Keys.ENTER);
		WebElement toCity = driver.findElement(By.xpath("//label[@for='toCity']"));
		toCity.click();
		
	}

}
