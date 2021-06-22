package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import mobserverproxy.StartMobServer;

public class Login_Tests extends BaseTests {

	@BeforeTest
	public void startProxy() {
		proxyServer = new StartMobServer();
		proxyServer.startServer();
	}
	
	@AfterTest
	public void stopServer() {
		proxyServer.stopServer();
	}
		
	@BeforeClass
	public void setUP() {
		setUpSession();// this set driver session
		initKeywords();// this initialize required keywords
	}
	
	@Test(description="Verify User Can navigate to the Login Page from the Landing using myaccount login option")
	public void Test1_Verify_Login_Page_Accessible_From_Landing() throws InterruptedException {
		homePageKeywords.launchApplication("https://google.com");//// base condition ()
			//Assertions
		//softly.assertThat(loginKeywords.getPageTitle()).isEqualTo("Account Login");
		
		Thread.sleep(1000000);
		softly.assertAll();
	}
	
	//@Test(description="Verify a valid registered user can login into the system using valid set of credentials")
	public void Test2_Verify_A_Valid_User_Having_Account_Can_Login_Using_Valid_UserName_And_Password() {
		// base condition
		homePageKeywords.launchApplication(testdata.getLoginPagePath());
		// execution
		loginKeywords.login(testdata.getCustomerUserName(), testdata.getCustomerPassword());
		//assertions
		softly.assertAll();
	}
	
}
