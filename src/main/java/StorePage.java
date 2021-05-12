import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverProvider;

import java.time.Duration;

public class StorePage extends AbstractPage{
    public StorePage() {
        super();
        waitForLoadableElement();
    }

    @Override
    public void waitForLoadableElement() {
        WebElement explicitWait = (new WebDriverWait(DriverProvider.INSTANCE.getDriver(), Duration.ofSeconds(10)))
                .until(ExpectedConditions.visibilityOf(getSearchButton()));
    }

    @FindBy(css = "#locationName")
    WebElement location;
    @FindBy(css = ".search-submit")
    WebElement searchButton;
    @FindBy(css = ".results")
    WebElement results;

    public void clickOnLocation(){
        location.click();
    }

    public void clickOnSearchButton(){
        searchButton.click();
    }

    public void locationSendKeys (String city){
        location.sendKeys(city);
    }

    public WebElement getLocation() {
        return location;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getResults() {
        return results;
    }
}
