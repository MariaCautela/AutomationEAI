package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(how = How.XPATH, using = "//button[contains(., 'TAKE A TOUR ')]")
    private WebElement takeTour;

    @FindBy(how = How.XPATH, using = "//button[contains(., 'Skip Tour ')]")
    private WebElement skipTour;


    public WelcomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    public void takeATourAndSkip() {
        wait.until(ExpectedConditions.elementToBeClickable(takeTour)).click();
        wait.until(ExpectedConditions.elementToBeClickable(skipTour)).click();
    }
}
