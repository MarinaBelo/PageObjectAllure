import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StorePageTest extends JunitRunner{
    @Epic("Page Object+Allure for web-site www.yellowtailwine.com")
    @Description("Enter Valid Location")
    @Test
    //Case 8
    public void enterValidLocation()  {
        //Pre-condition-1 Navigate to main page
        WelcomePage welcomePage = new WelcomePage();
        MainPage mainPage = welcomePage.navigateToMainPageAsEuropeanCustomer();
        mainPage.clickOnMainMenu();
        //1.Navigate to “Where to buy” page
        mainPage.clickOnMainMenu();
        StorePage storePage = mainPage.clickOnLinkStores();
        //2.Enter valid data in “Your location” field
        storePage.clickOnLocation();
        storePage.locationSendKeys("Madrid");
        //3. Click on Search button
        storePage.clickOnSearchButton();
        //4.Verify that the results of search are displayed
        Assertions.assertTrue(storePage.getResults().isDisplayed());
    }
}
