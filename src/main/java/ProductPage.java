import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverProvider;

import java.time.Duration;

public class ProductPage extends AbstractPage {
    public ProductPage() {
        super();
        waitForLoadableElement();
    }

    @Override
    public void waitForLoadableElement() {
        WebElement explicitWait = (new WebDriverWait(DriverProvider.INSTANCE.getDriver(), Duration.ofSeconds(10)))
                .until(ExpectedConditions.visibilityOf(getIngredients()));
    }

    @FindBy(css = ".ingredients")
    WebElement ingredients;

    public WebElement getIngredients() {
        return ingredients;
    }

    public String getCurrentUrl (){
        return DriverProvider.INSTANCE.getDriver().getCurrentUrl();
    }
}
