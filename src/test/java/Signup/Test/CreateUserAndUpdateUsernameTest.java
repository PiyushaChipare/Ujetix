package Signup.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.ObjectRepository.AdminLoginPage;
import com.ObjectRepository.MyProfileUserPage;
import com.ObjectRepository.UserHomePage;
import com.ObjectRepository.WelcomePage;

@Listeners(com.GenericUtilities.ListenerImplementation.class)
public class CreateUserAndUpdateUsernameTest extends BaseClass
{
	@Test(retryAnalyzer = com.GenericUtilities.RetryAnalyzer.class)
	public void createUserAndUpdateUsernameTest() throws FileNotFoundException, IOException, InterruptedException 
	{
		//RANDOM NUMBER
		int num =jutil.getRandomNumber();

		//TO FETCH EXCEL DATA
		String FULLNAME =eutil.getDataFromExcel("Sheet1", 4, 0);
		String MOBILE=eutil.getDataFromExcel("Sheet1", 4, 1);
		String EMAIL = num+eutil.getDataFromExcel("Sheet1", 4, 2);
		String PASSWORD = eutil.getDataFromExcel("Sheet1", 4, 3);
		String NEWUSERNAME =eutil.getDataFromExcel("Sheet1", 4, 4);

		//Admin Logout
		AdminLoginPage alp=new AdminLoginPage(driver);
		alp.adminLogout();

		//Create a user
		WelcomePage wp=new WelcomePage(driver);
		wp.signUpUser(FULLNAME, MOBILE, EMAIL, PASSWORD);
		String confirmation = driver.getCurrentUrl();
		System.out.println(confirmation);
		Assert.assertTrue(confirmation.contains("thankyou"), "Account creation Failed");
		Reporter.log("Account created successfully",true);

		//Login as User
		wp.signInUser(EMAIL, PASSWORD);

		//Navigate to My Profile page
		UserHomePage uhp=new UserHomePage(driver);
		uhp.getMyProfileLnk().click();

		//Update user name
		MyProfileUserPage mpp=new MyProfileUserPage(driver);
		mpp.updateName(NEWUSERNAME);

		String submitStatus = driver.findElement(By.xpath("//h3[.='Change Password']/..//strong")).getText();
		Assert.assertTrue(submitStatus.contains("SUCCESS"), "Username NOT updated successfully");
		Reporter.log("Username updated successfully");
		//Log out as User
		driver.findElement(By.linkText("/ Logout")).click();
		String homeUrl = driver.getCurrentUrl();
		Assert.assertTrue(homeUrl.contains("index"), "User Logout Unsuccessfull");
		Reporter.log("Logout Successfull");	

		//Admin Login
		alp.adminLogin(ADMINUSERNAME, ADMINPASSWORD);
	}
}
