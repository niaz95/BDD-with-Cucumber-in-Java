package com.accesshq.warsword.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public HomePage clickJapaneseSwordsLink() {
		driver.findElement(By.linkText("Japanese/Samurai Swords")).click();
		return this;
	}
	
	public String getPageTitle() {
		return driver.findElement(By.cssSelector("h1.section-header__title")).getText();
	}
	
	public HomePage closeSubscribeModal() {
		WebElement closeModalElement = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mc-closeModal")));
		closeModalElement.click();
		return this;

	}

	public void clickProductSidebarLink(String string) {
		driver.findElement(By.linkText(string)).click();
		}
}
