package converter.Application.Converters;

import converter.Application.Helpers.LinkInfoHelper;
import converter.Application.Interfaces.ILinkConverter;
import converter.Domain.DeepLinkDto;
import converter.Domain.WebUrlDto;

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
