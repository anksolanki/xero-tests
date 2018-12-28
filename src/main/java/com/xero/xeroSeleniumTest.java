package com.xero;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class xeroSeleniumTest {

	private WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "/Users/Ankita/Downloads/chromedriver");

		driver = new ChromeDriver(); 

		String baseUrl = "https://www.xero.com/nz/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(baseUrl);

	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		driver.quit();
	}

	@Test
	public void addAccountPositiveTest() throws InterruptedException {

		xeroSeleniumUtil xeroUtil = new xeroSeleniumUtil();
		xeroUtil.Login(driver);
		xeroUtil.verifyLandedOnCorrectUrl(driver);
		xeroUtil.addOrganizationPageFields(driver);
		xeroUtil.addAccountButton(driver);
		xeroUtil.searchAnzBankName(driver);
		xeroUtil.fillAccountDetails(driver);
		xeroUtil.verifyBankAccountAdded(driver);
		xeroUtil.deleteOrganization(driver);

	}

	@Test
	public void addAccountEmptyAccountName() throws InterruptedException {

		xeroSeleniumUtil xeroUtil = new xeroSeleniumUtil();
		xeroUtil.Login(driver);
		xeroUtil.verifyLandedOnCorrectUrl(driver);
		xeroUtil.addOrganizationPageFields(driver);
		xeroUtil.addAccountButton(driver);
		xeroUtil.searchAnzBankName(driver);
		xeroUtil.emptyAccountName(driver);
		xeroUtil.verifyAccountNameErrorMessage(driver);
		xeroUtil.deleteOrganization(driver);

	}

	@Test
	public void addAccountEmptyAccountType() throws InterruptedException {

		xeroSeleniumUtil xeroUtil = new xeroSeleniumUtil();
		xeroUtil.Login(driver);
		xeroUtil.verifyLandedOnCorrectUrl(driver);
		xeroUtil.addOrganizationPageFields(driver);
		xeroUtil.addAccountButton(driver);
		xeroUtil.searchAnzBankName(driver);
		xeroUtil.emptyAccountType(driver);
		xeroUtil.verifyAccountTypeErrorMessage(driver);
		xeroUtil.deleteOrganization(driver);

	}

	@Test
	public void addAccountEmptyAccountNumber() throws InterruptedException {

		xeroSeleniumUtil xeroUtil = new xeroSeleniumUtil();
		xeroUtil.Login(driver);
		xeroUtil.verifyLandedOnCorrectUrl(driver);
		xeroUtil.addOrganizationPageFields(driver);
		xeroUtil.addAccountButton(driver);
		xeroUtil.searchAnzBankName(driver);
		xeroUtil.emptyAccountNumber(driver);
		xeroUtil.verifyAccountNumberErrorMessage(driver);
		xeroUtil.deleteOrganization(driver);	

	}
}
