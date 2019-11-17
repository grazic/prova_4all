package support;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

public class Connect {

	public WebDriver openChrome() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\GRAZI\\Downloads\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://shopcart-challenge.4all.com/");
		return driver;

	}
}
