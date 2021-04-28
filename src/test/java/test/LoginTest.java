package test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import data.DataFile;
import pages.LoginPage;
//import utilities.Xls_Reader;

import org.testng.annotations.BeforeMethod;

//import java.io.FileNotFoundException;
import java.io.IOException;

//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class LoginTest {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest extentTest;
	
  LoginPage lp = new LoginPage();
  DataFile df = new DataFile();
  
  
  
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  lp.openBrowser();
	  lp.openYahoo();
	  htmlReporter = new ExtentHtmlReporter("C://testing2//extent.html");
	  htmlReporter.config().setEncoding("utf-8");
	  htmlReporter.config().setDocumentTitle("Automation reports");
	  htmlReporter.config().setReportName("Automation test results");
	  htmlReporter.config().setTheme(Theme.STANDARD);
	  
	  extent = new ExtentReports();
	  extent.setSystemInfo("organization", "let's code it");
	  extent.setSystemInfo("Browser", "Chrome");
	  extent.attachReporter(htmlReporter);
  }

  @AfterMethod
  public void afterMethod() {
	lp.closeBrowser();
	extent.flush();
	
  }

  @Test(priority=1)
  public void loginwithWrongPasswordTest() throws InterruptedException {
	  lp.enterEmail(df.correctEmail);
	  lp.enterPassword(df.wrongPassword);
	  String expectedErr = df.passwordErr;
	  String actualErr = lp.readPasswordError();
	  Assert.assertEquals(actualErr, expectedErr);
	  extentTest = extent.createTest("Sucessful Test");
	  extentTest.log(Status.PASS, "Test method sucessful");
	
  }
  
  @Test(priority=2)
  public void loginwithWrongEmail() throws InterruptedException {
	  	lp.enterEmail(df.wrongEmail);
		String expectedErr = df.emailErr;
		String actualErr = lp.readEmailError();
		Assert.assertEquals(actualErr, expectedErr);
		
  }
}
