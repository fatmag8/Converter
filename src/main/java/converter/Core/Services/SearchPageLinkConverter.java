package converter.Core.Services;

import converter.Core.Helpers.LinkInfoHelper;
import converter.Core.Interfaces.ILinkConverter;
import converter.Domain.DeepLinkDto;
import converter.Domain.WebUrlDto;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SearchPageLinkConverter implements ILinkConverter {

    @Override
    public DeepLinkDto WebUrlToDeeplink(WebUrlDto webUrlObj)  {

        Pattern p = Pattern.compile(("(.*q=)(.?.+)"));
        Matcher m = p.matcher(webUrlObj.getWebUrl());
        m.find();
        return new DeepLinkDto(LinkInfoHelper.siteDeeplink + "?Page=Search&Query=" + m.group(2));



    }

    @Override
    public WebUrlDto DeeplinkToWebUrl(DeepLinkDto deeplinkObj) {
        WebUrlDto webUrlDto = new WebUrlDto("");
        webUrlDto.setWebUrl(deeplinkObj.getDeepLink().replace(LinkInfoHelper.siteDeeplink, LinkInfoHelper.siteWeb).replace("?Page=Search", "/tum-urunler").replace("&Query=", "?q="));
        return webUrlDto;
    }
}
