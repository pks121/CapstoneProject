package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ABTestingPage;
import pages.DropdownPage;
import pages.FramesPage;
import pages.HomePage;
import utilities.BaseClass;

public class StepDefinition extends BaseClass {

    HomePage home;
    ABTestingPage abTesting;
    DropdownPage dropdown;
    FramesPage frames;

    @Given("I am on the Home Page")
    public void i_am_on_the_home_page() {
        home = new HomePage(driver);
        driver.get("http://the-internet.herokuapp.com/");
    }

    @Given("I launch the application {string}")
    public void i_launch_the_application(String url) {
        driver = initializeDriver();
        driver.get(url);
    }

    @Then("I should see the title of the page as {string}")
    public void i_should_see_the_title_of_the_page_as(String expectedTitle) {
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    @When("I click on {string} link")
    public void i_click_on_link(String linkText) {
        home.clickOnLink(linkText);
    }

    @Then("I should see the text on the page as {string}")
    public void i_should_see_the_text_on_the_page_as(String expectedText) {
        abTesting = new ABTestingPage(driver);
        Assert.assertEquals(abTesting.getTextOnPage(), expectedText);
    }

    @And("I select {string} from the dropdown")
    public void i_select_from_the_dropdown(String option) {
        dropdown = new DropdownPage(driver);
        dropdown.selectOption(option);
    }

    @Then("{string} should be selected")
    public void should_be_selected(String expectedOption) {
        Assert.assertTrue(dropdown.isOptionSelected(expectedOption));
    }

    @Then("I should see the following hyperlinks on the Frames page:")
    public void i_should_see_the_following_hyperlinks_on_the_frames_page(io.cucumber.datatable.DataTable dataTable) {
        frames = new FramesPage(driver);
        for (String link : dataTable.asList()) {
            Assert.assertTrue(frames.isLinkPresent(link));
        }
    }

    @Then("I_quit_the_application")
    public void I_quit_the_application() {
        driver.close();
    }
}
