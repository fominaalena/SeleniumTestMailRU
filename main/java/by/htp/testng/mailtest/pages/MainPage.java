package by.htp.testng.mailtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage{

	private final String BASE_URL = "https://mail.ru/";
	private final String LOGIN = "//div[@id=\"mailbox:loginContainer\"]/input[@id=\"mailbox:login\"]";
	private final String PASSWORD = "//div[@class=\"mailbox__input__container\"]/input[@id=\"mailbox:password\"]";
	private final String BUTTON = "//label[@id=\"mailbox:submit\"]/input[@class=\"o-control\"]";
			
	@FindBy(xpath = LOGIN)
	private WebElement textBoxLogin;
	
	@FindBy(xpath = PASSWORD)
	private WebElement textBoxPassword;
	
	@FindBy(xpath = BUTTON)
	private WebElement loginButton;
	
	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public void logIn(String login, String password) {
		textBoxLogin.sendKeys(login);
		textBoxPassword.sendKeys(password);
		loginButton.click();
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);	
	}
	
	public String getLoggedInUserName()
	{
		return textBoxLogin.getAttribute("content");
	}

}
