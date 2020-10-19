package converter.Core.Services;

import converter.Domain.WebUrlDto;
import converter.ConverterApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ConverterApplication.class)
class GeneralLinkConverterTest {

    @Autowired

    public GeneralLinkConverter generalLinkConverter;
    @Test
    void webUrlToDeeplink() {
        String test = "https://www.trendyol.com/hesabim/favoriler";
        String expected = "ty://?Page=Home";

        assertEquals(expected,generalLinkConverter.WebUrlToDeeplink(new WebUrlDto(test)).getDeepLink());

    }

    @Test
    void deeplinkToWebUrl() {


    }
}