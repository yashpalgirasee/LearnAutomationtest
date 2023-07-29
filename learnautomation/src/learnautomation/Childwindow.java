package learnautomation;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Childwindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Xunison\\Java-Selenium\\learnautomation\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://the-internet.herokuapp.com/windows");
		
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> it = windows.iterator();
		String parentwindow = it.next();
		String childwindow = it.next();
		
		driver.switchTo().window(childwindow);
		System.out.println(driver.findElement(By.xpath("//div/h3")).getText()); 
		
		driver.switchTo().window(parentwindow);
		System.out.println(driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText().split("a")[1].trim());
		
	}

}
