package testsPackage;

import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.Pages.AddToCart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
@Listeners({AllureTestNg.class})

@Epic("Shopping Cart Operations")
@Story("Add items to the shopping cart and verify correct product details and quantities")
@Severity(SeverityLevel.CRITICAL)


public class AddtoCartTest {
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

    @Test(description = "Validate if the user can add a product he choose to the cart")
    @Step("Check Using Iphone")
     public void  AddingProductFeature(){

        AddToCart addToCart = new AddToCart(driver);
    addToCart.UrlNavigate().ViewProduct().ClickAddToCart().CheckMsg().ShoppingCartView();

    }
    @AfterMethod
    @Description("Close the browser after the Test")
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
