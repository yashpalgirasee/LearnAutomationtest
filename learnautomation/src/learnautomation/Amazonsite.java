package learnautomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Amazonsite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Xunison\\Java-Selenium\\learnautomation\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//String devicename = "sony mobile";
		
		driver.findElement(By.xpath("//div[@class='_2QfC02'] /button")).click();
		
		
		driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("sony");		
		List<WebElement> suggetions = driver.findElements(By.xpath("//li[@class='Y5N33s']"));
		
		for(WebElement suggetion : suggetions) {
			
			System.out.println(suggetion.getText());
			
			if(suggetion.getText().contains("laptop bag")) {
				
				suggetion.click();
				break;
			}
		}
			
		
	}

}
