package converter.Application.Helpers;

import converter.Application.Converters.GeneralLinkConverter;
import converter.Application.Interfaces.IConverterHelper;
import converter.Application.Interfaces.ILinkConverter;
import converter.Domain.DeepLinkDto;
import converter.Domain.Enums.PageType;
import converter.Domain.WebUrlDto;

public class ConverterHelper implements IConverterHelper {
   // ILinkConverter _homeLinkConverter = new HomeLinkConverter();
   // ILinkConverter _productLinkConverter = new ProductLinkConverter();
    //ILinkConverter _searchLinkConverter = new SearchLinkConverter();
    ILinkConverter _otherLinkConverter = new GeneralLinkConverter();
    @Override
    public DeepLinkDto ConvertWebLinkToDeeplink(WebUrlDto webUrlDto) {
        return null;
    }

    @Override
    public WebUrlDto ConvertDeeplinkToWebLink(DeepLinkDto deeplinkDto) {
        return null;
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
