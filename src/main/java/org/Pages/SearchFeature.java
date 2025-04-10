package org.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class SearchFeature {
    // Initialize the driver

    private final WebDriver driver;
    public SearchFeature(WebDriver driver) {
        this.driver = driver;
    }
    // Method to Navigate to URL
    @Step("user navigate to Home page")
    public SearchFeature UrlNavigate() {
        String pageURL = "https://awesomeqa.com/ui/index.php?route=common/home";
        driver.navigate().to(pageURL);
        driver.manage().window().maximize();
        return this;
    }




}
