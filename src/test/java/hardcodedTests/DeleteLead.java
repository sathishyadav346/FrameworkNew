package hardcodedTests;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);

		WebElement loginPage = driver.findElement(By.xpath("//a[text()='vtiger']"));
		if (loginPage.isDisplayed())

		{
			System.out.println("LoginPage is displayed");
		} else {
			System.out.println("LoginPage Not Found");

		}
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);

		WebElement homepage = driver.findElement(By.xpath("//td[@class=\"moduleName\"]"));
		if (homepage.isDisplayed()) {
			System.out.println("HomePage is displayed");

		} else {
			System.out.println("HomePage not found");
		}

		driver.findElement(By.xpath("//a[text()='Leads' and contsins(@href,'Leads&action']")).click();
		Thread.sleep(2000);

		WebElement checkbox = driver.findElement(By.xpath("//tr[3]/td[1]/input[@type='checkbox']"));
		checkbox.click();

		if (checkbox.isSelected()) {
			System.out.println("Checkbox not selected");
		} else {
			System.out.println("checkbox not selected");
		}
		WebElement deleteIcon = driver.findElement(By.xpath("//input[@class='crmbutton small delete']"));
		deleteIcon.click();

		Alert a1 = driver.switchTo().alert();
		System.out.println(a1.getText());
		a1.accept();

		Actions a = new Actions(driver);
		WebElement adminIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		a.moveToElement(adminIcon).perform();
		WebElement signOutIcon = driver.findElement(By.xpath("//a[text()='Sign Out']"));
		a.moveToElement(signOutIcon).perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		Thread.sleep(2000);
		driver.quit();
	}
}
