package converter.Core.Services;

import converter.Domain.DeepLinkDto;
import converter.Domain.WebUrlDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
class HomePageLinkConverterTest {



    @Test
    void webUrlToDeeplink() {
        String test = "https://www.trendyol.com/butik/liste/erkek";
        String expected = "ty://?Page=Home&SectionId=2";
        HomePageLinkConverter homePageLinkConverter = new HomePageLinkConverter();
        assertEquals(expected,homePageLinkConverter.WebUrlToDeeplink(new WebUrlDto(test)).getDeepLink());
    }

    @Test
    void deeplinkToWebUrl() {
        String expected= "https://www.trendyol.com/butik/liste/kadin";
        String test = "ty://?Page=Home&SectionId=1";
        HomePageLinkConverter homePageLinkConverter = new HomePageLinkConverter();
        assertEquals(expected,homePageLinkConverter.DeeplinkToWebUrl(new DeepLinkDto(test)).getWebUrl());

    }
}