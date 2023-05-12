import org.junit.jupiter.api.*;
import pagefactory.*;



public class LogInPageTest {

    private LogInPage logInPage;
    static final String VALID_USERNAME = "automation40";
    static final String VALID_PASSWORD = "CCAutoTest19.";
    final String INVALID_USERNAME = "invalid-username";
    final String INVALID_PASSWORD = "invalid-password";

    @BeforeEach
    public void init() {
        logInPage = new LogInPage();
        logInPage.navigateToLoginPage();

    }

    @Test
    public void validLogin() {
        DashboardPage dashboardPage = new DashboardPage();
        ProfilePage profilePage = new ProfilePage();
        logInPage.loggingIn(VALID_USERNAME, VALID_PASSWORD);
        dashboardPage.clickOnProfileBtn();
        dashboardPage.clickOnProfile();
        Assertions.assertEquals(VALID_USERNAME, profilePage.getUsername());
    }

    @Test
    public void invalidLoginWithInvalidUsername() {
        logInPage.loggingIn(INVALID_USERNAME, VALID_PASSWORD);
        Assertions.assertTrue(logInPage.usernameErrorIsPresent());
    }

    @Test
    public void invalidLoginWithInvalidPassword() {
        logInPage.loggingIn(VALID_USERNAME, INVALID_PASSWORD);
        Assertions.assertTrue(logInPage.usernameErrorIsPresent());
    }

    @AfterEach
    public void tearDown() {
        logInPage.quit();
    }
}
