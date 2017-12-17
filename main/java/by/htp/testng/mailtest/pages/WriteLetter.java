package by.htp.testng.mailtest.pages;

import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WriteLetter extends AbstractPage {

	//private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "https://e.mail.ru/compose/";
	private final String ADDRESSEE = "//div[@class=\"label-input\"]/div[1]/textarea[2]";
	private final String TOPIC = "//div[@class=\"compose-head__field\"]/input[@class=\"b-input\"]";
	private final String MESSAGGE = "//div[@class='compose__editor__container']/table//td[@class='cell shell__text_cell w100']//iframe";
	private final String SUBMIT = "//div[@class=\"b-toolbar__group\"]/div[1]/div[1]/span[@class=\"b-toolbar__btn__text\"]";
	
	@FindBy(xpath = ADDRESSEE)
	private WebElement addressee;
	
	@FindBy(xpath = TOPIC)
	private WebElement topic;
	
	@FindBy(xpath = MESSAGGE)
	private WebElement inputField;

	@FindBy(xpath = SUBMIT)
	private WebElement buttonSend;
	
	public WriteLetter(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void sendLetter(String email, String topic, String message) {
		addressee.sendKeys(email);
		this.topic.sendKeys(topic);
		inputField.sendKeys(message);
		buttonSend.click();
	}
	
	@Override
	public void openPage() {
		try {
			 Thread.sleep(10000);
			 } catch (InterruptedException e) {
			 e.printStackTrace();
	}
		driver.get(BASE_URL);	
	}

}
