package hardcodedTests;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewOrganizationManditoryField {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
		
		WebElement  loginHeader = driver.findElement(By.xpath("//a[text()='vtiger']"));

		if(loginHeader.getText().equals("vtiger"))
		System.out.println("Login page is displayed ");
		else
			System.out.println("login page is not displayed");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		 driver.findElement(By.id("submitButton")).submit();
		 
		 WebElement homeHeader =driver.findElement(By.xpath("//a[@class='hdrLink']"));
		 if(homeHeader.getText().contains("Home"))
				System.out.println("Home page  displayed ");
				else
					System.out.println("Home page  Not displayed");
		 
		 driver.findElement(By.xpath("//a[text()='Organizations' and contains(@href,'Accounts&action')]")).click();
		 
				 WebElement   orgInfoHeader = driver.findElement(By.xpath("//a[@class='hdrLink']"));
         if( orgInfoHeader.getText().contains("Organizations"))
				System.out.println("Organizations page  displayed ");
				else
					System.out.println("Organizations page  Not displayed");
         
         driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
     
         WebElement createOrgInfoHeader = driver.findElement(By.xpath("//span[@class=\"lvtHeaderText\"]"));
         if(createOrgInfoHeader.getText().contains("Creating  New Lead"))
				System.out.println("Created orgnization Page Displayed");
				else
					System.out.println("Created organization Page Not Found");
		 
         Random random = new Random();
         String organizationName = "TATA"+random.nextInt(100);
         driver.findElement(By.name("accountname")).sendKeys(organizationName);
	
          driver.findElement(By.xpath("//input[normalize-space(@value)='Save']")).click();

          WebElement duplicateOrgInfoHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
          if( duplicateOrgInfoHeader.isDisplayed())
         	 System.out.println("New  organization Duplicated Created Successfuly");
          else 
         	 System.out.println("New orgsnization  NOt Created  Duplicated");
          WebElement adminIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
          
          Actions a = new Actions(driver);
          a.moveToElement(adminIcon).perform();
          driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
          
          driver.close();
          
	
	}

}
