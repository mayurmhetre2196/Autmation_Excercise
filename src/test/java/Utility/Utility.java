package Utility;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utility {
	WebDriver driver;
	TakesScreenshot ts;

	public Utility(WebDriver driver) {
		this.driver = driver;
	}

	public static String date() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = currentDateTime.format(formatter);
		return formattedDateTime;

	}

	public void pageTakesScreenShot(String name) {
		ts = (TakesScreenshot) driver;
		File fs = ts.getScreenshotAs(OutputType.FILE);
		File ns = new File(System.getProperty("user.dir")+"\\Screenshot\\"+name+".png");
		fs.renameTo(ns);
	}

	public void webElementTakesScreenShot(WebElement wb) {
		ts = (TakesScreenshot) driver;
		File fs = wb.getScreenshotAs(OutputType.FILE);
		File ns = new File(System.getProperty("user.dir") + "\\Screenshot\\cartsymbol.png");
		fs.renameTo(ns);
	}

}
