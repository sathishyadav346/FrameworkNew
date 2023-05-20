package genericLibraries;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import bsh.Capabilities;

public class ListenerImplementation1 implements ITestListener {
	public ExtentReports report;
	public ExtentTest test;

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./ExtentReports/report.html");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("VTiger crm extent reports");
		spark.config().setReportName("Vtiger");

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Author", "Lakshmi");
		report.setSystemInfo("OS", System.getProperty("os.name"));
		report.setSystemInfo("Java Version", System.getProperty("java.version"));

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		Capabilities cap = ((RemoteWebDriver) BaseClass.sdriver).getCapabilities();
		report.setSystemInfo("Browser", cap.getBrowserName() + " " + cap.getVersion());
		test = report.createTest(arg0.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		test.pass(arg0.getMethod().getMethodName() + " Pass");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		test.fail(arg0.getMethod() + " fail");
		test.fail(arg0.getThrowable());
		WebDriverUtility web = new WebDriverUtility();
		String screenshotPath = web.getScreenshot(arg0.getMethod().getMethodName(), BaseClass.sdriver,
				BaseClass.sjutil);
		test.addScreenCaptureFromPath(screenshotPath);
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		test.skip(arg0.getMethod().getMethodName() + " skipped");
		test.fail(arg0.getThrowable());

	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();

	}

}