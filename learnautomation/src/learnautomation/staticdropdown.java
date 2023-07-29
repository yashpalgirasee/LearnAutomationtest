package learnautomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class staticdropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Xunison\\Java-Selenium\\learnautomation\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		// static dropdwon syntax // select currency
		WebElement dropdownvar = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown =new Select(dropdownvar);
		dropdown.selectByIndex(3);
		Thread.sleep(2000);
		dropdown.selectByVisibleText("AED");
		Thread.sleep(1000);
		
		// Select passenger type & count dropdown
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("divpaxinfo")).click(); 
		
		for(int i=1;i<5;i++) {
			
			driver.findElement(By.id("hrefIncAdt")).click(); //adult
		}	
		
		for(int i=0;i<3;i++) {
			
			driver.findElement(By.id("hrefIncChd")).click(); // child
			
		}

		driver.findElement(By.id("btnclosepaxoption")).click(); // done button
		Thread.sleep(1000);
	
		
		// Select City From - To 
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BOM']")).click(); // select Departure City
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//a[@value='TCR'])[2]")).click(); // Select Arrival City
		
		// or use below - both are same , we just use parent+child xpath intead of use index
		// driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='TCR']")).click(); // Select Arrival City
		Thread.sleep(2000);
		
		
		// Select Country autosuggest dropdown
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(2000);
		
		List<WebElement> alloptions = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		 
		 for(WebElement option : alloptions) {
			 
			 if(option.getText().equalsIgnoreCase("India"))
			 {
				 option.click();
				 break;
			 }
		 }
		 
		 // Select Check box
		 driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_StudentDiscount']")).click();
		//driver.close();
		
	}

}
