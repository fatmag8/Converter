package converter.Api.Controllers;

import converter.ConverterApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ConverterApplication.class)
class DeepLinkConverterControllerTest {
    @Autowired
    private DeepLinkConverterController deepLinkConverterController;

    @Test
    void getWebUrl() {
        String expected= "https://www.trendyol.com/butik/liste/kadin";
        String test = "ty://?Page=Home&SectionId=1";
        //DeepLinkConverterController c1=new DeepLinkConverterController();
        //assertEquals(expected,c1.GetWebUrl(new DeepLinkDto(test)).getWebUrl());
    }
}