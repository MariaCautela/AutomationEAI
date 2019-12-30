package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(how = How.XPATH, using = "//*[@name='signup_email']")
    private WebElement emailInput;

    @FindBy(how = How.XPATH, using = "//button[contains(., 'Next ')]")
    private WebElement nextBtn;

    @FindBy(how = How.XPATH, using = "//*[@name='firstlastname']")
    private WebElement nameInput;

    @FindBy(how = How.XPATH, using = "//input[@placeholder='Mobile Number']")
    private WebElement phoneInput;

    @FindBy(how = How.XPATH, using = "//*[@name='signup_password']")
    private WebElement passwdInput;

    @FindBy(how = How.XPATH, using = "//button[@class='submitButton']")
    private WebElement registerSubmit;


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    //The user inserts his e-mail
    public void signUp(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailInput)).sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn)).click();
    }

    public void registerForm(String name, String phone, String passwd) {
        wait.until(ExpectedConditions.elementToBeClickable(nameInput)).sendKeys(name);
        wait.until(ExpectedConditions.elementToBeClickable(phoneInput)).sendKeys(phone);
        wait.until(ExpectedConditions.elementToBeClickable(passwdInput)).sendKeys(passwd);
        wait.until(ExpectedConditions.elementToBeClickable(registerSubmit)).click();
    }
}


