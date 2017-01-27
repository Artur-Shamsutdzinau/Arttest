package framework;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class MyTestListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult tr) {
        System.out.println(tr.getName() + " -  Failed");
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        System.out.println(tr.getName() + " - Skipped");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        System.out.println(tr.getName() + " - Passed");
    }
}
