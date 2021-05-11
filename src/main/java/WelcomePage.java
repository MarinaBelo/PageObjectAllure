import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverProvider;

import java.time.Duration;

public class WelcomePage extends AbstractPage{
    public WelcomePage() {
        super();
        waitForLoadableElement();
    }

    @Override
    public void waitForLoadableElement() {
        WebElement explicitWait1 = (new WebDriverWait(DriverProvider.INSTANCE.getDriver(),Duration.ofSeconds(7)))
                .until(ExpectedConditions.visibilityOf(getWelcomeButton()));
    }

    @FindBy(css = "[for=confirm]")
    WebElement labelConfirm;
    @FindBy(css = "[type=checkbox]")
    WebElement checkBoxConfirm;
    @FindBy(css = "[for=\"confirm\"]")
    WebElement confirmAge;
    @FindBy(css = "select.agegate-selector-options")
    WebElement dropdownCountry;
    @FindBy(css = "input[value=Welcome]")
    WebElement welcomeButton;
    @FindBy(css = ".fa.fa-bars")
    WebElement mainMenu;

    public String getLabelConfirmText (){
        return labelConfirm.getText();
    }

    public void confirmAgeCheck(){
        confirmAge.click();
    }

    public MainPage clickOnWelcomeButton(){
        welcomeButton.click();
        return new MainPage();
    }

    public void selectDropdownByIndex(int index){
        Select dropdownCountry = new Select(getDropdownCountry());
        dropdownCountry.selectByIndex(index);
    }

    @Step
    public MainPage navigateToMainPageAsEuropeanCustomer(){
        confirmAgeCheck();
        selectDropdownByIndex(3);
        clickOnWelcomeButton();
        return new MainPage();

    }

    public WebElement getLabelConfirm() {
        return labelConfirm;
    }

    public WebElement getCheckBoxConfirm() {
        return checkBoxConfirm;
    }

    public WebElement getDropdownCountry() {
        return dropdownCountry;
    }

    public WebElement getWelcomeButton() {
        return welcomeButton;
    }

    public WebElement getMainMenu() {
        return mainMenu;
    }
}
