package org.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    // Initialize the driver
    private final WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By DropDownToggle = By.xpath("//span[@class=\"caret\"]");
    private final By RegisterOption = By.xpath("//a[@href='https://awesomeqa.com/ui/index.php?route=account/register']");
        private final By FirstNameField = By.cssSelector("input[id*='input-firstname']");
    private final By LastNameField = By.cssSelector("input[name*='lastname']");
    private final By EmailTextField = By.cssSelector("input[id*='email']");
    private final By TelephoneTextField = By.cssSelector("input[id*='input-telephone']");
    private final By PasswordField = By.cssSelector("input[name*='password']");
    private final By ConfirmPasswordField = By.cssSelector("input[id*='input-confirm']");
    private final By YesOption = By.cssSelector("input[name*='newsletter'][value='1']");
    private final By PrivacyCheck = By.cssSelector("input[name*='agree'][value='1']");
    private final By ContinueButton = By.cssSelector("input[value*='Continue']");



    // Actions

    // Method to Navigate to URL
    @Step("user navigate to registration page")
    public RegisterPage urlNavigate() {
        String pageURL = "https://awesomeqa.com/ui/index.php?route=common/home";
        driver.navigate().to(pageURL);
        driver.manage().window().maximize();
        return this;
    }

    @Step("user navigate to registration page and sign up")
    public RegisterPage ListBehaviour() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(DropDownToggle)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(RegisterOption)).click();
         return this;
    }
    @Step("user fills data")
    public RegisterPage RegistrationForm(String FirstName, String LastName, String Email, String Telephone, String Password, String ConfirmPassword) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(FirstNameField)).sendKeys(FirstName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LastNameField)).sendKeys(LastName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(EmailTextField)).sendKeys(Email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(TelephoneTextField)).sendKeys(Telephone);
        wait.until(ExpectedConditions.visibilityOfElementLocated(PasswordField)).sendKeys(Password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ConfirmPasswordField)).sendKeys(ConfirmPassword);


        return this;
    }

    @Step("user recognizes data")
    public RegisterPage MarkChoices() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(YesOption)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(PrivacyCheck)).click();
        return this;
    }

    public void  ClickContinue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ContinueButton)).click();

    }
}
