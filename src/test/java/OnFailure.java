
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class OnFailure extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult tr) {
        BaseTest.makeScreenshot();
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        BaseTest.makeScreenshot();
    }
}
