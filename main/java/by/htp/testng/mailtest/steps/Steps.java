package by.htp.testng.mailtest.steps;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;

import by.htp.testng.mailtest.driver.DriverSingleton;
import by.htp.testng.mailtest.pages.IncomeLetters;
import by.htp.testng.mailtest.pages.MainPage;
import by.htp.testng.mailtest.pages.WriteLetter;

public class Steps {

	private WebDriver driver;

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public void loginMailRu(String username, String password) {
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		mainPage.logIn(username, password);
	}

	public boolean isLoggedIn(String username) {
		MainPage mainPage = new MainPage(driver);
		String actualUsername = mainPage.getLoggedInUserName().trim().toLowerCase();
		return actualUsername.equals(username);
	}

//	public void incomeClick() {
//		IncomeLetters incomeLetters = new IncomeLetters(driver);
//		incomeLetters.openPage();
//		incomeLetters.writeLetterClick();
//	}

	public void sendLetter(String email, String topic, String message) {
		WriteLetter writeLetter = new WriteLetter(driver);
		writeLetter.openPage();
		writeLetter.sendLetter(email, topic, message);
	}
}
