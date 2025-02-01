package com.stv.bdd.factorypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class CustomerCarePage {
    private WebDriver driver;

    @FindBy(xpath = "//li[@class='contact']/a")
    private WebElement envelopeButton;

    @FindBy(xpath = "//input[@type='submit' and @value='Send to Customer Care']")
    private WebElement sendToCustomerCareButton;

    @FindBy(id = "name.errors")
    private WebElement nameError;

    @FindBy(id = "email.errors")
    private WebElement emailError;

    @FindBy(id = "phone.errors")
    private WebElement phoneError;

    @FindBy(id = "message.errors")
    private WebElement messageError;

    public int getNumberOfErrorMessages() {
        List<WebElement> errors = driver.findElements(By.cssSelector("span.error"));
        return errors.size();
    }

    @FindBy(className = "logo")
    private WebElement siteLogo;

    public CustomerCarePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isEnvelopeButtonDisplayed() {
        return envelopeButton.isDisplayed();
    }

    public void clickEnvelopeButton() {
        envelopeButton.click();
    }

    public boolean isSendToCustomerCareButtonDisplayed() {
        return sendToCustomerCareButton.isDisplayed();
    }

    public void clickSendToCustomerCareButton() {
        sendToCustomerCareButton.click();
    }

    public boolean isNameErrorDisplayed() {
        return nameError.isDisplayed();
    }

    public boolean isEmailErrorDisplayed() {
        return emailError.isDisplayed();
    }

    public boolean isPhoneErrorDisplayed() {
        return phoneError.isDisplayed();
    }

    public boolean isMessageErrorDisplayed() {
        return messageError.isDisplayed();
    }

    public void clickSiteLogo() {
        siteLogo.click();
    }
}