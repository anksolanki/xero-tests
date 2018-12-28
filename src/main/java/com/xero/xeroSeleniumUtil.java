package com.xero;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class xeroSeleniumUtil {

	public String username = "";
	public String password = "";

	public void Login(WebDriver driver){

		//Click on Login
		WebElement click = driver.findElement(By.xpath("//a[@class='btn btn-tertiary-alt global-ceiling-bar-btn']"));
		click.click();

		//verify email textbox
		WebElement email = driver.findElement(By.id("email"));
		email.clear();
		email.sendKeys(username);

		//verify password textbox
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.clear();
		pwd.sendKeys(password);

		//Submit button
		WebElement submit_Button = driver.findElement(By.id("submitButton"));
		submit_Button.click();
	}

	public void verifyLandedOnCorrectUrl(WebDriver driver){

		//verify correct URL is loaded
		String correctUrl = "https://my.xero.com/!xkcD/Organisation/Setup";
		driver.get(correctUrl);
		Assert.assertEquals(correctUrl, driver.getCurrentUrl());
		System.out.println("Landed on correct page");
	}

	public void addOrganizationPageFields(WebDriver driver) throws InterruptedException {

		Random rand = new Random();

		//Add name of organization
		WebElement org_Name = driver.findElement(By.name("OrganisationName"));
		org_Name.clear();
		//org_Name.sendKeys("Blossom Real Estate Test");
		org_Name.sendKeys("Blossom Real Estate Test" + rand.nextInt(1000000) + 1);

		//Add Organization
		WebElement org = driver.findElement(By.id("industrysearchcombofield-1025-inputEl"));
		org.clear();
		org.sendKeys("Real Estate Broker");
		org.sendKeys(Keys.TAB);

		//Previous Accounting Software field selection
		WebElement dropPrevSoftware  = driver.findElement(By.id("combo-1029-inputEl"));
		dropPrevSoftware.click();
		dropPrevSoftware = driver.findElement(By.xpath("//*[@id='combo-1029-boundlist-listEl']/ul/li[10]"));
		dropPrevSoftware.click();
		Thread.sleep(5000);

		//Start Trial Button
		WebElement clickStartTrialButton  = driver.findElement(By.id("simplebutton-1035"));
		clickStartTrialButton.click();
		Thread.sleep(5000);

	}

	public void addAccountButton(WebDriver driver){

		//Add Account Button
		WebElement addBankAccount = driver.findElement(By.xpath("//*[@id='root']/div/div/div[1]/div[1]/div[2]/div/div/div[1]/div/a"));
		addBankAccount.click();

	}

	public void searchAnzBankName(WebDriver driver){

		//Type Bank Name
		WebElement bank_Name = driver.findElement(By.xpath("//*[@id='xui-searchfield-1018-inputEl']"));
		bank_Name.clear();
		bank_Name.sendKeys("ANZ (NZ)");
		bank_Name.sendKeys(Keys.ENTER);

		//çlick on show result
		WebElement showResult = driver.findElement(By.xpath("//*[@id='component-1027']/a"));
		showResult.click();

		//çlick on account name
		WebElement click_Act_Name = driver.findElement(By.xpath("//*[@id='dataview-1025']/li"));
		click_Act_Name.click();

	}

	public void fillAccountDetails(WebDriver driver) throws InterruptedException{

		//Enter Account Name
		WebElement account_Name = driver.findElement(By.xpath("//*[@id='accountname-1037-inputEl']"));
		account_Name.clear();
		account_Name.sendKeys("Business Account");
		account_Name.sendKeys(Keys.TAB);

		//Select Account Type
		WebElement acct_Type  = driver.findElement(By.xpath("//*[@id='accounttype-1039-inputEl']"));
		acct_Type.click();
		acct_Type = driver.findElement(By.xpath("//*[@id='boundlist-1076']/div[@id='boundlist-1076-listWrap']/ul[@id='boundlist-1076-listEl']/li[@class='ba-combo-list-item'][5]"));
		acct_Type.click();

		// Add Account Number
		WebElement account_No = driver.findElement(By.xpath("//*[@id='accountnumber-1068-inputEl']"));
		account_No.clear();
		account_No.sendKeys("123123123"); 

		//Click Continue button
		WebElement cont_button  = driver.findElement(By.xpath("//*[@id='common-button-submit-1015-btnInnerEl']"));
		cont_button.click();
		Thread.sleep(5000);

	}

	public void verifyBankAccountAdded(WebDriver driver){

		System.out.println(driver.findElement(By.xpath("//*[@id='notify01']")).getText());
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='notify01']")).getText().contains("Business Account added"));

	}

	public void deleteOrganization(WebDriver driver){

		//Delete Organization
		driver.findElement(By.xpath("//*[@id='header']/header/div/ol[2]/li[5]/button/div/abbr")).click();
		driver.findElement(By.linkText("Account")).click();
		driver.findElement(By.linkText("Home")).click();
		driver.findElement(By.linkText("Cancel")).click();
		driver.findElement(By.id("button-1043-btnInnerEl")).click();
		driver.findElement(By.id("radio-1055-boxLabelEl")).click();
		driver.findElement(By.id("button-1060-btnInnerEl")).click();

	}

	public void emptyAccountName(WebDriver driver){

		//Empty Account Name
		WebElement account_Name = driver.findElement(By.xpath("//*[@id='accountname-1037-inputEl']"));
		account_Name.clear();

		//Select Account Type
		WebElement acct_Type  = driver.findElement(By.xpath("//*[@id='accounttype-1039-inputEl']"));
		acct_Type.click();
		acct_Type = driver.findElement(By.xpath("//*[@id='boundlist-1076']/div[@id='boundlist-1076-listWrap']/ul[@id='boundlist-1076-listEl']/li[@class='ba-combo-list-item'][5]"));
		acct_Type.click();

		// Add Account Number
		WebElement account_No = driver.findElement(By.xpath("//*[@id='accountnumber-1068-inputEl']"));
		account_No.clear();
		account_No.sendKeys("123123123"); 

		//Click Continue button
		driver.findElement(By.xpath("//*[@id='common-button-submit-1015-btnInnerEl']")).click();

	}

	public void verifyAccountNameErrorMessage(WebDriver driver){

		String actualaccountnameerrormessage;
		String expectedaccountnameerrormessage = "Account Name required";
		actualaccountnameerrormessage = driver.findElement(By.xpath("//*[@id='accountname-1037-errorWrapEl']/div[@id='accountname-1037-errorEl']")).getText();
		Assert.assertEquals(actualaccountnameerrormessage, expectedaccountnameerrormessage);
		System.out.println("Account Name Error message is displayed");

	}

	public void emptyAccountType(WebDriver driver){

		//Enter Account Name
		WebElement account_Name = driver.findElement(By.xpath("//*[@id='accountname-1037-inputEl']"));
		account_Name.clear();
		account_Name.sendKeys("Business Account");
		account_Name.sendKeys(Keys.TAB);

		//Empty Account Type
		WebElement acct_Type  = driver.findElement(By.xpath("//*[@id='accounttype-1039-inputEl']"));
		acct_Type.click();

		//Click Continue button
		driver.findElement(By.xpath("//*[@id='common-button-submit-1015-btnInnerEl']")).click();

	}
	public void verifyAccountTypeErrorMessage(WebDriver driver){

		String actualaccounttypeerrormessage;
		String expectedaccounttypeerrormessage = "Account Type required";
		actualaccounttypeerrormessage = driver.findElement(By.xpath("//*[@id='accounttype-1039-errorWrapEl']/div[@id='accounttype-1039-errorEl']")).getText();
		Assert.assertEquals(actualaccounttypeerrormessage, expectedaccounttypeerrormessage);
		System.out.println("Account Type Error message is displayed");
	}

	public void emptyAccountNumber(WebDriver driver){

		//Enter Account Name
		WebElement account_Name = driver.findElement(By.xpath("//*[@id='accountname-1037-inputEl']"));
		account_Name.clear();
		account_Name.sendKeys("Business Account");
		account_Name.sendKeys(Keys.TAB);

		//Select Account Type
		WebElement acct_Type  = driver.findElement(By.xpath("//*[@id='accounttype-1039-inputEl']"));
		acct_Type.click();
		acct_Type = driver.findElement(By.xpath("//*[@id='boundlist-1076']/div[@id='boundlist-1076-listWrap']/ul[@id='boundlist-1076-listEl']/li[@class='ba-combo-list-item'][5]"));
		acct_Type.click();

		// Empty Account Number
		WebElement account_No = driver.findElement(By.xpath("//*[@id='accountnumber-1068-inputEl']"));
		account_No.clear();

		//Click Continue button
		driver.findElement(By.xpath("//*[@id='common-button-submit-1015-btnInnerEl']")).click();

	}

	public void verifyAccountNumberErrorMessage(WebDriver driver){

		String actualaccountnumbererrormessage;
		String expectedaccountnumbererrormessage = "Account Number required";
		actualaccountnumbererrormessage = driver.findElement(By.xpath("//*[@id='accountnumber-1068']/div[@id='accountnumber-1068-errorWrapEl']/div[@id='accountnumber-1068-errorEl']")).getText();
		Assert.assertEquals(actualaccountnumbererrormessage, expectedaccountnumbererrormessage);
		System.out.println("Account Number Error message is displayed");
	}
}
