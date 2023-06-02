package TourPackage.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.GenericUtilities.BaseClass;
import com.ObjectRepository.AdminHomePage;
import com.ObjectRepository.AdminLoginPage;
import com.ObjectRepository.CreatePackagePage;
import com.ObjectRepository.PackageListPage;
import com.ObjectRepository.UserHomePage;
import com.ObjectRepository.WelcomePage;

@Listeners(com.GenericUtilities.ListenerImplementation.class)
public class CreateTourPackageTest extends BaseClass
{
	
	@Test(groups = "integrationTest",retryAnalyzer =com.GenericUtilities.RetryAnalyzer.class )
	public void createTourPackageTest() throws FileNotFoundException, IOException, InterruptedException 
	{		
		//Navigate to Create Tour Package page
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.goToCreatePackagePage(driver, wutil);
		CreatePackagePage cpp=new CreatePackagePage(driver);
		cpp.createPackage();
		String PACKAGENAME =cpp.packageName;
		
		//Admin Logout
		AdminLoginPage alp=new AdminLoginPage(driver);
		alp.adminLogout();
		
		//User Login
		WelcomePage wp=new WelcomePage(driver);
		
		wp.signInUser(USERUSERNAME, USERPASSWORD);
		
		//Navigate to tour package page
		UserHomePage uhp=new UserHomePage(driver);
		uhp.getTourPackagesLnk().click();
		
		//Check if created package is present in package list page or not
		PackageListPage plp=new PackageListPage(driver);
		Assert.assertTrue(plp.packagePresentOrNot(PACKAGENAME), PACKAGENAME+" is not present");
		SoftAssert sa=new SoftAssert();
		Reporter.log( PACKAGENAME+" Package is created ",true);
		
		//User Logout
		uhp.userLogout();
		System.out.println("User Logout Successful");
		
		//Admin Login
		alp.adminLogin(ADMINUSERNAME, ADMINPASSWORD);
		sa.assertTrue(alp.adminLoginSuccessFul(driver), "Admin Login Unsuccessful");
		sa.assertAll();
	}
}
