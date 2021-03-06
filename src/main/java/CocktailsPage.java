import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverProvider;

import java.time.Duration;
import java.util.List;

public class CocktailsPage extends AbstractPage{
    public CocktailsPage() {
        super();
        waitForLoadableElement();
    }

    @Override
    public void waitForLoadableElement() {
        WebElement explicitWait = (new WebDriverWait(DriverProvider.INSTANCE.getDriver(), Duration.ofSeconds(10)))
                .until(ExpectedConditions.visibilityOf(getSelect()));
    }

    @FindBy(css = "[aria-label*=\"Raspberry Rosé\"]")
    WebElement raspberryRose;
    @FindBy(css = ".toggle")
    WebElement select;
    @FindBy(css = "[data-value=\"red\"]")
    WebElement redWineCocktails;
    @FindBy(css = "[data-value=\"bubbles\"]")
    WebElement sparklingWineCocktails;
    @FindBy(xpath = "//*[text()='Multiple']")
    WebElement multiple;
    @FindBy(css = "[data-types=\"red\"]")
    List<WebElement> redWineCocktailsRecipes;
    @FindBy(css = "[data-types=\"bubbles\"]")
    List<WebElement> sparklingRecipes;

    @Step
    public void clickOnSelect(){
        select.click();
    }

    public  void clickOnRedWineCocktails(){
        redWineCocktails.click();
    }

    public  void clickOnSparklingWineCocktails(){
        sparklingWineCocktails.click();
    }

    public ProductPage clickOnRaspberryRose(){
        raspberryRose.click();
        return new ProductPage();
    }

    @Step
    public void scrollToElement(String arg, WebElement webElement){
        ((JavascriptExecutor) DriverProvider.INSTANCE.getDriver()).executeScript(arg, webElement);
    }

    public WebElement getSelect() {
        return select;
    }

    public WebElement getMultiple() {
        return multiple;
    }

    public WebElement getRedWineCocktails() {
        return redWineCocktails;
    }

    public WebElement getSparklingWineCocktails() {
        return sparklingWineCocktails;
    }

    public WebElement getRaspberryRose() {
        return raspberryRose;
    }

    public int countOfRedWineCocktailsRecipes(){
        return redWineCocktailsRecipes.size();
    }

    public int countRedWineSparklingRecipes(){
        return (redWineCocktailsRecipes.size()+sparklingRecipes.size());
    }
}
