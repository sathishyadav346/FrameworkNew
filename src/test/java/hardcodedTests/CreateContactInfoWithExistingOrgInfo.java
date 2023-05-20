package hardcodedTests;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class CreateContactInfoWithExistingOrgInfo {

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
			System.out.println("HopePage is displayed showing : " + homepage.getText());

		} else {
			System.out.println("HomePage not found");
		}
		driver.findElement(By.xpath("//a[text( )='Leads'and contains(@href,'Contacts&action')]")).click();
		Thread.sleep(2000);

		WebElement contactPage = driver.findElement(By.xpath("//a[@class='hdrLink']"));
		if (contactPage.isDisplayed()) {
			System.out.println("Contacts page is displayed showing :" + contactPage.getText());

		} else

		{
			System.out.println("contacts page not found");
		}
		driver.findElement(By.xpath("//img[@title='create contact...']")).click();
		WebElement createNewcontactPage = driver.findElement(By.xpath("//span[@class='1vtHeaderText']"));
		if (createNewcontactPage.isDisplayed()) {
			System.out.println("createing new contact page is displayed showing : " + createNewcontactPage.getText());
		} else {
			System.out.println("createing new contact page not found");
		}

		Random random = new Random();
		String name = "ghj" + random.nextInt(100);
		driver.findElement(By.name("lastname")).sendKeys(name);
		driver.findElement(By.xpath("//img[contains(@onclick,'Account@action')]")).click();
		Thread.sleep(2000);
		String ParentID = driver.getWindowHandle();
		Set<String> windowIDS = driver.getWindowHandles();
		for (String window : windowIDS) {
			driver.switchTo().window(window);
		}

		WebElement childBrowser = driver.findElement(By.xpath("//td[@class='moduleName']"));
		if (childBrowser.isDisplayed()) {
			System.out.println("Child Browser popup window is opened showing organizations");
		} else {
			System.out.println("Child Browser popup window not Found");
		}
		driver.findElement(By.id("2")).click();

		driver.switchTo().window(ParentID);
		Thread.sleep(2000);

		WebElement saveButton = driver.findElement(By.xpath("//input[@type='submit']"));
		Actions r = new Actions(driver);
		r.moveToElement(saveButton).perform();
		saveButton.click();

		WebElement contactInfoPage = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		if (contactInfoPage.isDisplayed()) {
			System.out.println("contact Information page is displayed showing : " + contactInfoPage.getText());
		} else {
			System.out.println("contact Information page not found");
		}

		Actions a = new Actions(driver);
		WebElement adminIcon = driver.findElement(By.xpath("//img[@src='themes/softd/images/user.PNG']"));
		a.moveToElement(adminIcon).perform();
		WebElement signOutIcon = driver.findElement(By.xpath("//a[text()='sign Out']"));
		a.moveToElement(signOutIcon).perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[text()='sign Out']")).click();

		Thread.sleep(2000);
		driver.quit();
	}

}
