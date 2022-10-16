import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.Assert.*;

import java.time.Duration;

public class TestPlan {

    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void setPropertyForDriver() {
        System.setProperty("webdriver.chrome.driver", Locations.CHROME_DRIVER_LOCATION);
    }

    @BeforeMethod
    public static void getBaseUrl() {
        driver.get(Locations.BASE_URL);
    }

    @Test(testName = "Login empty username, empty password")
    public static void loginNoUsernameNorPasswordShouldShowErrorMessage() {
        LoginForm loginForm = new LoginForm(driver);
        loginForm.enterUsername("");
        loginForm.enterPassword("");
        loginForm.pressLoginButton();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        assertEquals(loginForm.getStateMessage(), "Atención: Debe ingresar un nombre de usuario");
    }

    @Test(testName = "Login valid username, empty password")
    public static void loginUsernameWithoutPasswordShouldShowErrorMessage() {
        LoginForm loginForm = new LoginForm(driver);
        loginForm.enterUsername();
        loginForm.enterPassword("");
        loginForm.pressLoginButton();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        assertEquals(loginForm.getStateMessage(), "Atención: El password no puede estar vacío");
    }

    @Test(testName = "Login valid username, valid password")
    public static void loginSuccessfully() {
        LoginForm loginForm = new LoginForm(driver);
        loginForm.enterUsername();
        loginForm.enterPassword();
        loginForm.pressLoginButton();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        HomePage homePage = new HomePage(driver);
        assertEquals(homePage.getTitle(), "Bienvenido a OSTH On-Line");
    }

    @Test(testName = "Login valid username, invalid password")
    public static void loginValidUsernameInvalidPasswordShouldShowErrorMessage() {
        LoginForm loginForm = new LoginForm(driver);
        loginForm.enterUsername();
        loginForm.enterPassword("ppettigrew");
        loginForm.pressLoginButton();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        assertEquals(loginForm.getStateMessage(), "Atención: El password ingresado no es válido");
    }

    @AfterSuite
    public static void cleanUp() {
        driver.manage().deleteAllCookies();
    }
}
