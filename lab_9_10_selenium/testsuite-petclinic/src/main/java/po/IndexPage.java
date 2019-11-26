package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends PageObject {
	
	// Fields with annotation (locators)

	@FindBy(xpath = "/html/body/nav/div/div[2]/ul/li[3]/a")
	WebElement findOwnerButton;
	
	public IndexPage(WebDriver driver) {
		super(driver);
	}
	
	public FindOwnerPage goToFindOwnerPage() {
		this.findOwnerButton.click();
		return new FindOwnerPage(driver);
	}

}
