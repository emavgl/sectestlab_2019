package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import po.FindOwnerPage;
import po.IndexPage;
import po.OwnerInfoPage;
import utils.BaseTest;

public class TestFindExistingOwnerPOO extends BaseTest {

	
	@Test
	public void testFindExistingOwner() {

		// 1. Go to the webpage
		// 2. Click on "Find Owners"
		// 3. Insert owner's last name "Black"
		// 4. Click on "Find Owner"
		// 5. Assert that "Black" is the last name
		
		IndexPage indexPage = new IndexPage(driver);
		FindOwnerPage findOwnerPage = indexPage.goToFindOwnerPage();
		OwnerInfoPage ownerInfoPage = findOwnerPage.searchOwner("Black");
		
		String actualOwnerLastName = ownerInfoPage.getOwnerLastName();
		String expectedOwnerLastName = "Black";
		
		assertEquals(expectedOwnerLastName, actualOwnerLastName);
	}
		
	
}
