package converter.Core.Helpers;
import converter.Core.Converters.GeneralLinkConverter;
import converter.Core.Converters.HomePageLinkConverter;
import converter.Core.Converters.ProductDetailLinkConverter;
import converter.Core.Converters.SearchPageLinkConverter;
import converter.Core.Interfaces.IConverterHelper;
import converter.Core.Interfaces.ILinkConverter;
import converter.Domain.DeepLinkDto;
import converter.Domain.Enums.PageType;
import converter.Domain.WebUrlDto;

public class ConverterHelper implements IConverterHelper {
    ILinkConverter _homeLinkConverter = new HomePageLinkConverter();
    ILinkConverter _productLinkConverter = new ProductDetailLinkConverter();
    ILinkConverter _searchLinkConverter = new SearchPageLinkConverter();
    ILinkConverter _otherLinkConverter = new GeneralLinkConverter();
    @Override
    public DeepLinkDto ConvertWebLinkToDeeplink(WebUrlDto webUrlDto) {
        PageType type = GetPageLinkType(webUrlDto.getWebUrl(),true);

        DeepLinkDto deeplinkDto = null;
        switch (type)
        {
            case HomePage:
                deeplinkDto = _homeLinkConverter.WebUrlToDeeplink(webUrlDto);
                break;
            case ProductDetailPage:
                deeplinkDto = _productLinkConverter.WebUrlToDeeplink(webUrlDto);
                break;
            case SearchPage:
                deeplinkDto = _searchLinkConverter.WebUrlToDeeplink(webUrlDto);
                break;
            default:
                deeplinkDto = _otherLinkConverter.WebUrlToDeeplink(webUrlDto);
                break;
        }

        return deeplinkDto;

    }

    @Override
    public WebUrlDto ConvertDeeplinkToWebLink(DeepLinkDto deeplinkDto) {
        PageType type = GetPageLinkType(deeplinkDto.getDeepLink(), false);
        WebUrlDto webUrlDto = null;
        switch (type)
        {
            case HomePage:
                webUrlDto = _homeLinkConverter.DeeplinkToWebUrl(deeplinkDto);
                break;
            case ProductDetailPage:
                webUrlDto = _productLinkConverter.DeeplinkToWebUrl(deeplinkDto);
                break;
            case SearchPage:
                webUrlDto = _searchLinkConverter.DeeplinkToWebUrl(deeplinkDto);
                break;
            default:
                webUrlDto = _otherLinkConverter.DeeplinkToWebUrl(deeplinkDto);
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
