package base;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import pages.RegisterPage;
import pages.WelcomePage;

import java.util.concurrent.TimeUnit;

public class AutomationEAI {

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.navigate().to("https://staging.engineer.ai/welcome");

        WelcomePage welcome = new WelcomePage(driver);
        PageFactory.initElements(driver, welcome);
        welcome.takeATourAndSkip();

        HomePage home = new HomePage(driver);
        PageFactory.initElements(driver, home);
        home.closePopUp();
        home.selectCurrency("US Dollars");
        home.login();

        RegisterPage register = new RegisterPage(driver);
        PageFactory.initElements(driver, register);
        String email = RandomStringUtils.randomAlphabetic(15) + "@test.com";
        register.signUp(email);
        String name = RandomStringUtils.randomAlphabetic(10);
        String phone = "96" + RandomStringUtils.randomNumeric(7);
        String passwd = RandomStringUtils.randomAlphanumeric(8);
        register.registerForm(name, phone, passwd);
        home.validateSuccessfulRegistry(name);

        driver.close();
    }
}
