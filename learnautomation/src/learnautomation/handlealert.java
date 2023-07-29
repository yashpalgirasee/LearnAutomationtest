package learnautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class handlealert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Xunison\\Java-Selenium\\learnautomation\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		String nametext = "Yashpal";
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys(nametext);
		driver.findElement(By.id("alertbtn")).click();
		
		// how to handle alerts
		
		driver.switchTo().alert().accept(); // Ok / Yes
		driver.findElement(By.id("confirmbtn")).click();
		driver.switchTo().alert().dismiss(); // cancel / No
		
		driver.close();

	}

}
