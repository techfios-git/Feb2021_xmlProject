package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrwoserFactory;


public class AddCustomerTest {
	
	WebDriver driver;
	
	//@Test
	@Parameters({"userName", "password", "FullName", "CompanyName", "Email", "Phone", "Address", "City", "Country", "State", "Zip"})
	public void validUserShouldBeAbleToAddCustomer(String username, String password, String fullName, String companyName, String emailName, String phone, String address, String city, String country, String state, String zip) {
		
		driver = BrwoserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		loginPage.clickSigninButton();
		
		DashboardPage dashboarPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboarPage.varifyDashboarPage();
		dashboarPage.clickCustomerButton();
		dashboarPage.clickAddCustomerButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.enterFullName(fullName);
		addCustomerPage.enterCompanyName(companyName);
		addCustomerPage.enterEmail(emailName);
		addCustomerPage.enterPhone(phone);
		addCustomerPage.enterAddress(address);
		addCustomerPage.enterCity(city);
		addCustomerPage.enterState(state);
		addCustomerPage.enterZip(zip);
		addCustomerPage.enterCountry(country);
		addCustomerPage.clickSaveButtonOnAddCustomerPage();
		
		dashboarPage.clickListCustmerButton();
		
		addCustomerPage.verifyEnteredNameAndDelete();
		
		//BrwoserFactory.tearDown();
	}
	
	@Test
	@Parameters({"userName", "password", "FullName", "CompanyName", "Email", "Phone", "Address", "City", "Country", "State", "Zip"})
	public void validUserShouldBeAbleToAddCustomerFromListCustomer(String username, String password, String fullName, String companyName, String emailName, String phone, String address, String city, String country, String state, String zip) {
		
		driver = BrwoserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(username);
		loginPage.enterPassword(password);
		loginPage.clickSigninButton();
		
		DashboardPage dashboarPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboarPage.varifyDashboarPage();
		dashboarPage.clickCustomerButton();
		dashboarPage.clickListCustmerButton();
		
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.clickAddCustomerOnListCustomer();
		addCustomerPage.enterFullName(fullName);
		addCustomerPage.enterCompanyName(companyName);
		addCustomerPage.enterEmail(emailName);
		addCustomerPage.enterPhone(phone);
		addCustomerPage.enterAddress(address);
		addCustomerPage.enterCity(city);
		addCustomerPage.enterState(state);
		addCustomerPage.enterZip(zip);
		addCustomerPage.enterCountry(country);
		addCustomerPage.clickSaveButtonOnAddCustomerPage();
		
		dashboarPage.clickListCustmerButton();
		
		addCustomerPage.enterSearchBarOnListCustomer();
		addCustomerPage.verifySearchBarAndSummaryButtonOnListCustomer();
		
		//BrwoserFactory.tearDown();
	}

}
