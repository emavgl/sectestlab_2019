package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OwnerInfoPage extends PageObject {

	// locators
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/b[1]")
	WebElement ownerName;
	
	public OwnerInfoPage(WebDriver driver) {
		super(driver);
	}
	
	// methods
	
	public String getOwnerName() {
		return this.ownerName.getText();
	}
	
	public String getOwnerLastName() {
		String completeName = this.ownerName.getText();
		return completeName.split(" ")[1].trim();
	}
}
