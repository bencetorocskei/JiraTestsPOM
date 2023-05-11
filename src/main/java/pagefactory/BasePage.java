package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagefactory.DriverManager;

import java.net.MalformedURLException;
import java.time.Duration;

public class BasePage {

    WebDriverWait wait;
    WebDriver driver;
    String remoteDriverType = System.getProperty("browserType");

    public BasePage() {
        if (remoteDriverType == null){
            remoteDriverType = "chrome";
        }
        this.driver = DriverManager.createWebDriver(remoteDriverType);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    public void quit () {
        DriverManager.shutDown();
    }
}


