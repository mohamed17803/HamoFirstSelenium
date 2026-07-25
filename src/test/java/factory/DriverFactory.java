package factory;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final int MAX_ATTEMPTS = 2;

    private DriverFactory() {
    }

    public static void init(String browser) {
        if (browser == null) {
            throw new IllegalArgumentException("Browser parameter cannot be null");
        }

        WebDriver webDriver = null;
        SessionNotCreatedException lastError = null;

        for (int attempt = 1; attempt <= MAX_ATTEMPTS && webDriver == null; attempt++) {
            try {
                switch (browser.trim().toLowerCase()) {
                    case "chrome":
                        webDriver = new ChromeDriver((ChromeOptions) BrowserOptionsFactory.getOptions(browser));
                        break;
                    case "edge":
                        webDriver = new EdgeDriver((EdgeOptions) BrowserOptionsFactory.getOptions(browser));
                        break;
                    case "firefox":
                        webDriver = new FirefoxDriver((FirefoxOptions) BrowserOptionsFactory.getOptions(browser));
                        break;
                    default:
                        throw new IllegalArgumentException("Unsupported browser: " + browser);
                }
            } catch (SessionNotCreatedException e) {
                lastError = e;
            }
        }

        if (webDriver == null) {
            throw lastError;
        }

        driver.set(webDriver);
    }

    public static WebDriver get() {
        return driver.get();
    }

    public static void quit() {
        WebDriver webDriver = driver.get();
        if (webDriver != null) {
            webDriver.quit();
            driver.remove();
        }
    }
}