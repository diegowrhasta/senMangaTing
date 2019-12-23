package senMangaDownloader;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.KeyDownAction;

public class MainClass{
	public static WebDriver driver = null;
	public static void main(String args[]) throws InterruptedException, AWTException{
			System.setProperty("webdriver.chrome.driver", "C:\\dude\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.setHeadless(true);
			options.addArguments("--window-size=1920,1080");
			options.addArguments("--disable-extensions");
			options.setExperimentalOption("useAutomationExtension", false);
			options.addArguments("--proxy-server='direct://'");
			options.addArguments("--proxy-bypass-list=*");
			options.addArguments("-start-maximized");
			options.addArguments("--headless");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			for(int i=1;i<=10;i++) {
				driver.navigate().to("https://raw.senmanga.com/viewer/S-to-M/VOLUME_001/"+i);
				TimeUnit.SECONDS.sleep(2);
				Robot robot = new Robot();
			      robot.keyPress(KeyEvent.VK_CONTROL);
			      robot.keyPress(KeyEvent.VK_S);
			      robot.keyRelease(KeyEvent.VK_S);
			      robot.keyRelease(KeyEvent.VK_CONTROL);
			      TimeUnit.SECONDS.sleep(2);
			      robot.keyPress(KeyEvent.VK_TAB);
			      robot.keyPress(KeyEvent.VK_TAB);
			      robot.keyPress(KeyEvent.VK_TAB);
			      robot.keyPress(KeyEvent.VK_ENTER);
			      System.out.println("Image "+i+" done.");
			}
			TimeUnit.SECONDS.sleep(1);
		    driver.quit();
	}
}
