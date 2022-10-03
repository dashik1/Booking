package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import constants.Urls;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {


    private SelenideElement destinationInput = $(By.xpath("//input[@name='ss']"));
    private SelenideElement searchButton = $(By.xpath("//button[@type='submit']"));
    private SelenideElement autocomplete = $(By.xpath("//div[@data-testid='autocomplete-result']"));

    public void openMainPage() {
        open(Urls.MAIN_PAGE_URL);
    }

    public void inputHotelName(String hotel) {
        destinationInput.sendKeys(hotel);
        autocomplete.shouldBe(Condition.enabled, Duration.ofSeconds(20));


    }

    public SearchResultsPage clickSearchButton() {
        searchButton.click();
        return new SearchResultsPage();
    }
}
