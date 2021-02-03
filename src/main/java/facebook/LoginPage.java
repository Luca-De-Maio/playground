package facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@id='pass']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@name='login']")
    private WebElement loginButton;

    @FindBy(className = "_8eso")
    private WebElement title;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.driver.get("https://web.facebook.com/?_rdc=1&_rdr");
    }

    public void login(String login, String password) {
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.submit();
    }

    public String getTitle() {
        return title.getText();
    }

    public boolean wasLogInFailed() {
        return driver.findElement(new By.ByClassName("_9ay5")).isDisplayed();
    }
}
