package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LogInPage extends BasePage {


    @FindBy(id = "login-form-username")
    WebElement username;
    @FindBy(id = "login-form-password")
    WebElement password;
    @FindBy(id = "login")
    WebElement dashboardLoginBtn;
    @FindBy(id = "login-form-submit")
    WebElement loginBtn;
    @FindBy(xpath = "//div[@class='aui-message aui-message-error']")
    WebElement usernameError;


    public void setUsername(String name) {
        username.sendKeys(name);
    }

    public void setPassword(String pwd) {
        password.sendKeys(pwd);
    }

    public void clickOnDashboardLoginBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(dashboardLoginBtn));
        dashboardLoginBtn.click();
    }

    public void clickOnLoginBtn() {
        loginBtn.click();
    }

    public String getURL() {
        return driver.getCurrentUrl();
    }

    public Boolean usernameErrorIsPresent() {
        wait.until(ExpectedConditions.visibilityOf(usernameError));
        return usernameError.isDisplayed();
    }

    public void loggingIn(String user, String pwd) {
        setUsername(user);
        setPassword(pwd);
        clickOnLoginBtn();
    }

    public void loggingInInDashboard(String user, String pwd) {
        setUsername(user);
        setPassword(pwd);
        clickOnDashboardLoginBtn();
    }

    public void navigateToLoginPage() {

        driver.get("https://jira-auto.codecool.metastage.net/login.jsp");
    }

    public void navigateToDashboardLoginPage() {
        driver.get("https://jira-auto.codecool.metastage.net/secure/Dashboard.jspa");
    }

    public void navigate(String url) {
        driver.get(url);
    }

}
