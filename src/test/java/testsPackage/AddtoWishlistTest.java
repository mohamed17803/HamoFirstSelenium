package testsPackage;

import data.RegisterData;

import io.qameta.allure.*;
import org.Pages.WishlistFeature;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.JsonUtils;

import java.time.Duration;


@Epic("Wishlist Management")
@Story("Add and remove items from wishlist and validate their persistence")
@Severity(SeverityLevel.NORMAL)


public class AddtoWishlistTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--proxy-server=direct://");
        options.addArguments("--proxy-bypass-list=*");
        options.addArguments("--disable-extensions");
        options.addArguments("--ignore-certificate-errors");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts()
              .pageLoadTimeout(Duration.ofSeconds(60));
    }

    @Test(description = "Add items to wishlist ")
    public void AddToWishlistFeature() throws InterruptedException {
        String registerPath = "src/test/resources/testDatafiles/registerData.json";
        RegisterData registerData = JsonUtils.readJsonFile(registerPath, RegisterData.class);




        Assert.assertNotNull(registerData, "RegisterData is null");


        WishlistFeature wishlistFeature = new WishlistFeature(driver);
        wishlistFeature
                .UrlNavigate()
                .LoginNavigate()
                .LoginForm(registerData.getEmail(), registerData.getPassword())
                .ClickLogin();wishlistFeature.HomeNavigate()
                .AddtoWishlists().GoWishlist().CheckAddedItems();
    }

    @AfterMethod
    @Description("Close the browser after the Test")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Done and quit");
        }
    }
}
