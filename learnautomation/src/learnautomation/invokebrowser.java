package learnautomation;
import java.time.Duration; 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;


public class invokebrowser {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Xunison\\Java-Selenium\\learnautomation\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://xunisontest.web.app");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// driver.findElement(By.linkText("Forgot password?")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Your Email Address\"]")).sendKeys("yashpal@xunison.com");
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Your Password\"]")).sendKeys("Yashpal123");
		driver.findElement(By.className("mat-button-wrapper")).click();
		//driver.close();
		driver.findElement(By.xpath("//*[text()=\"xu_wifi_16cd\"]")).click();		
		Thread.sleep(2000);
		Assert.assertEquals(driver.getCurrentUrl() , "https://xunisontest.web.app/select-mode");
		driver.findElement(By.xpath("//div[@class=\"slick-list draggable\"]/div/div[2]")).click();
		Thread.sleep(1000);
		// driver.findElement(By.xpath("//div/span[text()=\"Settings\"]")).click();
		driver.close();
	}

}
