package practies;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass1 {
	@Test
	public void test1() {
		System.out.println("TestClass1=> test1");
		
	}
	//  Test(retryAnalyzer = genriclib.SampleRetryImp.class)
	 public void test2(){
	System.out.println("test2");
	Assert.fail();
 
	}	
	 
}
	
	


