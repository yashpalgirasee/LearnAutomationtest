package learnautomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Xunison\\Java-Selenium\\learnautomation\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.xpath("//div[@id='checkbox-example'] /fieldset/label[2]/input")).click();
		String selectedoption = driver.findElement(By.xpath("//div[@id='checkbox-example'] /fieldset/label[2]")).getText();
		
		WebElement select = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		Select option = new Select(select);
		option.selectByVisibleText(selectedoption);
		
		driver.findElement(By.id("name")).sendKeys(selectedoption);
		
		driver.findElement(By.id("alertbtn")).click();
		String alertname = driver.switchTo().alert().getText();
		
		if(alertname.contains(selectedoption)) {
			
			System.out.println("Option2 is found");
		}
		else {
			
			System.out.println("OPtion2 not found");
		}
		
			
	}

}
