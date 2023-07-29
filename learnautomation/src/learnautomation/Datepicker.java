package learnautomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Datepicker {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Xunison\\Java-Selenium\\learnautomation\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions action = new Actions(driver);
		
		driver.get("https://www.path2usa.com/travel-companion/");
		
		action.click(driver.findElement(By.id("form-field-travel_comp_date"))).build().perform();
		
	
		while(!driver.findElement(By.xpath("//div[@class='flatpickr-month'] /div/span")).getText().equalsIgnoreCase("December")) {
			
			driver.findElement(By.xpath("//div[@class='flatpickr-month'] /span[2]")).click();

		}		
		
		
		List<WebElement> alldate = driver.findElements(By.cssSelector("[class='flatpickr-day']"));
		
		
		for(int i=0;i<alldate.size();i++) {
			
			String text = alldate.get(i).getText();
			System.out.println(text);
			
			if(text.equalsIgnoreCase("19")) {
				
				action.click(alldate.get(i)).build().perform();
				break;
			}
		}
		
		
	}

}
