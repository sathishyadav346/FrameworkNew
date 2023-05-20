package pomImplementation;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import genericUtilitiesOrLibraries.ExcelUtility;
import genericUtilitiesOrLibraries.IConstantPath;
import genericUtilitiesOrLibraries.JavaUtility;
import genericUtilitiesOrLibraries.PropertiesUtility;
import genericUtilitiesOrLibraries.WebDriverUtility;


public class CreateEventTest {
	public static void main(String[] args) { 
	 
		PropertiesUtility property = new PropertiesUtility();
		JavaUtility jUtil = new JavaUtility();
		ExcelUtility excel =new ExcelUtility();
		WebDriverUtility webUtil= new WebDriverUtility();
		
		property.propertiesInit(IConstantPath.PROPERTIES_PATH);
		excel.excelInit(IConstantPath.EXCEL_PATH);
		
		String browser = property.fetchDataFromProperties("browser");
		String url = property.fetchDataFromProperties("url");
	    long time = Long.parseLong(property.fetchDataFromProperties("timeouts"));
	    
	    WebDriver driver = webUtil.openApplication(browser,url,time);
	    
	    LoginPage login = new LoginPage(driver);
	    HomePage home = new HomePage(driver);
	    CreateToDOPage createToDO = new CreateToDo(driver);
	    EventInfoPage eventInfo = new EventInfoPage(driver);
	    
	    
	    if(driver.getTitle().contains("Home"))
	    	System.out.println("Home page  displayed ");
		else
			System.out.println("Home page  Not displayed");
		
		Map<String,String> map = excel getDataFromEcxcel("EventsTestData","Create New TestData")
				home selectFromQuickCreate(webUtil.map get("Quick Create"));
		
		if(createToDO.getPageHeader().eqauls("Create To Do"))
			
			System.out.println("Create Event page  displayed ");
		else
			System.out.println("Create Event Page  Not displayed");
		
		String subject = map.get("Subject")+jUtil.generateRandomNumber(100);
		createToDO.setSubject(subject);
		createToDO.clickStartDatePicker();
		createToDO.datePicker(map.get("Start Date"),webUtil);
		Thread.sleep(2000);
		createToDO.clickDueDatePicker();
		createToDO.datePicker(map.get("Due Date"),webUtil);
		 
		if(eventInfo.getPageHeader().contains(subject)) {
			System.out.println("Event created successfully");
			excel.writeDataToExcel("EventTestData", "Create New Event", "Pass",IConstantPath.EXCEL_PATH);
		}
			else {
			
			System.out.println("Event not created ");
			excel.writeDataToExcel("EventTestData", "Create New Event", "Pass",IConstantPath.EXCEL_PATH);
			
		}
		
		home.signOutOfApp(webUtil);
		webUtil.closeAllWindows();
		excel.closeExcel();
				
	}
}

		
 