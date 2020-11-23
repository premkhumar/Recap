package org.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.base.LibGlobal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class HomePage extends LibGlobal{
	
	@Test
	private void browserLaunch() throws InterruptedException {

		browserLaunchChrome();
		maxWindows();
		enterUrl("https://cricket.yahoo.net/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement lnkIndVsAus = driver.findElement(By.xpath("//a[@title='AUS vs IND']"));
		click(lnkIndVsAus);
		
		WebElement squad = driver.findElement(By.xpath("//*[text()='Squad']"));
		squad.click();
		
		
		List<WebElement> txtInd = driver.findElements(By.xpath("//div[starts-with(@class,'swiper-slide si-dt-slide swiper-slide-next')]"));
		for (int i = 0; i < txtInd.size(); i++) {
			WebElement c = txtInd.get(i);
			c.click();
		}
		
		
		
		List<WebElement> batsman = driver.findElements(By.xpath("(//*[@class='si-content-row'])[1]"));
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("(//*[@class='si-firstNm'])[1]"), "Manish"));
		ArrayList<String> batsmanList = new ArrayList<String>();
		for (int i = 0; i < batsman.size(); i++) {
			
			WebElement wi = batsman.get(i);
			String bats = wi.getText();
			batsmanList.add(bats);
			
		}
		
		for (String x : batsmanList) {
			System.out.println(x);
		}
		ArrayList<String> bowlerList = new ArrayList<String>();
		List<WebElement> bowlers = driver.findElements(By.xpath("(//*[@class='si-content-row'])[3]"));
		for (int i = 0; i < bowlers.size(); i++) {
			WebElement bowl = bowlers.get(i);
			String bow = bowl.getText();
			bowlerList.add(bow);
			
		}
		System.out.println("\n\n");
		for (String y  : bowlerList) {
			System.out.println(y);
		}
		
		ArrayList<String> allRounder = new ArrayList<String>();
		List<WebElement> allround = driver.findElements(By.xpath("(//*[@class='si-content-row'])[4]"));
		for (int i = 0; i < allround.size(); i++) {
			WebElement all = allround.get(i);
			String allRounders = all.getText();
			allRounder.add(allRounders);
			
		}
		System.out.println("\n\n");
		for (String t  : allRounder) {
			System.out.println(t);
		}
		ArrayList<String> wicketKeeper = new ArrayList<String>();
		List<WebElement> keeper = driver.findElements(By.xpath("(//*[@class='si-content-row'])[2]"));
		for (int i = 0; i < keeper.size(); i++) {
			WebElement all = keeper.get(i);
			String wKeeper = all.getText();
			wicketKeeper.add(wKeeper);
			
		}
		System.out.println("\n\n");
		for (String a  : wicketKeeper) {
			System.out.println(a);
		}
		
		
		
		
		}
	
	
	

}
