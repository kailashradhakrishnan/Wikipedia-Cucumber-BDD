package PageObjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utils.Base;

public class Wiki_SearchPage extends Base {

	public static void validateSearchPage() {

		String pageTitle = driver.findElement(By.id("firstHeading")).getText();
		Assert.assertEquals("Search", pageTitle);
	}

	public static void enterSearchCriteria(String string) {

		driver.findElement(By.name("search")).sendKeys(string);
	}

	public static void clickSearch() {

		driver.findElement(By.xpath("//*[@id='mw-search-top-table']//div//button")).click();
	}

	public static void validateSearchResult(String string) {

		String result = driver.findElement(By.linkText(string)).getText();
		Assert.assertEquals(string, result);
	}

	public static void enterletters(String letters) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.findElement(By.id("searchInput")).sendKeys(letters);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("searchInput")));
		driver.findElement(By.id("searchInput")).sendKeys(Keys.ARROW_DOWN);
	}

	public static void selectSuggestions(String Suggestions) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[6]/div/a")));

		List<WebElement> list = driver.findElements(By.xpath("/html/body/div[6]/div/a"));

		System.out.println("Auto Suggest List ::" + list.size());

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());

			if (list.get(i).getText().equals(Suggestions)) {
				list.get(i).click();
				break;

			}
		}
	}
	
	public static void validateSelectedResult(String Suggestions) {
		
		String title = driver.findElement(By.id("firstHeading")).getText();
		Assert.assertEquals(Suggestions, title);
	}
	
	public static void clickOnHelp() {
		
		driver.findElement(By.linkText("Help")).click();
	}
}
