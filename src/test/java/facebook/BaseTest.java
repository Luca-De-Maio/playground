package facebook;

import facebook.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BaseTest {

    public LoginPage openLoginPage(WebDriver driver) {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals(loginPage.getTitle(),
                "Facebook helps you connect and share with the people in your life.", "cannot find title");
        return loginPage;
    }
}
