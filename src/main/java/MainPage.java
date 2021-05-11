import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverProvider;

import java.sql.Driver;
import java.time.Duration;
import java.util.Set;

public class MainPage extends AbstractPage{
    public MainPage() {
        super();
        waitForLoadableElement();
    }

    @FindBy(css = ".inner>.fa.fa-bars")
    WebElement mainMenu;
    @FindBy(css = ".-one >h2")
    WebElement contentWelcome;
    @FindBy(css = ".-one >h2~.home-button")
    WebElement findYourWineButton;
    @FindBy(css = "#primary-footer")
    WebElement footer;
    @FindBy(xpath = "//*[text()='We are passionate about creating great tasting, quality wines for everyone to enjoy']")
    WebElement slogan;
    //header with all needed links
    @FindBy(css = ".top-nav .yt-logo")
    WebElement yellowTailLogo;
    @FindBy(css = ".inner a[href$=\"/wines/\"]")
    WebElement linkWines;
    @FindBy(css = ".inner a[href$=\"/stores/\"]")
    WebElement linkStores;
    @FindBy(css = ".inner a[href$=\"/cocktails/\"]")
    WebElement linkCocktails;
    @FindBy(css = ".inner a[href$=\"/our-story/\"]")
    WebElement linkOurStory;
    @FindBy(css = ".inner a[href$=\"/faqs/\"]")
    WebElement linkFAQS;
    @FindBy(css = ".inner a[href$=\"/contact/\"]")
    WebElement linkContact;
    @FindBy(css = ".inner #country-select")
    WebElement linkCountry;
    @FindBy(css = "[aria-label=\"Go to the China YellowTail website\"]")
    WebElement globeIconChina;
    @FindBy(css = ".social-weibo")
    WebElement iconChinaWeibo;

    @Step
    public void clickOnMainMenu(){
        mainMenu.click();
    }

    @Step
    public void clickOnYellowTailLogo(){
        yellowTailLogo.click();
        waitForLoadableElement();
    }

    public void clickOnGlobeIcon(){
        linkCountry.click();
    }

    @Step
    public void clickOnGlobeIconChina(){
        globeIconChina.click();
    }

    @Step
    public WeiboPage clickOnIconChinaWeibo(){
        iconChinaWeibo.click();
        return new WeiboPage();
    }

    public StorePage clickOnLinkStores(){
        linkStores.click();
        return new StorePage();
    }

    public CocktailsPage clickOnLinkCocktails(){
        linkCocktails.click();
        return new CocktailsPage();
    }

    @Step
    public String getWindowHandle(){
        return DriverProvider.INSTANCE.getDriver().getWindowHandle();
    }

    @Step
    public Set<String> getWindowHandles(){
        return DriverProvider.INSTANCE.getDriver().getWindowHandles();
    }

    @Step
    public String getTitle(){
        return DriverProvider.INSTANCE.getDriver().getTitle();
    }

    @Step
    public void driverSwitchTo(String str){
        DriverProvider.INSTANCE.getDriver().switchTo().window(str);
    }

    @Override
    public void waitForLoadableElement(){
        WebElement explicitWait = (new WebDriverWait(DriverProvider.INSTANCE.getDriver(), Duration.ofSeconds(10)))
                .until(ExpectedConditions.visibilityOf(getMainMenu()));
    }

    @Step
    public WebElement getMainMenu() {
        return mainMenu;
    }

    public WebElement getContentWelcome() {
        return contentWelcome;
    }

    public WebElement getFindYourWineButton() {
        return findYourWineButton;
    }

    public WebElement getFooter() {
        return footer;
    }

    public WebElement getSlogan() {
        return slogan;
    }

    public WebElement getYellowTailLogo() {
        return yellowTailLogo;
    }

    public WebElement getLinkWines() {
        return linkWines;
    }

    public WebElement getLinkStores() {
        return linkStores;
    }

    public WebElement getLinkCocktails() {
        return linkCocktails;
    }

    public WebElement getLinkOurStory() {
        return linkOurStory;
    }

    public WebElement getLinkFAQS() {
        return linkFAQS;
    }

    public WebElement getLinkContact() {
        return linkContact;
    }

    public WebElement getLinkCountry() {
        return linkCountry;
    }
}
