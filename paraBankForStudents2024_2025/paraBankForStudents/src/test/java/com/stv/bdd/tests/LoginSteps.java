package com.stv.bdd.tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSteps {

    WebDriver driver = Factory.getDriver();

    @Given("I am on the Login page")
    public void iAmOnTheLoginPage() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Then("I should see the LOG IN button")
    public void iShouldSeeTheLoginButton() {
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        Assert.assertTrue(loginButton.isDisplayed());
    }

    @When("I enter {string} and {string}")
    public void iEnterCredentials(String username, String password) {
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        usernameField.clear();
        passwordField.clear();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    @When("I click the LOG IN button")
    public void iClickTheLoginButton() {
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();
    }

    @Then("I should see {string}")
    public void iShouldSeeMessage(String expectedMessage) {
        WebElement messageElement = driver.findElement(By.xpath("//p[contains(@class, 'error')]"));
        String actualMessage = messageElement.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("I log out")
    public void iLogOut() {
        try {
            WebElement errorMessage = driver.findElement(By.xpath("//p[contains(@class, 'error')]"));
            if (errorMessage.isDisplayed()) {
                System.out.println("Login failed, no need to log out.");
                return;
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }

        try {
            WebElement logoutButton = driver.findElement(By.xpath("//a[text()='Log Out']"));
            if (logoutButton.isDisplayed()) {
                logoutButton.click();
                System.out.println("Logged out successfully.");
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Logout button not found, possibly not logged in.");
        }
    }
}