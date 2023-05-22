package genericLibraries;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener {
	public ExtentReports report;
	public ExtentTest test;
	
	@Override
	public void onStart() {
		ExtentSparkReporter	 spark = new ExtentSparkReporter("./ExtentReports/report.html");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Vtiger CRM Extent Reports");
		spark.config().setReportName("Vtiger");
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Author", "nanje");
		report.setSystemInfo("OS", System.getProperty("os.name"));
		report.setSystemInfo("Java Version", System.getProperty("java.version"));
		
		
	}
	
	@Override
	public void onTestStart(ITestResult arg0) {
		Capabilities cap = ((RemoteWebDriver)BaseClass.sdriver).getCapabilities();
		report.setSystemInfo("Browser", cap.getBrowserName()+" "+cap.getVersion());
		test = report.createTest(arg0.getMethod().getMethodName());
		
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		test.pass(arg0.getMethod().getMethodName()+ " pass ");
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		test.fail(arg0.getMethod().getMethodName()+" Fail");
		test.fail(arg0.getThrowable());
		WebDriverUtility web = new WebDriverUtility();
		String screenshotPath = web.getScreenshot(arg0.getMethod().getMethodName(),
				BaseClass.sdriver, BaseClass.sjUtil);
		
		test.addScreenCaptureFromPath(screenshotPath);	
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		test.skip(arg0.getMethod().getMethodName()+ " Skipped");
		test.fail(arg0.getThrowable());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		
	}

}