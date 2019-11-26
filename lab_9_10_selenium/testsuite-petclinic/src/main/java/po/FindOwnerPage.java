package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FindOwnerPage extends PageObject {

	// Locators
	
	@FindBy(how = How.ID, using = "lastName")
	WebElement searchOwnerTextBox;
	
	@FindBy(xpath = "//button[@class='btn btn-default']")
	WebElement submitButton;
	
	public FindOwnerPage(WebDriver driver) {
		super(driver);
	}
	
	public OwnerInfoPage searchOwner(String ownerName) {
		this.searchOwnerTextBox.sendKeys(ownerName);
		this.submitButton.click();
		return new OwnerInfoPage(driver);
	}
	
}
