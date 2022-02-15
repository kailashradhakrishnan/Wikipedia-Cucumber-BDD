package stepdefinition_files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.Utils.Base;

import PageObjects.Wiki_HelpPage;
import PageObjects.Wiki_SearchPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Wiki_Search extends Base {
	
	@Before	
	public void launch_url() {
		Base.initialization();
	}
	
	@After(order = 0)
	public void teardown() {
		driver.quit();
	}
	
	@After(order = 1)
	public static void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}

	// Scenario Outline: Validate Search Results

	@Then("Validate the launched Search Page")
	public void validate_the_launched_search_page() {
		Wiki_SearchPage.validateSearchPage();
	}

	@And("Enter {string} in the search bar")
	public void enter_in_the_search_bar(String string) {
		Wiki_SearchPage.enterSearchCriteria(string);
	}

	@And("Click on Search")
	public void click_on_search() {
		Wiki_SearchPage.clickSearch();
	}

	@Then("Validate the Search Results {string}")
	public void validate_the_search_results(String string) {
		Wiki_SearchPage.validateSearchResult(string);

	}

	// Scenario Outline: Validate Suggestions from Search bar by using one or two
	// letters

	@Given("Enter {string} by using two or three letters in the search bar")
	public void enter_by_using_two_or_three_letters_in_the_search_bar(String letters) {
		Wiki_SearchPage.enterletters(letters);
	}

	@And("Select results from dropdown {string}")
	public void select_results_from_dropdown(String suggestions) {
		Wiki_SearchPage.selectSuggestions(suggestions);
	}

	@Then("Validate the Selected Results {string}")
	public void validate_the_selected_results(String title) {
		Wiki_SearchPage.validateSelectedResult(title);

	}

	// Scenario: Validate Help link is opening in a new window

	@Given("Click on Help link")
	public void click_on_help_link() {
		Wiki_SearchPage.clickOnHelp();
	}

	@Then("Navigate to new window and validate the page tile")
	public void navigate_to_new_window_and_validate_the_page_tile() {
		Wiki_HelpPage.navigateToHelpPage();
	}

}
