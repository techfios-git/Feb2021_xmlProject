package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrwoserFactory;


public class LoginTest {
	
	WebDriver driver;
	
	//ReadExcel exlread = new ReadExcel("src\\main\\java\\data\\TF_TestData.xlsx");
	/*String userName ;
	String password ;*/
	
	@Test
	@Parameters({"userName", "password"})
	public void validUserShouldBeAbleToLogin(String userName, String password) {
		
		driver = BrwoserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
		loginPage.clickSigninButton();
		
		DashboardPage dashboarPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboarPage.varifyDashboarPage();
		
		BrwoserFactory.tearDown();
	
	}
	
	
	

}
