import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends PageObject {

    private final String USERNAME = "dumbridge";
    private final String PASSWORD = "tomriddle";

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = "button")
    private WebElement loginButton;

    @FindBy(xpath = "//span[id('estado')]")
    private WebElement stateMessage;

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    public void enterUsername() {
        username.sendKeys(USERNAME);
    }

    public void enterUsername(String username) {
        this.username.sendKeys(username);
    }

    public void enterPassword() {
        password.sendKeys(PASSWORD);
    }

    public void enterPassword(String password) {
        this.password.sendKeys(password);
    }

    public void pressLoginButton() {
        loginButton.click();
    }

    public String getStateMessageText() {
        return stateMessage.getText();
    }

    public WebElement getStateMessageElement() {
        return stateMessage;
    }

}
