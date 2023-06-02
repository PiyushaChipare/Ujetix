package Practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.GenericUtilities.JavaScriptUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptUtilityPractice {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		JavaScriptUtility jsutil=new JavaScriptUtility(driver);
		jsutil.launchApplication("https://docs.phptravels.com/");

		//get url of current page
		System.out.println(jsutil.getUrlOfCurrentPage());
		
		//get title of current page
		System.out.println(jsutil.getTitleOfCurrentPage());
		
		//scroll down
		jsutil.scrollDown();
		
		Thread.sleep(3000);
		
		//scroll up
		jsutil.scrollUp();
		
		//scroll till element
		WebElement apiRE = driver.findElement(By.xpath("//div[@data-testid='page.desktopTableOfContents']//div[@dir='auto' and .='API Response Error']"));
		jsutil.scrollTillElement(apiRE);
		
		
	}

}
