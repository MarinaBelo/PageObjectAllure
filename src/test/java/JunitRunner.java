import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Constants;
import utils.DriverProvider;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

@ExtendWith(TestResultLoggerExtension.class)
public class JunitRunner {

    @BeforeEach
    public void before() {
        DriverProvider.INSTANCE.getDriver().get(Constants.BASIC_URL);
        DriverProvider.INSTANCE.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @AfterEach
    public  void closeBrowser(){
        DriverProvider.INSTANCE.getDriver().quit();
        /*if (DriverProvider.getProvider() == null) {
            return;
            }
        DriverProvider.getProvider().quit();*/
    }

    /*private  void makeScreenshot(){
        Path target = Paths.get("results/temp.png");
        File source = ((TakesScreenshot) DriverProvider.INSTANCE.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(source.toPath(),target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}


