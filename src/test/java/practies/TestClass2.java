package practies;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass2 {
	@Test
	public void test1() {
		System.out.println("TestClass2=> test1");
		
	}
	 public void test2(){
	System.out.println("test2");
	Assert.fail();
	 }
}
