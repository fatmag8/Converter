package converter.Core.Helpers;
import converter.Core.Services.GeneralLinkConverter;
import converter.Core.Services.HomePageLinkConverter;
import converter.Core.Services.ProductDetailLinkConverter;
import converter.Core.Services.SearchPageLinkConverter;
import converter.Core.Interfaces.IConverterHelper;
import converter.Core.Interfaces.ILinkConverter;
import converter.Domain.DeepLinkDto;
import converter.Domain.Enums.PageType;
import converter.Domain.WebUrlDto;


public class ConverterHelper implements IConverterHelper {
    ILinkConverter homePageLinkConverter = new HomePageLinkConverter();
    ILinkConverter productDetailLinkConverter = new ProductDetailLinkConverter();
    ILinkConverter searchPageLinkConverter= new SearchPageLinkConverter();
    ILinkConverter generalLinkConverter = new GeneralLinkConverter();
    @Override
    public DeepLinkDto ConvertWebLinkToDeeplink(WebUrlDto webUrlDto) {
        PageType type = GetPageLinkType(webUrlDto.getWebUrl(),true);

        DeepLinkDto deeplinkDto ;
        switch (type)
        {
            case HomePage:
                deeplinkDto = homePageLinkConverter.WebUrlToDeeplink(webUrlDto);
                break;
            case ProductDetailPage:
                deeplinkDto = productDetailLinkConverter.WebUrlToDeeplink(webUrlDto);
                break;
            case SearchPage:
                deeplinkDto = searchPageLinkConverter.WebUrlToDeeplink(webUrlDto);
                break;
            default:
                deeplinkDto = generalLinkConverter.WebUrlToDeeplink(webUrlDto);
                break;
        }

        return deeplinkDto;

    }

    @Override
    public WebUrlDto ConvertDeeplinkToWebLink(DeepLinkDto deeplinkDto) {
        PageType type = GetPageLinkType(deeplinkDto.getDeepLink(), false);
        WebUrlDto webUrlDto ;
        switch (type)
        {
            case HomePage:
                webUrlDto = homePageLinkConverter.DeeplinkToWebUrl(deeplinkDto);
                break;
            case ProductDetailPage:
                webUrlDto = productDetailLinkConverter.DeeplinkToWebUrl(deeplinkDto);
                break;
            case SearchPage:
                webUrlDto = searchPageLinkConverter.DeeplinkToWebUrl(deeplinkDto);
                break;
            default:
                webUrlDto = generalLinkConverter.DeeplinkToWebUrl(deeplinkDto);
                break;
        }

        return webUrlDto;


    }
    private PageType GetPageLinkType(String link, Boolean isSiteLink )
    {
        if (isSiteLink)
        {
            if (link.contains("/butik/liste"))
                return PageType.HomePage;
            else if (link.contains("-p-"))
                return PageType.ProductDetailPage;
            else if (link.contains("/tum-urunler?q"))
                return PageType.SearchPage;
            else
                return PageType.OtherPage;
        }
        else
        {
            if (link.contains("Page=Home"))
                return PageType.HomePage;
            else if (link.contains("Page=Product"))
                return PageType.ProductDetailPage;
            else if (link.contains("Page=Search"))
                return PageType.SearchPage;
            else
                return PageType.OtherPage;
        }
    }
}
