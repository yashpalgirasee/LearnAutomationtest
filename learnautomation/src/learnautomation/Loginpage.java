package learnautomation;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Loginpage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Xunison\\\\Java-Selenium\\\\DemoProject\\\\chromedriver_win32 (2)\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String[] mobs = {"iphone X","Blackberry","Nokia Edge","Samsung Note 8"};
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		
		driver.findElement(By.xpath("//div[@class='form-check-inline'] /label[2]/span[2]")).click();
		driver.findElement(By.id("okayBtn")).click();
		
		Select option = new Select(driver.findElement(By.xpath("//select[@class='form-control']")));
		option.selectByIndex(2);
		
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		
		List<WebElement> mobilenames = driver.findElements(By.xpath("//app-card/div/div[1]/h4"));
		
		for(int i=0;i<mobilenames.size();i++) {
			
			String mobtext = mobilenames.get(i).getText();
			
			List<String> al = Arrays.asList(mobs);
			if(al.contains(mobtext)) {
				
				driver.findElements(By.xpath("//app-card/div/div[2]/button")).get(i).click();
			}
		}
		
		driver.close();

	}
}
