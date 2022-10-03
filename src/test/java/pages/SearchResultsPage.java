package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultsPage {

    private final String HOTEL_NAME_ON_CARD_XPATH = "(//div[@data-testid='property-card'])[1]//descendant::div[text()='%s']";
    private final String hotelRateXpath = "(//div[@data-testid='property-card'])[1]//descendant::div[text()='%s']";

    public String getHotelNameOnCard(String hotel) {
        String hotelNameCardXpath = String.format(HOTEL_NAME_ON_CARD_XPATH, hotel);
        return $(By.xpath(hotelNameCardXpath)).getText();
    }

    public String getHotelScore(String score) {
        String hotelScoreXpath = String.format(hotelRateXpath, score);
        return $(By.xpath(hotelScoreXpath)).getText();
    }

}
