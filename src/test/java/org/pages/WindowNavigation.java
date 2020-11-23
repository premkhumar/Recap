package org.pages;

import java.util.Iterator;
import java.util.Set;

import org.apache.poi.util.SystemOutLogger;
import org.base.LibGlobal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WindowNavigation extends LibGlobal{
	
	
	private void testcases() throws InterruptedException {
		
		driver.navigate().to("http://demo.automationtesting.in/Windows.html");
		String parent = driver.getWindowHandle();
		
		
		WebElement btnClick = driver.findElement(By.xpath("(//*[@class='btn btn-info'])[1]"));
		btnClick.click();
		Thread.sleep(5000);
//		driver.switchTo().window(parent);
		Thread.sleep(5000);
		btnClick.click();
		
		Set<String> wHandlesList = driver.getWindowHandles();
		System.out.println(wHandlesList);
		Iterator<String> it = wHandlesList.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		String childWindow1 = it.next();

		String title = driver.getTitle();
		System.out.println(title);
		Thread.sleep(5000);
		driver.switchTo().window(childWindow);
		System.out.println(driver.getTitle());
		System.out.println(driver.getWindowHandle());
		Thread.sleep(5000);
		driver.switchTo().window(childWindow1);
		System.out.println(driver.getWindowHandle());
		Thread.sleep(5000);
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getWindowHandle());
		
		
		
		WebElement openWindow = driver.findElement(By.xpath("//*[text()='Open New Seperate Windows']"));
		WebElement btnClick1 = driver.findElement(By.xpath("//*[@class='btn btn-primary']"));
		
		openWindow.click();
		btnClick1.click();
		
		Set<String> win = driver.getWindowHandles();
		System.out.println(win);
		
		Iterator<String> ite = win.iterator();
		String ne = ite.next();
		System.out.println(ne);
		
		for (String s : win) {
			if (!(s==parentWindow) ) {
				Thread.sleep(3000);
				driver.switchTo().window(s);
				System.out.println(driver.getWindowHandle());
			}
		}
		System.out.println(driver.getWindowHandle());
	}
	
	
	
}
