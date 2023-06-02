package TourPackage.Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.ObjectRepository.AdminLoginPage;
import com.ObjectRepository.PackageDetailsPage;
import com.ObjectRepository.PackageListPage;
import com.ObjectRepository.UserHomePage;
import com.ObjectRepository.WelcomePage;

@Listeners(com.GenericUtilities.ListenerImplementation.class)
public class BookTourPackageTest extends BaseClass
{
	@Test(groups = "smokeTest",retryAnalyzer = com.GenericUtilities.RetryAnalyzer.class)
	public void bookTourPackageTest() throws EncryptedDocumentException, IOException, InterruptedException 
	{		
		//TO FETCH EXCEL DATA
		String packageToBook=eutil.getDataFromExcel("Sheet1", 7, 0);
	/*	String startDate=eutil.getDataFromExcel("Sheet1", 7, 1);
		String endDate=eutil.getDataFromExcel("Sheet1", 7, 2);
		String comment=eutil.getDataFromExcel("Sheet1", 7, 3)+jutil.getRandomNumber();
	*/	
		//Admin Logout
		AdminLoginPage alp=new AdminLoginPage(driver);
		alp.adminLogout();
		
		//login as user
		WelcomePage wp=new WelcomePage(driver);
		wp.signInUser(USERUSERNAME, USERPASSWORD);
		
		//Navigate to tour package page
		UserHomePage uhp=new UserHomePage(driver);
		uhp.getTourPackagesLnk().click();
		
		//Select given package
		PackageListPage plp=new PackageListPage(driver);
		plp.clickOnDetailsButton(packageToBook);

		PackageDetailsPage pdp=new PackageDetailsPage(driver);
		pdp.bookTourPackage();
		Assert.assertTrue(pdp.confirmationStatus().equalsIgnoreCase("Success"),"Booking package Unsuccessfull");
		Reporter.log("Booked package Successfully", true);
		
		//User Logout
		uhp.userLogout();
		
		//Admin Login
		alp.adminLogin(ADMINUSERNAME, ADMINPASSWORD);		
	}
}
