package testsPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LocatorsTest

{

    @Test
public void testLocator()  {
    WebDriver driver = new ChromeDriver();
        String pageURL = "https://awesomeqa.com/ui/index.php?route=common/home";
        driver.navigate().to(pageURL);
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("a[href=\"https://awesomeqa.com/ui/index.php?route=checkout/cart\"] span[class=\"hidden-xs hidden-sm hidden-md\"]")).click();

        driver.findElement(By.linkText("product 11"));
        driver.quit();
    }

}
