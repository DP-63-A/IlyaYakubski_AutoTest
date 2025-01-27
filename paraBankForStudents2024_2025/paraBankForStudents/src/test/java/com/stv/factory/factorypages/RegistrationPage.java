package com.stv.factory.factorypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage extends InitPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "customer.firstName")
    private WebElement firstNameField;

    @FindBy(id = "customer.lastName")
    private WebElement lastNameField;

    @FindBy(id = "customer.address.street")
    private WebElement addressField;

    @FindBy(id = "customer.address.city")
    private WebElement cityField;

    @FindBy(id = "customer.address.state")
    private WebElement stateField;

    @FindBy(id = "customer.address.zipCode")
    private WebElement zipCodeField;

    @FindBy(id = "customer.phoneNumber")
    private WebElement phoneNumberField;

    @FindBy(id = "customer.ssn")
    private WebElement ssnField;

    @FindBy(id = "customer.username")
    private WebElement usernameField;

    @FindBy(id = "customer.password")
    private WebElement passwordField;

    @FindBy(id = "repeatedPassword")
    private WebElement confirmPasswordField;

    @FindBy(css = "input[value='Register']")
    private WebElement registerButton;

    @FindBy(css = ".error")
    private WebElement errorMessage;

    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
        this.driver = webDriver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public RegistrationPage enterFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOf(firstNameField)).sendKeys(firstName);
        return this;
    }

    public RegistrationPage enterLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOf(lastNameField)).sendKeys(lastName);
        return this;
    }

    public RegistrationPage enterAddress(String address) {
        wait.until(ExpectedConditions.visibilityOf(addressField)).sendKeys(address);
        return this;
    }

    public RegistrationPage enterCity(String city) {
        wait.until(ExpectedConditions.visibilityOf(cityField)).sendKeys(city);
        return this;
    }

    public RegistrationPage enterState(String state) {
        wait.until(ExpectedConditions.visibilityOf(stateField)).sendKeys(state);
        return this;
    }

    public RegistrationPage enterZipCode(String zipCode) {
        wait.until(ExpectedConditions.visibilityOf(zipCodeField)).sendKeys(zipCode);
        return this;
    }

    public RegistrationPage enterPhoneNumber(String phoneNumber) {
        wait.until(ExpectedConditions.visibilityOf(phoneNumberField)).sendKeys(phoneNumber);
        return this;
    }

    public RegistrationPage enterSSN(String ssn) {
        wait.until(ExpectedConditions.visibilityOf(ssnField)).sendKeys(ssn);
        return this;
    }

    public RegistrationPage enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
        return this;
    }

    public RegistrationPage enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
        return this;
    }

    public RegistrationPage enterConfirmPassword(String confirmPassword) {
        wait.until(ExpectedConditions.visibilityOf(confirmPasswordField)).sendKeys(confirmPassword);
        return this;
    }

    public HomePage clickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
        return new HomePage(driver);
    }
}