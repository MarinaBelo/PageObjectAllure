import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.DriverProvider;
import java.util.ArrayList;
import java.util.List;

public class TestResultLoggerExtension implements TestWatcher, AfterAllCallback {
    private List<TestResultStatus> testResultStatus = new ArrayList<TestResultStatus>();

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception{
        System.out.println("Test in after all section");
        DriverProvider.INSTANCE.removeDriver();
    }

    private enum TestResultStatus{
        SUCCESSFUL, ABORTED, FAILED, DISABLED;
    }

    @Override
    public void testFailed(ExtensionContext extensionContext, Throwable cause) {
        makeScreenshot();
        testResultStatus.add(TestResultStatus.FAILED);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        makeScreenshot();
        testResultStatus.add(TestResultStatus.SUCCESSFUL);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] makeScreenshot() {
        return ((TakesScreenshot) DriverProvider.INSTANCE.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}







