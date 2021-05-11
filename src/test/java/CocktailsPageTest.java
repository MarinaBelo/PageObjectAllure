import com.sun.org.glassfish.gmbal.Description;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CocktailsPageTest extends JunitRunner{
    @Epic("Page Object+Allure for web-site www.yellowtailwine.com")
    @Description("Select One Wine and Verify that 7 recipes are displayed")
    @Test
    //Case 9
    public void selectOneWine() {
        //Pre-condition-1 Navigate to main page
        WelcomePage welcomePage = new WelcomePage();
        MainPage mainPage = welcomePage.navigateToMainPageAsEuropeanCustomer();
        mainPage.clickOnMainMenu();
        //1. Navigate to “Cocktails” page
        CocktailsPage cocktailsPage = mainPage.clickOnLinkCocktails();
        //2. Select “Red wine cocktails”
        cocktailsPage.clickOnSelect();
        cocktailsPage.clickOnRedWineCocktails();
        //3. Verify that 7 recipes are displayed
        int expectedQuantityOfRedVines =7;
        System.out.println("Count of displayed recipes " + cocktailsPage.countOfRedWineCocktailsRecipes());
        Assertions.assertEquals(expectedQuantityOfRedVines, cocktailsPage.countOfRedWineCocktailsRecipes());
    }

    @Epic("Page Object+Allure for web-site www.yellowtailwine.com")
    @Description("Navigate to Cocktail recipe page")
    @Test
    //Case 10
    public void navigateToCocktailRecipePage() {
        //Pre-condition-1 Navigate to main page
        WelcomePage welcomePage = new WelcomePage();
        MainPage mainPage = welcomePage.navigateToMainPageAsEuropeanCustomer();
        mainPage.clickOnMainMenu();
        //1. Navigate to “Cocktails” page
        CocktailsPage cocktailsPage = mainPage.clickOnLinkCocktails();
        //2. Scroll to “RASPBERRY ROSE” recipe
        // Javascript executor
        cocktailsPage.scrollToElement("arguments[0].scrollIntoView(true);", cocktailsPage.getRaspberryRose());
        //3. Click on “RASPBERRY ROSE” recipe
        ProductPage productPage = cocktailsPage.clickOnRaspberryRose();
        //4. Verify that new page is displayed:- ingredients section is displayed
        Assertions.assertEquals(productPage.getCurrentUrl(), "https://www.yellowtailwine.com/recipe/raspberry-rose/");
        Assertions.assertTrue(productPage.getIngredients().isDisplayed());
    }

    @Epic("Page Object+Allure for web-site www.yellowtailwine.com")
    @Description("Select several wines")
    @Test
    //Case 11
    public void selectSeveralWines() {
        //Pre-condition-1 Navigate to main page
        WelcomePage welcomePage = new WelcomePage();
        MainPage mainPage = welcomePage.navigateToMainPageAsEuropeanCustomer();
        mainPage.clickOnMainMenu();
        //1. Navigate to “Cocktails” page
        CocktailsPage cocktailsPage = mainPage.clickOnLinkCocktails();
        //2. Select “Red wine cocktails”
        cocktailsPage.clickOnSelect();
        cocktailsPage.clickOnRedWineCocktails();
        //3. Select “Sparkling wine cocktails”
        cocktailsPage.clickOnSparklingWineCocktails();
        //4. Verify that “Multiple” word is displayed in “Type” dropdownCountry
        Assertions.assertTrue(cocktailsPage.getMultiple().isDisplayed());
        //5. Verify that 18 recipes are displayed
        int expectedRedWineSparklingRecipes=18;
        System.out.println("Count of displayed recipes " + cocktailsPage.countRedWineSparklingRecipes());
        Assertions.assertEquals(expectedRedWineSparklingRecipes, cocktailsPage.countRedWineSparklingRecipes());
    }

}
