package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {

	private WebDriver driver;
	private long time;

	
	/**
	 * This method is used to launch the browser
	 * 
	 * @param browser
	 * @return
	 */

	public WebDriver launchBrowser(String browser) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Invalid browser data");
		}
		return driver;
	}

	/**
	 * This method is used to maximize the browser
	 */
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used to navigate to application
	 * 
	 * @param url
	 */
	public void navigateTo(String url) {
		driver.get(url);
	}

	/**
	 * This method waits until element is found
	 * 
	 * @param time
	 */
	public void waitTillElementFound(long time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	/**
	 * This method navigates to application
	 * @param browser
	 * @param url 
	 * @return
	 */
	public WebDriver openApplication(String browser, String url, long time) {
		WebDriver driver = launchBrowser(browser);
		maximizeBrowser();
		navigateTo(url);
		waitTillElementFound(time);
		return driver;
	}

	/**
	 * This method returns web element if the element is visible
	 * 
	 * @param time
	 * @param element
	 * @return
	 */
	public WebElement explicitWait(long time, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method returns WebElement if it is enabled
	 * 
	 * @param element
	 * @param time
	 * @return
	 */
	public WebElement explicitWait(WebElement element, long time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method returns true if the web page title is displayed
	 * 
	 * @param time
	 * @param title
	 * @return
	 */
	public boolean explicitWait(String title) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.titleContains(title));
	}

	/**
	 * THis method is used to mouse hover on an element
	 * 
	 * @param element
	 */
	public void mouseHover(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}

	/**
	 * THis method is used to right click on an element
	 * 
	 * @param element
	 */
	public void rightClickOnElement(WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}

	/**
	 * THis method is used to double click on an element
	 * 
	 * @param element
	 */
	public void doubleclickOnElement(WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}

	/**
	 * THis method is used to drag and drop an element
	 * 
	 * @param element
	 * @param source
	 * @param target
	 */
	public void dragAndDropElement(WebElement source, WebElement target) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source, target).perform();
	}

	/**
	 * This method is used to select an element from drop down using index
	 * 
	 * @param index
	 * @param element
	 */
	public void dropDown(int index, WebElement element) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	/**
	 * This method is used to select an element from drop down using value
	 * 
	 * @param element
	 * @param value
	 */
	public void dropDown(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	/**
	 * This method is used to select an element from drop down using visibleText
	 * 
	 * @param text
	 */
	public void dropDown(String text, WebElement element) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	/**
	 * This method is used to switch to frame using index
	 * @param index 
	 */
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method is used to switch to frame using id or name attribute value
	 * @param idOrName 
	 */
	public void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);
	}
	
	
	/**
	 * This method is used to scroll till the element
	 * @param element 
	 */
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	/**
	 * This method captures the screenshot and returns the absolute path of the screenshot file
	 * @param screenshotPath
	 * @return 
	 */
	public String getScreenshot(String className, WebDriver driver, JavaUtility jutil) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot"+className+"_"+jutil.getCurrentTime()+".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dest.getAbsolutePath();
	}
	
	/**
	 * This method is used to handle alert popup
	 * @param status 
	 */
	public void handleAlert(String status) {
		Alert al = driver.switchTo().alert();
		if(status.equalsIgnoreCase("OK"))
			al.accept();
		else
			al.dismiss();
	}
	
	/**
	 * This method is used to switch to child window
	 */
	public void childBrowserPopup() {
		Set<String> windowIDs = driver.getWindowHandles();
		for (String id : windowIDs) {
			driver.switchTo().window(id);
		}
	}
	
	/**
	 * This method is used to getparent window id
	 * @return 
	 */
	public String getParentWindowID() {
		return driver.getWindowHandle();
	}
	
	/**
	 * This method is used to switch to required window
	 */
	public void switchToWindow(String id) {
		driver.switchTo().window(id);
	}
	
	/**
	 * This method is used to convert dynamic xpath to web element
	 * @param dynamicPath
	 * @param replaceData
	 * @return
	 */
	public WebElement dynamicXpathConversion(String dynamicPath, String replaceData) {
		String requiredPath = String.format(dynamicPath, replaceData);
		WebElement element = driver.findElement(By.xpath(requiredPath));
		return element;
		
	}
	
	/**
	 * This method is used to close current Window
	 */
	public void closeCurrentWindow() {
		driver.close();
	}
	
	/**
	 * This method is used to close all windows
	 */
	public void closeAllWindows() {
		driver.quit();
	}
	
}
