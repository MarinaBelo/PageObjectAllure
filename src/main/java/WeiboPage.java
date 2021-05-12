import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverProvider;

import java.time.Duration;
import java.util.Set;

public class WeiboPage extends AbstractPage{
    public WeiboPage() {
        super();
        waitForLoadableElement();
    }

    @Override
    public void waitForLoadableElement() {
        //WebElement explicitWait = (new WebDriverWait(DriverProvider.INSTANCE.getDriver(), Duration.ofSeconds(10)))
    }

    @Step
    public String getTitle() {
        return DriverProvider.INSTANCE.getDriver().getTitle();
    }

    @Step
    public void switchToWeiboPage(Set<String> oldWindowsSet) {
        String newWindow = (new WebDriverWait(DriverProvider.INSTANCE.getDriver(), 2))
                .until(new ExpectedCondition<String>() {
                    public String apply(WebDriver driver) {
                        Set<String> newWindowsSet = driver.getWindowHandles();
                        newWindowsSet.removeAll(oldWindowsSet);
                        return newWindowsSet.size() > 0 ?
                                newWindowsSet.iterator().next() : null;
                    }
                });
        DriverProvider.INSTANCE.getDriver().switchTo().window(newWindow);
    }

    public void driverClose () {
        DriverProvider.INSTANCE.getDriver().close();
        }
}
