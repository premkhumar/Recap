package org.pages;

import org.base.LibGlobal;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Slider extends LibGlobal{
	
	private static void slide() {

		WebElement slide = driver.findElement(By.xpath("//input[@class='range-slider range-slider--primary']"));
		JavascriptExecutor js  =(JavascriptExecutor) driver; 
		js.executeScript("arguments[0].setAttribute(arguments[1],arguments[2])",slide,"value",60);
		Actions ac = new Actions(driver);
//		ac.click(slide).perform();
//		slide.sendKeys(Keys.ARROW_LEFT);
		int width = slide.getSize().getWidth();
		ac.dragAndDropBy(slide,-350,250).perform();
		
		driver.navigate().to("https://jqueryui.com/slider/");
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		WebElement slider = driver.findElement(By.xpath("//span[starts-with(@class,'ui-slider-handle ui-corner-all')]"));
//		ac.dragAndDropBy(slider, 250, 300).perform();
//		ac.release(slider).perform();
		ac.clickAndHold(slider).perform();
		ac.moveByOffset(300, 150).perform();
		
	}

	public static void main(String[] args) {
		browserLaunchChrome();
		maxWindows();
		enterUrl("https://demoqa.com/slider");
		slide();
	}
}
