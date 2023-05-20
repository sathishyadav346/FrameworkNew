package hardcodedTests;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.x.protobuf.MysqlxCrud.Find;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatedAndDuplicatedTest1 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement loginHeader = driver.findElement(By.xpath("//a[text()='vtiger']"));
		if (loginHeader.getText().equals("vtiger"))
			System.out.println("Login page is displayed ");
		else
			System.out.println("login page is not displayed");

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).submit();

		WebElement homeHeader = driver.findElement(By.xpath("//a[@class='hdrLink']"));
		if (homeHeader.getText().contains("Home"))
			System.out.println("Home page  displayed ");
		else
			System.out.println("Home page  Not displayed");

		driver.findElement(By.xpath("//a[text()='Contacts' and contains(@href,'Contacts&action')]")).click();
	
		
		WebElement  contactHeader = driver.findElement(By.xpath("//a[@class='hdrLink']"));
		if (contactHeader.isDisplayed())
			System.out.println(" Contact is dispalyed Succesfully");
		else
			System.out.println(" Contact is not displyed Sucessfully");
		
		driver.findElement(By.xpath("Create Contact...")).click();
		WebElement newcontactHeader=driver.findElement(By.xpath("//span[text()='Creating New Contact']"));
		if(newcontactHeader.isDisplayed())
		System.out.println("new contact is displayed");
		else
			System.out.println("new contact is not displayed");
		
		Random random = new Random();
		String lastName = "Pqr" + random.nextInt(100);
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
	}

}
