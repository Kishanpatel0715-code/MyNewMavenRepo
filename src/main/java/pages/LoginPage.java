package pages;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
//import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

	WebDriver driver;

	/*
	 * public WebElement email = driver.findElement(By.name("username")); public
	 * WebElement emailNext = driver.findElement(By.name("signin")); public
	 * WebElement password = driver.findElement(By.name("password")); public
	 * WebElement passwordNext = driver.findElement(By.id("login-signin")); public
	 * WebElement passwordError = driver.findElement(By.className("error-msg"));
	 * public WebElement emailError = driver.findElement(By.className("error-msg"));
	 */
	
	@FindBy(id = "login-username")
    public static WebElement email;
	
	@FindBy(name = "password")
    public static WebElement password;
	
	@FindBy(id = "login-signin")
    public static WebElement emailNext;
	
	@FindBy(name = "verifyPassword")
    public static WebElement passwordNext;
	
	@FindBy(className = "error-msg")
    public static WebElement passwordError;
	
	@FindBy(id = "username-error")
    public static WebElement emailError;

	public void openBrowser() throws IOException {
		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "C:\\Seleniumjars\\geckodriver.exe"); driver = new FirefoxDriver();
		 */
		FileInputStream f = new FileInputStream("C:\\testing\\prop.properties");
		Properties prop = new Properties();
		prop.load(f);
		
		String browser = prop.getProperty("browser");
		
		
		if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Seleniumjars\\chromedriver.exe");
			 driver = new ChromeDriver();
		}else if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Seleniumjars\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else {
			System.setProperty("webdriver.gecko.driver", "C:\\Seleniumjars\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		PageFactory.initElements(driver, this);

	}
	
	public void openYahoo() {
		 driver.get("https://login.yahoo.com/?.src=ym&.partner=none&.lang=en-CA&.intl=ca&pspid=2142623533&activity=uh-mail&.done=https%3A%2F%2Fmail.yahoo.com%2Fd%3F.intl%3Dca%26.lang%3Den-CA%26.partner%3Dnone%26.src%3Dfp%26activity%3Duh-mail%26pspid%3D2142623533");
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void closeBrowser() {
		driver.quit();
	}
	
	public void enterEmail(String a) throws InterruptedException {
		email.sendKeys(a);
		emailNext.click();
		Thread.sleep(3000);
	}
	
	public void enterPassword(String b) throws InterruptedException {
		password.sendKeys(b);
		passwordNext.click();
		 Thread.sleep(3000);
	}
	
	public String readPasswordError() {
		 String actualErr = passwordError.getText();
		 System.out.println(actualErr);
		 return actualErr;
	}
	
	public String readEmailError() {
		String actualErr = emailError.getText();
		System.out.println(actualErr);
		return actualErr;
	}
	
	

}
