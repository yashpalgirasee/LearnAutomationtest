package learnautomation;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Addtocart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Xunison\\Java-Selenium\\learnautomation\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		String[] vegname = {"Cucumber","Brocolli","Beetroot","Tomato","Potato","Walnuts"};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		//Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		 List<WebElement> productname = driver.findElements(By.className("product-name"));
	
		 for(int i=0;i<productname.size();i++) {
			 
			 String [] name = productname.get(i).getText().split("-");
			 String trimeName = name[0].trim();

			 List<String> arrayvegg = Arrays.asList(vegname);
			 
			 if(arrayvegg.contains(trimeName)) {
				 
				 driver.findElements(By.xpath("//div[@class='product-action'] /button")).get(i).click();
		
			 }
			 
			
		 }
		 
		 driver.close();
		
	}

}
