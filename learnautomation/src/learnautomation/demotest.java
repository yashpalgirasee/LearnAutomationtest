package learnautomation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class demotest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String studentname = "Rohit";
		String studentemail = "rohit@demo.com";
		String password = "Demo@123";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Xunison\\Java-Selenium\\learnautomation\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.name("name")).sendKeys(studentname);
		driver.findElement(By.name("email")).sendKeys(studentemail);
		driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);
		driver.findElement(By.id("exampleCheck1")).click();
		WebElement optionss = driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']"));
		Select option = new Select(optionss);
		option.selectByIndex(1);
		driver.findElement(By.id("inlineRadio1")).click();
		
		// Select Birthdate
		driver.findElement(By.xpath("//input[@type='date']")).sendKeys("05111989");
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		String successtext = driver.findElement(By.className("alert-dismissible")).getText();
		String textsuccess = "Success! The Form has been submitted successfully!.";
		// System.out.println(successtext);
		
		if(successtext.contains(textsuccess)) {
			
			System.out.println("Form Submitted Successfully");
		}
		else {
			System.out.println("Form Not Submitted Successfully");
		}
		
		driver.close();
	}

}
