import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestResultLoggerExtension.class)
public class Junit5RunnerTestWatcher {
    @BeforeEach
    public void before(){}

    @AfterEach
    public void after(){}
}
