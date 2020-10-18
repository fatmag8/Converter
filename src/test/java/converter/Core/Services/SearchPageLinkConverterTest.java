package converter.Core.Services;

import converter.Domain.DeepLinkDto;
import converter.Domain.WebUrlDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
class SearchPageLinkConverterTest {

    @Test
    void webUrlToDeeplink() {
        String test = "https://www.trendyol.com/tum-urunler?q=elbise";
        String test2 = "https://www.trendyol.com/tum-urunler?q=%C3%BCt%C3%BC";
        String expected = "ty://?Page=Search&Query=elbise";
        String expected2 ="ty://?Page=Search&Query=%C3%BCt%C3%BC";
        SearchPageLinkConverter searchPageLinkConverter = new SearchPageLinkConverter();
        assertEquals(expected,searchPageLinkConverter.WebUrlToDeeplink(new WebUrlDto(test)).getDeepLink());
        assertEquals(expected2,searchPageLinkConverter.WebUrlToDeeplink(new WebUrlDto(test2)).getDeepLink());
    }

    @Test
    void deeplinkToWebUrl() {
        String test ="ty://?Page=Search&Query=elbise";
        String expected ="https://www.trendyol.com/tum-urunler?q=elbise";
        String expected2 ="https://www.trendyol.com/tum-urunler?q=%C3%BCt%C3%BC";
        String test2 ="ty://?Page=Search&Query=%C3%BCt%C3%BC";
        SearchPageLinkConverter searchPageLinkConverter = new SearchPageLinkConverter();
        assertEquals(expected,searchPageLinkConverter.DeeplinkToWebUrl(new DeepLinkDto(test)).getWebUrl());
        assertEquals(expected2,searchPageLinkConverter.DeeplinkToWebUrl(new DeepLinkDto(test2)).getWebUrl());


    }
}