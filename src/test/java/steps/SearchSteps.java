package steps;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.MainPage;
import pages.SearchResultsPage;

import java.awt.*;


public class SearchSteps {

    MainPage mainPage;
    SearchResultsPage searchResultsPage;

    @Before
    public void setUp() {
        Configuration.timeout = 6000;
        Dimension size
                = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) size.getWidth();
        int height = (int) size.getHeight() - 50;
        Configuration.browserSize = String.format("%dx%d", width, height);
        mainPage = new MainPage();
        searchResultsPage = new SearchResultsPage();

    }

    @Given("Main Booking page is opened")
    public void mainBookingPageIsOpened() {
        mainPage.openMainPage();

    }


    @When("User inputs {string} to Destination field")
    public void userInputsToDestinationField(String hotel) {
        mainPage.inputHotelName(hotel);
    }

    @And("Click Search button")
    public void clickSearchButton() {
        mainPage.clickSearchButton();
    }


    @Then("{string} card is displayed on the page")
    public void cardIsDisplayedOnThePage(String hotel) {
        String hotelName = searchResultsPage.getHotelNameOnCard(hotel);
        Assert.assertEquals(hotelName, hotel);

    }

    @And("{string} score is displayed")
    public void scoreIsDisplayed(String score) {
        String scoreOnCard = searchResultsPage.getHotelScore(score);
        Assert.assertEquals(scoreOnCard, score);
    }


}
