import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

    public static final String EXPECTED_TITLE_CONTENT = "Bienvenido a OSTH On-Line";

    @FindBy(xpath = "//h3[contains(text(), 'Bienvenido a OSTH On-Line')]")
    private WebElement title;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return title.getText();
    }

    public WebElement getTitleElement() { return title; }

}
