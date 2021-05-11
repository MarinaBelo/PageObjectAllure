import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {
    public ProductPage() {
        super();
    }

    @Override
    public void waitForLoadableElement() {

    }

    @FindBy(css = ".ingredients")
    WebElement ingredients;

    public WebElement getIngredients() {
        return ingredients;
    }

    public String getCurrentUrl (){
        return getCurrentUrl();
    }
}
