package genericLibraries;

import org.testng.ITestContext;
import org.testng.ITestResult;

public class SampleListenersImp {

	public void onStart(ITestContext arg0) {
		System.out.println("onStart");
	}
	
	public void onTestStart(ITestResult arg0) {
		System.out.println("OnTestStart");
		
	}
}
