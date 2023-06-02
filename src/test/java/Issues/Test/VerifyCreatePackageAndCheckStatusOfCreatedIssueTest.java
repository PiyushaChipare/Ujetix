package Issues.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.GenericUtilities.BaseClass;
import com.ObjectRepository.AdminHomePage;
import com.ObjectRepository.AdminLoginPage;
import com.ObjectRepository.CreatePackagePage;
import com.ObjectRepository.IssueTicketsPage;
import com.ObjectRepository.ManageIssuesPage;
import com.ObjectRepository.PackageListPage;
import com.ObjectRepository.UpdateComplaintPage;
import com.ObjectRepository.UserHomePage;
import com.ObjectRepository.WelcomePage;
import com.ObjectRepository.WriteUsPage;
@Listeners(com.GenericUtilities.ListenerImplementation.class)
public class VerifyCreatePackageAndCheckStatusOfCreatedIssueTest  extends BaseClass
{
	@Test(retryAnalyzer = com.GenericUtilities.RetryAnalyzer.class)
	public void verifyCreatePackageAndCheckStatusOfCreatedIssueTest() throws EncryptedDocumentException, FileNotFoundException, IOException, InterruptedException 
	{	
		String PACKAGENAME=null;	
		
		String remarkAdmin = "OK Remark";
		String partialUrlOfUpdateRemark="updateissue";
		String partialTitleToMain="manage Issues";
		
		//Navigate to Create Tour Package page
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.goToCreatePackagePage(driver, wutil);

		//Create package
		CreatePackagePage cpp=new CreatePackagePage(driver);
		cpp.createPackage();
		PACKAGENAME = cpp.packageName;	
		String desc = PACKAGENAME+" Booking issue";

		//Verify if package created or not
		Assert.assertTrue(cpp.confirmationStatus().equalsIgnoreCase("success"), "Package creation Unsuccessfull");
		Reporter.log("Package created successfully", true);
		
		//Admin Logout
		AdminLoginPage alp=new AdminLoginPage(driver);
		alp.adminLogout();

		//Login as User
		WelcomePage wp=new WelcomePage(driver);
		wp.signInUser(USERUSERNAME, USERPASSWORD);
		UserHomePage uhp=new UserHomePage(driver);
		uhp.getTourPackagesLnk().click();
		PackageListPage plp=new PackageListPage(driver);

		//Verify if created package is present in package list page or not
		Assert.assertTrue(plp.packagePresentOrNot(PACKAGENAME), "Package is not present");
		Reporter.log("Package is present", true);

		//Navigate to write us page to create issue
		uhp.getWriteUsLnk().click();
		wutil.pageLoadWait(driver);
		WriteUsPage wup=new WriteUsPage(driver);
		wup.createIssue(driver,3, desc);
		
		//Verify issue created or not
		Assert.assertTrue(wup.issueCreatedOrNot(driver), "Issue not created");
		Reporter.log("Issue is created", true);
		uhp.getLogoutLnk().click();

		//Admin Login
		alp.adminLogin(ADMINUSERNAME, ADMINPASSWORD);
		
		//Verify adminLogin Successful
		Assert.assertTrue(alp.adminLoginSuccessFul(driver), "Admin LogIn unsuccessful");
		Reporter.log("Admin LogIn Successful", true);	
		
		//Navigate to manage Issues Page
		ahp.getManageIssueLnk().click();

		//Click on View of given issue
		ManageIssuesPage mip=new ManageIssuesPage(driver);
		mip.clickOnView(desc);
		UpdateComplaintPage ucp=new UpdateComplaintPage(driver);
		wutil.switchWindow(partialUrlOfUpdateRemark, driver);
		ucp.updateRemark(driver, remarkAdmin, partialUrlOfUpdateRemark, partialTitleToMain);
		wutil.scrollTo(driver, 0, 0);

		//Admin Logout
		alp.adminLogout();

		//User Login
		wp.signInUser(USERUSERNAME, USERPASSWORD);

		//Navigate to Issue Ticket Page
		uhp.getIssueTicketsLnk().click();

		IssueTicketsPage itp=new IssueTicketsPage(driver);
		String adminRemark = itp.adminRemarkText(desc);
		
		//Verify Admin remark updated successfully
		Assert.assertTrue(adminRemark.contains(remarkAdmin), "Admin remark Updated Unsuccessful");
		Reporter.log("Admin remark Updated Successful", true);
		uhp.userLogout();
		Reporter.log("User Logout");	

		//Admin Login
		alp.adminLogin(ADMINUSERNAME, ADMINPASSWORD);
		Reporter.log("Admin Login", true);
	}
}
