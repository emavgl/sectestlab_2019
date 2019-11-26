package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.BaseTest;

public class TestFindExistingOwner extends BaseTest {

	
	@Test
	public void testFindExistingOwner() {

		// TODO LIST:
		// 1. Go to the webpage
		// 2. Click on "Find Owners"
		// 3. Insert owner's last name "Black"
		// 4. Click on "Find Owner"
		// 5. Assert that "Black" is the last name
		
		// 1. Go to webpage
		driver.get(URL);
		
		// 2. Click on "Find Owners"
		WebElement button = driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[3]/a"));
		
		// but also ...
		// .nav > li:nth-child(3) > a:nth-child(1) CSS Selector
		// //li[3]//a[1] (REL XPATH)
		button = driver.findElement(By.cssSelector("a[title='find owners']")); // ROBUST CSS
		button = driver.findElement(By.xpath("//a[@title='find owners']")); // ROBUST XPATH
		button.click();

		// 3. Insert owner's last name "Black"
		WebElement textBox = driver.findElement(By.id("lastName"));
		textBox.sendKeys("Black");
		
		// 4. Click on "Find Owner"
		WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
		submitButton.click();
		
		WebElement nameField = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/b[1]"));
		String completeName = nameField.getText();
		String surname = completeName.split(" ")[1].trim();
		
		// 5. Assert that "Black" is the last name
		String expectedSurname = "Black";
		String actualSurname = surname;
		
		assertEquals(expectedSurname, actualSurname);
	}
		
	
}
