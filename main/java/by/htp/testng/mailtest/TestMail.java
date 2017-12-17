package by.htp.testng.mailtest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.testng.mailtest.steps.Steps;

public class TestMail 
{
	private Steps steps;
	
	private final String LOGIN = "tathtp";
	private final String PASSWORD = "Klopik123";
	
	private final String RECEIVER = "alenka4679@list.ru";
	private final String TOPIC = "Klopik123";
	private final String MESSAGE= "Добрый день! Высылаю ссылку на GitHub: https://github.com/fominaalena -- Фомина Алёна.";

	@BeforeMethod(description = "Init browser")
	public void setUp()
	{
		steps = new Steps();
		steps.initBrowser();
	}

//	@Test(description = "Login to MailRu")
//	public void oneCanLoginMailRu()
//	{
//		steps.loginMailRu(LOGIN, PASSWORD);
//		Assert.assertTrue(steps.isLoggedIn(LOGIN));
//	}

	@Test(description = "Send Letter")
	public void OneCanSendLetter()
	{
		steps.loginMailRu(LOGIN, PASSWORD);
		steps.sendLetter(RECEIVER, TOPIC, MESSAGE);
	}
	
	@AfterMethod(description = "Stop Browser")
	public void stopBrowser()
	{
		steps.closeDriver();
}
}
