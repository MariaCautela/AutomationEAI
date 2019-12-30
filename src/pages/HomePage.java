package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(how = How.XPATH, using = "//*[@class='currencySelBox']")
    private WebElement currencyDropdown;

    @FindBy(how = How.XPATH, using = "//*[@class='popHolder intentPopup']//*[@class='closePopUp']//*[@class='icon-cancel']")
    private WebElement discountPopUp;

    @FindBy(how = How.XPATH, using = "//*[@class='boxesHolder slideThis']//*[@class='closeButton']//*[@class='icon-cancel']")
    private WebElement PopUp;

    @FindBy(how = How.XPATH, using = "//*[@class='closeButton']")
    private WebElement discountFlag;

    @FindBy(how = How.XPATH, using = "//button[contains(., ' Sign In ')]")
    private WebElement SignInBtn;

    @FindBy(how = How.XPATH, using = "//strong[contains(., ' Register ')]")
    private WebElement RegisterBtn;

    @FindBy(how = How.XPATH, using = "//*[@class='userPanel']//strong")
    private WebElement userNameDropdown;

    @FindBy(how = How.XPATH, using = "//*[@class='doneButton']")
    private WebElement doneBtn;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.navigate().to("https://staging.engineer.ai/home");
        wait = new WebDriverWait(driver, 15);
    }

    public void closePopUp() {
        if (isElementPresent(discountPopUp)) {
            discountPopUp.click();
        }
        if (isElementPresent(PopUp)) {
            PopUp.click();
        }
        if (isElementPresent(discountFlag)) {
            discountFlag.click();
        }
    }

    public void selectCurrency(String currency) {
        wait.until(ExpectedConditions.elementToBeClickable(currencyDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class,'currencyName')][contains(text(),'" + currency + "')]"))).click();
    }

    public void login() {
        Actions builder = new Actions(driver);
        builder.moveToElement(SignInBtn).perform();
        builder.moveToElement(RegisterBtn).click().perform();
    }


    public void validateSuccessfulRegistry(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(doneBtn)).click();
        //WebElement userName = driver.findElement();
        assert userNameDropdown.getText().equals(name) : "The user " + userNameDropdown.getText() + " is not the same as the previously registered with name: " + name;
        assert driver.getCurrentUrl().equals("https://staging.engineer.ai/home") : "Url of home page does not match";
    }

    private boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
}
