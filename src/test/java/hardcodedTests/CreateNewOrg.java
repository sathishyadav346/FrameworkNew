package hardcodedTests;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewOrg {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);

		WebElement loginPage = driver.findElement(By.xpath("//a[.='vtiger']"));
		if (loginPage.isDisplayed()) {
			System.out.println("LoginPage is displayed");
		} else {
			System.out.println("LoginPage Not found");
		}

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);

		WebElement homePage = driver.findElement(By.xpath("//td[@class=\"moduleName\"]"));
		if (homePage.isDisplayed()) {
			System.out.println("HomePage is displayed showing : " + homePage.getText());
		} else {
			System.out.println("HomePage Not found");
		}
		driver.findElement(By.xpath("//a[contains(@href,'Sccounts&action']")).click();
		WebElement organizationsPage = driver.findElement(By.xpath("//a[@class='hdrLink']"));
		if (organizationsPage.isDisplayed()) {
			System.out.println("Organizations page is displayed");
		} else {
			System.out.println("Organizations  Pageis not Found");
		}

		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		WebElement creatingNewOrgPage = driver.findElement(By.xpath("//span[@class='1vtHeaderText']"));
		if (creatingNewOrgPage.isDisplayed()) {
			System.out.println("Creating new organization page is displayed");
		} else {
			System.out.println(" creating new Organizations page not found");
		}

		Random random = new Random();
		String orgName = "DCT" + random.nextInt(100);
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();

		WebElement OrganizationInfoPage = driver.findElement(By.xpath("//span[@class='1vHeaderText']"));
		if (OrganizationInfoPage.isDisplayed()) {
			System.out
					.println("Organization  Information page is displayed showing :" + OrganizationInfoPage.getText());
		} else {
			System.out.println("Organization Informaton page is not found");
		}

		Actions a = new Actions(driver);
		WebElement adminIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		a.moveToElement(adminIcon).perform();
		WebElement signOutIcon = driver.findElement(By.xpath("//a[text()='sign Out']"));
		a.moveToElement(signOutIcon).perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[text()='sign Out']")).click();

		Thread.sleep(2000);
		driver.quit();
	}
}
