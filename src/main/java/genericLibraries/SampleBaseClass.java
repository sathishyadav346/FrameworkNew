package genericLibraries;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleBaseClass {
@BeforeSuite
public void suite() {
	System.out.println("BeforeSuite");
}
@BeforeTest
public void test()
{
	System.out.println("BeforeTest");
}
@BeforeClass
public void class1() {
	System.out.println("BeforeClass1");
	
}
@BeforeMethod
public void method() {
	System.out.println("BeforeMethod");
}
@Test
public void test1() {
	System.out.println("test");
}
@AfterMethod
public void AfMethod(){
	System.out.println("AfterMethod");
}

@AfterClass
public void AfClass(){
System.out.println("AfterClass");

}
@AfterSuite
public void AfSuite() {
	System.out.println("AfterSuite");
}
}
