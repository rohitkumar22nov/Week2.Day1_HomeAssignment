package week2.Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeAssignment2_DuplicateLead {

	public static void main(String[] args) {

		String url = "http://leaftaps.com/opentaps/control/login";
		String userName = "demosalesmanager";
		String password = "crmsfa";
		String pageTitle = "";
		
//		1. Launch URL "http://leaftaps.com/opentaps/control/login"
//		2. Enter UserName and Password Using Id Locator
//		3. Click on Login Button using Class Locator
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		
//		4. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
//		5. Click on Leads Button
		driver.findElement(By.linkText("Leads")).click();
		
//		6. Click on Create Lead 
		driver.findElement(By.linkText("Create Lead")).click();
		
//		7. Enter CompanyName Field Using id Locator
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("ABC Ltd.");
		
//		8. Enter FirstName Field Using id Locator
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Rohit");
		
//		9. Enter LastName Field Using id Locator
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Kumar");
		
//		10. Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("LOCAL-NAME-First");
		
//		11. Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.name("departmentName")).sendKeys("Software Testing");
		
//		12. Enter Description Field Using any Locator of your choice 
		driver.findElement(By.id("createLeadForm_description")).sendKeys("description");
		
//		13. Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("abc@gmail.com");
		
//		14. Select State/Province as NewYork Using Visible Text
		WebElement stateDropdown = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select selectDownOption = new Select(stateDropdown);
		selectDownOption.selectByVisibleText("Alabama");
		
//		15. Click on Create Button
		driver.findElement(By.className("smallSubmit")).click();
		
//		16. Get the Title of Resulting Page(refer the video)  using driver.getTitle()
		pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		
		
//		17. Click on Duplicate button
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
//		18. Clear the CompanyName Field using .clear() And Enter new CompanyName
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("NEW ABC Ltd.");
		
//		19.Clear the FirstName Field using .clear() And Enter new FirstName
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(" NEW Rohit");
		
//		20.Click on Create Lead Button
		driver.findElement(By.className("smallSubmit")).click();
		
//		21. Get the Title of Resulting Page(refer the video)  using driver.getTitle()
		pageTitle = driver.getTitle();
		System.out.println("Page Title after remvoing the duplicate entry: " + pageTitle);

	}

}
