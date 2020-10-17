package converter.Core.Converters;

import converter.Core.Helpers.LinkInfoHelper;
import converter.Core.Interfaces.ILinkConverter;
import converter.Domain.DeepLinkDto;
import converter.Domain.WebUrlDto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchPageLinkConverter implements ILinkConverter {

    @Override
    public DeepLinkDto WebUrlToDeeplink(WebUrlDto webUrlObj) {
        DeepLinkDto deeplinkDto = new DeepLinkDto("");

        Pattern p = Pattern.compile("(.*q=)(\\w+)");
        Matcher m= p.matcher(webUrlObj.getWebUrl());
        deeplinkDto.setDeepLink(LinkInfoHelper.siteWeb+"?Page=Search&Query="+m.group(2));
        return deeplinkDto;
    }

    @Override
    public WebUrlDto DeeplinkToWebUrl(DeepLinkDto deeplinkObj) {
        WebUrlDto webUrlDto = new WebUrlDto("");
        webUrlDto.setWebUrl(deeplinkObj.getDeepLink().replace(LinkInfoHelper.siteDeeplink, LinkInfoHelper.siteWeb).replace("?Page=Search", "/tum_urunler").replace("&Query=", "?q="));
        return webUrlDto;
    }
}
