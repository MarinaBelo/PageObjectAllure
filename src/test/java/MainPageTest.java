import com.sun.org.glassfish.gmbal.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Set;

public class MainPageTest extends JunitRunner{

    @Epic("Page Object+Allure for web-site www.yellowtailwine.com")
    @Description("Navigate to main page")
    @Test
    //Case 3
    public void mainPageAllRequiredElements() {
        //1. Navigate to main page
        WelcomePage welcomePage = new WelcomePage();
        MainPage mainPage = welcomePage.navigateToMainPageAsEuropeanCustomer();
        //2. Verify that the following elements are displayed
        Assertions.assertTrue(welcomePage.getMainMenu().isDisplayed());
        Assertions.assertTrue(mainPage.getContentWelcome().isDisplayed());
        Assertions.assertTrue(mainPage.getFindYourWineButton().isDisplayed());
        Assertions.assertTrue(mainPage.getFooter().isDisplayed());
        Assertions.assertTrue(mainPage.getSlogan().isDisplayed());
    }

    @Epic("Page Object+Allure for web-site www.yellowtailwine.com")
    @Description("Menu Button Logic Open Header -> Verify that header with all needed links is appeared")
    @Test
    //Case 4
    public void menuButtonLogicOpenHeader(){
        //1. Navigate to main page
        WelcomePage welcomePage = new WelcomePage();
        MainPage mainPage = welcomePage.navigateToMainPageAsEuropeanCustomer();
        mainPage.waitForLoadableElement();
        //2.Click on Menu button
        mainPage.clickOnMainMenu();
        //3.Verify that header with all needed links is appeared
        Assertions.assertTrue(mainPage.getYellowTailLogo().isDisplayed());
        Assertions.assertTrue(mainPage.getLinkWines().isDisplayed());
        Assertions.assertTrue(mainPage.getLinkStores().isDisplayed());
        Assertions.assertTrue(mainPage.getLinkCocktails().isDisplayed());
        Assertions.assertTrue(mainPage.getLinkOurStory().isDisplayed());
        Assertions.assertTrue(mainPage.getLinkFAQS().isDisplayed());
        Assertions.assertTrue(mainPage.getLinkContact().isDisplayed());
        Assertions.assertTrue(mainPage.getLinkCountry().isDisplayed());
        //4. Click on [yellow tail]
        mainPage.clickOnYellowTailLogo();
        mainPage.waitForLoadableElement();
        //5. Verify that Menu button is visible
        mainPage.getMainMenu();
        Assertions.assertTrue(mainPage.getMainMenu().isDisplayed());
    }

    @Epic("Page Object+Allure for web-site www.yellowtailwine.com")
    @Description("Menu Button Logic Close Header")
    @Test
    //Case 5
    public void menuButtonLogicCloseHeader() {
        //1. Navigate to main page
        WelcomePage welcomePage = new WelcomePage();
        MainPage mainPage = welcomePage.navigateToMainPageAsEuropeanCustomer();
        //2.Click on Menu button
        mainPage.clickOnMainMenu();
        //3. Click on [yellow tail]
        mainPage.clickOnYellowTailLogo();
        mainPage.waitForLoadableElement();
        //4. Verify that Menu button is visible
        mainPage.getMainMenu();
        Assertions.assertTrue(mainPage.getMainMenu().isDisplayed());
    }

    @Epic("Page Object+Allure for web-site www.yellowtailwine.com")
    @Description("Main page: Global Nav logic")
    @Test
    //Case 6
    public void globalNavLogic() {
        //1. Navigate to main page
        WelcomePage welcomePage = new WelcomePage();
        MainPage mainPage = welcomePage.navigateToMainPageAsEuropeanCustomer();
        //2.Click on Menu button
        mainPage.clickOnMainMenu();
        //3. Click on Globe icon
        mainPage.clickOnGlobeIcon();
        //4. Select China in popup and click on it
        mainPage.clickOnGlobeIconChina();
        //5. Verify that language is changed
        Assertions.assertTrue(mainPage.getTitle().equalsIgnoreCase("Yellow tail 黄尾袋鼠中文官网"));
    }

    @Epic("Page Object+Allure for web-site www.yellowtailwine.com")
    @Description("Global Nav logic (CHINA - separate site is open)")
    @Test
    //Case 7
        public void globalNavLogicChina() {
        //1. Navigate to main page
        WelcomePage welcomePage = new WelcomePage();
        MainPage mainPage = welcomePage.navigateToMainPageAsEuropeanCustomer();
        //2.Click on Menu button
        mainPage.clickOnMainMenu();
        //3. Click on Globe icon
        mainPage.clickOnGlobeIcon();
        //4. Select China in popup and click on it
        mainPage.clickOnGlobeIconChina();
        // получаем набор дескрипторов текущих открытых окон
        String originalWindow = mainPage.getWindowHandle();
        final Set<String> oldWindowsSet = mainPage.getWindowHandles();
        //5. Click on icon
        WeiboPage weiboPage = mainPage.clickOnIconChinaWeibo();
        weiboPage.switchToWeiboPage(oldWindowsSet);
        //6. Verify that “https://www.weibo.com/yellowtailChina” site is open in new tab
        String newWindowTitle = weiboPage.getTitle();
        System.out.println("New window title: " + newWindowTitle);
        weiboPage.driverClose();
        mainPage.driverSwitchTo(originalWindow);
        String originalWindowTitle = mainPage.getTitle();
        System.out.println("Old window title: " + originalWindowTitle);
        Assertions.assertNotEquals(newWindowTitle, originalWindowTitle);
    }
}
