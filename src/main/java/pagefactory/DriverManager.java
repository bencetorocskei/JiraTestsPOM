package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverManager {
    private static WebDriver webDriver = null;

    public static WebDriver createWebDriver(String browserType) {
        if (webDriver == null) {
            switch (browserType) {
                case "firefox":
                    webDriver = new FirefoxDriver();
                    break;
                case "chrome":
                default:
                    webDriver = new ChromeDriver();
                    break;
            }
        }
        return webDriver;
    }

    public static void shutDown() {
        webDriver.quit();
        webDriver = null;
    }
}
