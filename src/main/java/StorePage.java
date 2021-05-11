import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StorePage extends AbstractPage{
    public StorePage() {
        super();
    }

    @Override
    public void waitForLoadableElement() {

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
