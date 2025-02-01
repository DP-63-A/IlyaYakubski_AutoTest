package com.stv.bdd.factorypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//a[text()='Log Out']")
    private WebElement logOutButton;

    @FindBy(className = "logo")
    private WebElement siteLogo;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isLogOutButtonVisible() {
        try {
            return logOutButton.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickLogOut() {
        if (isLogOutButtonVisible()) {
            logOutButton.click();
        } else {
            System.out.println("Log Out button not found, skipping logout.");
        }
    }

    public void clickLogo() {
        siteLogo.click();
    }
}
