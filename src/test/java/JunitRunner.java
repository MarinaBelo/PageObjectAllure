import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.Constants;
import utils.DriverProvider;
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
        //DriverProvider.INSTANCE.getDriver().quit();-> из-за этого не запускаются параллельно тесты
        DriverProvider.INSTANCE.removeDriver();
    }
}


