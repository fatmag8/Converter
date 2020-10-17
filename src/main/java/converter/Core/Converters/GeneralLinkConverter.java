package converter.Core.Converters;

import converter.Core.Helpers.LinkInfoHelper;
import converter.Core.Interfaces.ILinkConverter;
import converter.Domain.DeepLinkDto;
import converter.Domain.WebUrlDto;
//other page link converter
public class GeneralLinkConverter implements ILinkConverter {//helper olabilir.
    @Override
    public DeepLinkDto WebUrlToDeeplink(WebUrlDto webUrlObj) {
        return new DeepLinkDto(LinkInfoHelper.siteDeeplink + "?Page=Home") ;
    }

    @Override
    public WebUrlDto DeeplinkToWebUrl(DeepLinkDto deeplinkObj) {
        return new WebUrlDto(LinkInfoHelper.siteWeb);
    }
}
