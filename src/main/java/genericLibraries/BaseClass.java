package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pompages.ContactsPage;
import pompages.CreateContactPage2;
import pompages.CreateToDoPage;
import pompages.EventInfoPage;
import pompages.HomePage;

public class BaseClass {
	
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility web;
	protected WebDriver driver;
	protected LoginPage login;
	protected HomePage home;
	protected ContactsPage contact;
	protected CreateContactPage2 createContact;
	protected ContactInfoPage newContactInfo;
	protected CreateToDoPage createEvent;
	protected EventInfoPage eventInfo;
	protected OrganizationsPage org;
	protected CreateOrganizationPage createOrg;
	protected OrganizationInfoPage newOrgInfo;
	protected LeadsPage lead;
	protected CreateLeadPage createLead;
	protected LeadDuplicatingPage leadDuplicate;
	protected LeadInfoPage leadInfo;
	
	public static WebDriver sdriver;
	public static JavaUtility sjutil;
	
	
	// @BeforeSuite
	// @BeforTest
	
	@BeforeClass
	public void classConfiguration() {
		 property = new PropertiesUtility();
		 excel = new ExcelUtility();
		 jutil = new JavaUtility();
		 web = new WebDriverUtility();
		 
		 sjutil = jutil;
		
		property.propertiesInit(IConstantPath.PROPERTIES_PATH);
		excel.excelInit(IConstantPath.EXCEL_PATH);
		
		String browser = property.fetchDataFromProperties("browser");
		String url = property.fetchDataFromProperties("url");
		long time = Long.parseLong(property.fetchDataFromProperties("timeouts"));
		
		driver = web.openApplication(browser,  url, time);
		sdriver = driver;
		Assert.assertTrue(driver.getTitle().contains("vtiger"));
	}
	
	@BeforeMethod
	public void methodConfiguration() {
		login = new LoginPage(driver);
		home = new HomePage(driver);
		contact = new ContactsPage(driver);
		createContact = new CreateContactPage2(driver);
		newContactInfo = new ContactInfoPage(driver);
		createEvent = new CreateToDoPage(driver);
		eventInfo = new EventInfoPage(driver);
		org = new OrganizationsPage(driver);
		createOrg = new CreateOrganizationPage(driver);
		newOrgInfo = new OrganizationInfoPage(driver);
		lead = new LeadsPage(driver);
		createLead= new CreateLeadPage(driver);
		leadDuplicate = new LeadDuplicatingPage(driver);
		leadInfo = new LeadInfoPage(driver);
		
		String username = property.fetchDataFromProperties("username");
		String password = property.fetchDataFromProperties("password");
		login.loginToApp(username, password);
		Assert.assertTrue(driver.getTitle().contains("Home"));
		
	}
	
	@AfterMethod
	public void methodTearDown() {
		home.signOutOfApp(web);
	}
	
	@AfterClass
	public void classTearDown() {
		web.closeAllWindows();
		excel.closeExcel();
	}
	
	// @AfterTest
	// @AfterSuite
	
}