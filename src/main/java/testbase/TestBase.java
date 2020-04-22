package testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	// Singleton pattern
	public static WebDriver driver = null;
	
	
	public static void init() {
		if (driver == null) {
			if (Constants.browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver","C:\\Users\\itsdi\\Downloads\\selenium\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				
			}else if(Constants.browser.equalsIgnoreCase("FF")) {
				System.setProperty("webdriver.gecko.driver","C:\\Users\\itsdi\\Downloads\\selenium\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Constants.Url);
		
	}
	public static void quit() {
		System.out.println("Quiting the browser");
		driver.quit();
		driver = null;
	}
	public static void close() {
		System.out.println("Closing the browser");
		driver.close();
		driver = null;
	}

}
