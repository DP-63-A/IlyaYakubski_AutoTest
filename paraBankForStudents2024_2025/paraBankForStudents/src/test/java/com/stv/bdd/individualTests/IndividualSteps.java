package com.stv.bdd.individualTests;

import com.stv.bdd.tests.Factory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class IndividualSteps {
    WebDriver driver = Factory.getDriver();

    @Given("I am on the Login page")
    public void iAmOnTheLoginPage() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @Then("I should see the Envelope button")
    public void iShouldSeeTheEnvelopeButton() {
        WebElement envelopeButton = driver.findElement(By.xpath("//li[@class='contact']/a"));
        Assert.assertTrue(envelopeButton.isDisplayed());
    }

    @And("I click the Envelope button")
    public void iClickTheEnvelopeButton() {
        WebElement envelopeButton = driver.findElement(By.xpath("//li[@class='contact']/a"));
        envelopeButton.click();
    }

    @Then("I should see the SEND TO CUSTOMER CARE button")
    public void iShouldSeeTheSendToCustomerCareButton() {
        WebElement careButton = driver.findElement(By.xpath("//input[@type='submit' and @value='Send to Customer Care']"));
        Assert.assertTrue(careButton.isDisplayed());
    }

    @And("I click the SEND TO CUSTOMER CARE button")
    public void iClickTheSendToCustomerCareButton() {
        WebElement careButton = driver.findElement(By.xpath("//input[@type='submit' and @value='Send to Customer Care']"));
        careButton.click();
    }

    @Then("I should see four error messages")
    public void iShouldSeeFourErrorMessages() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name.errors")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email.errors")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone.errors")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message.errors")));

        Assert.assertTrue(driver.findElement(By.id("name.errors")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("email.errors")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("phone.errors")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("message.errors")).isDisplayed());
    }

    @Then("I click the Envelope button again")
    public void iClickTheEnvelopeButtonAgain() {
        WebElement envelopeButton = driver.findElement(By.xpath("//li[@class='contact']/a"));
        envelopeButton.click();
    }

    @And("I should see no error messages")
    public void iShouldSeeNoErrorMessages() {
        List<WebElement> noErrorMessages = driver.findElements(By.xpath("//p[contains(@class, 'error')]"));
        Assert.assertEquals("Expected 0 error messages, but found " + noErrorMessages.size(), 0, noErrorMessages.size());
    }

    @Then("I click on the site logo")
    public void iClickOnTheSiteLogo() {
        WebElement logo = driver.findElement(By.className("logo"));
        logo.click();
    }

    @Then("I should be redirected to the home page")
    public void iShouldBeRedirectedToTheHomePage() {
        String expectedUrl = "https://parabank.parasoft.com/parabank/index.htm";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("Did not navigate to home page!", expectedUrl, actualUrl);
    }

}
