package converter.Core.Services;

import converter.Domain.DeepLinkDto;
import converter.Domain.WebUrlDto;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
class ProductDetailLinkConverterTest {

    @Test
    void webUrlToDeeplink() {
        String test = "https://www.trendyol.com/casio/saat-p-1925865?boutiqueId=439892";
        String test2 = "https://www.trendyol.com/casio/erkek-kol-saati-p-1925865";
        String expected = "ty://?Page=Product&ContentId=1925865&CampaignId=439892";
        String expected2 = "ty://?Page=Product&ContentId=1925865";
        ProductDetailLinkConverter ProductPageLinkConverter = new ProductDetailLinkConverter();
        assertEquals(expected,ProductPageLinkConverter.WebUrlToDeeplink(new WebUrlDto(test)).getDeepLink());
    }

    @Test
    void deeplinkToWebUrl() {
        String expected = "https://www.trendyol.com/brand/name-p-1925865?boutiqueId=439892&merchantId=105064";
        String expected2 = "https://www.trendyol.com/brand/name-p-1925865";
        String test = "ty://?Page=Product&ContentId=1925865&CampaignId=439892&MerchantId=105064";
        String test2 = "ty://?Page=Product&ContentId=1925865";
        ProductDetailLinkConverter ProductPageLinkConverter = new ProductDetailLinkConverter();
        assertEquals(expected,ProductPageLinkConverter.DeeplinkToWebUrl(new DeepLinkDto(test)).getWebUrl());
        assertEquals(expected2,ProductPageLinkConverter.DeeplinkToWebUrl(new DeepLinkDto(test2)).getWebUrl());

    }
}