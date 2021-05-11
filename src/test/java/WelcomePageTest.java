import com.sun.org.glassfish.gmbal.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WelcomePageTest extends JunitRunner{
    @Epic("Page Object+Allure for web-site www.yellowtailwine.com")
    @Description("Verify that all required elements are displayed")
    @Test
    //Case 1
    public void allRequiredElementsAreDisplayed() {
        WelcomePage welcomePage = new WelcomePage();
        Assertions.assertTrue(welcomePage.getLabelConfirmText().contains("I am of legal drinking age in"));
        Assertions.assertTrue(welcomePage.checkBoxConfirm.isEnabled());
        Assertions.assertTrue(welcomePage.dropdownCountry.isDisplayed());
        Assertions.assertTrue(welcomePage.welcomeButton.isDisplayed());
        Assertions.assertFalse(welcomePage.welcomeButton.isEnabled());
    }

    @Epic("Page Object+Allure for web-site www.yellowtailwine.com")
    @Description("Navigate to  main page as European customer")
    @Test
    //Case 2
    public void navigateToMainPageAsEuropeanCustomer() {
        WelcomePage welcomePage = new WelcomePage();
        //Main page should be displayed
        MainPage mainPage = welcomePage.navigateToMainPageAsEuropeanCustomer();
        Assertions.assertTrue(welcomePage.getMainMenu().isDisplayed());
    }
}
