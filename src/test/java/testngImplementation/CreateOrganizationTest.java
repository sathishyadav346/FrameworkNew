package testngImplementation;

import java.util.Map;

import org.testng.asserts.SoftAssert;

import genericUtilitiesOrLibraries.BaseClass;
import genericUtilitiesOrLibraries.IConstantPath;


public class CreateOrganizationTest extends BaseClass{

	@Test
	public void createOraganizationTest() {
		SoftAssert soft = new SoftAssert();
		home.clickRequiredTab(TabNames .ORGANIZATIONS,webUtil);
		soft.assertTrue(driver.getTitle().contains("organizations"));
	
	org.clickPlusButton();
	soft.assertTrue(createOrg.getPageHeader().contains("creating"));
	
	Map<String, String> map = excel.getDataFromExcel("OrganizationsTestData","Create Organization");
	
	createOrg.setOrgName(orgName);
	createOrg.clicksaveButton();
	
	soft.assertTrue(newOrgInfo.getPageHeader().contains(orgName));
	if(newOrgInfo.getPageHeader().contains(org/Name))
		excel.writeDataToExcel("OrganizationTestData","Create Organization","pass",IConstantPath.EXCEL_PATH);
	else
		excel.writeDataToExce("OrganizationTest","create organization","Fail",IConstantPath.EXCEL_PATH)
	}
} 
u