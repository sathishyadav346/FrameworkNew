package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains all reusable methods to perform operation on web driver
 * 
 * @author HP
 *
 */
public class WebDriverUtility2 {
	public WebDriver driver;
	/**
	 * This method is used to launch the browser
	 * @param browser
	 * @return
	 */
	public WebDriver launchBrowser(String browser) {
		switch(browser) {
		
		case "chrome" : 
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
			
		default:
			System.out.println("Invalid browser data");

		}
		return driver;
 	}
	/**
	 * This method is used to maximize to the web browser
	 */
	public void maximizeBrowser() {
		driver.manage().window().maximize();
		}
	
	/**
	 * This method waits until element is found
	 * @param url
	 */
	public void navigateTo(String url) {
		driver.get(url);
	}
	/**
	 * This method waits until element is found
	 * @param time
	 */
	public void waitTillElementFound(long time) {
		driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
		
	}
	
	/**
	 * This method returns WebElement if the element is visible
	 * @param time
	 * @param element
	 * @return
	 */
	
	 public WebElement explicitWait(long time,WebElement element) {
	    	WebDriverWait wait = new WebDriverWait(driver, time);
	    	return wait.until(ExpectedConditions.visibilityOf(element));
	 }
	 /**
	  * This method returns WebElement if it is enable
	  * @param time
	  * @param element
	  * @return
	  */
	
    public WebElement explicitWait(WebElement element,long time) {
    	WebDriverWait wait = new WebDriverWait(driver, time);
    	 return wait.until(ExpectedConditions.elementToBeClickable(element));
    	 
    }
    /**
     * This method returns true if the webpage title is displayed
     * @param time
     * @param title
     * @return
     */
    
    public boolean explicitWait(long time,String title) {
    	WebDriverWait wait = new WebDriverWait(driver, time);
    	return wait.until(ExpectedConditions.titleContains(title));
    }
    /**
     * This method is used to mouseover on an element
     * @param element
     */
    public void mouseHover(WebElement element) {
    	
    	Actions a  = new Actions(driver);
    	a.moveToElement(element).perform();
    	
	}
    /**
     * This method is used to rightClick on element
     * @param element
     */
    public void rightClick(WebElement element) {
    	Actions a = new Actions(driver);
    	a.contextClick(element).perform();
		
	}
    /**
     * This method is used to doubleCLick an element
     * @param element
     */
    public void doubleClick(WebElement element) {
    	Actions a = new Actions(driver);
    	a.doubleClick(element).perform();
    	
	}
    /**
     * This method is used to drag and drop element 
     * @param src
     * @param target
     */
    public void dragAndDropElement(WebElement src, WebElement target) {
    	Actions a =new Actions(driver);
    	a.dragAndDrop(src,target);
		
	} 
    /**
     * This method is used to  select an element from dropdown using index
     * @param element
     * @param index
     */
    public void dropdown( WebElement element, int index) {
    	Select s = new Select(element);
    	s.selectByIndex(index);
    	
   }
    /**
     * This method is used to select an element from dropdown using  value
     * @param element
     * @param value
     */
   
    
    public void dropdown( WebElement element,String value) {
   	Select s = new Select(element);
   	s.selectByValue(value);
   	
    }
    /**
     * This method is used to select an element from drop down using text
     * @param text 
     * @param element
     * @param text
     * @param element 
     */
    
   public void dropdown(String text, WebElement element) {
		Select s = new Select(element);
       	s.selectByVisibleText(text);
     } 
   /**
    * This method is used to switch to frame using index
    * @param index
    */
       
       public void switchToFrame(String index) {
    	   driver.switchTo().frame(index);
		
	}	
	
	/**
	 *  This method is used to swithToFrame
	 * @param IdOrName
	 */
	
	
       public void swichToFrame(String IdOrName) {
    	   driver.switchTo().frame(IdOrName);
		
	}
       
       public String getScreenshot(String className,WebDriver driver,JavaUtility jUtil) {
    	   TakesScreenshot ts = (TakesScreenshot)driver;
    	   File src = ts.getScreenshotAs(OutputType.FILE);
    	   File dest = new File("./Screenshot/"+className+"_"+jUtil.getCurrentTime()+".png");
    	   try {
			FileUtils.copyFile(src,dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dest.getAbsolutePath(); 
       }
        public String getScreenshot(WebDriver driver) {
        	TakesScreenshot ts =(TakesScreenshot)driver;
        	 
        }
       
       /**
        * This method is used to close the window
        */
	public void closeAllWindows() {
		// TODO Auto-generated method stub
		
	}
        
    
 }

