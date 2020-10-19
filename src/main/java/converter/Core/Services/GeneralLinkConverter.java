package converter.Core.Services;

import converter.Core.Helpers.LinkInfoHelper;
import converter.Core.Interfaces.ILinkConverter;
import converter.Domain.DeepLinkDto;
import converter.Domain.WebUrlDto;
//import converter.EntityFramework.Models.LinkEntity;
//import converter.EntityFramework.Repositories.LinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

//other page link converter
@Component
@RequiredArgsConstructor
public class GeneralLinkConverter implements ILinkConverter {//helper olabilir.

    //private final LinkRepository repo;

    @Override
    public DeepLinkDto WebUrlToDeeplink(WebUrlDto webUrlObj) {
        //LinkEntity d1=new LinkEntity();
        //d1.setRequest(webUrlObj.getWebUrl());
        //d1.setResponse(LinkInfoHelper.siteDeeplink + "?Page=Home");
        //d1.setType("webUrl to deeplink");
        //repo.save(d1);
        return new DeepLinkDto(LinkInfoHelper.siteDeeplink + "?Page=Home") ;
    }

    @Override
    public WebUrlDto DeeplinkToWebUrl(DeepLinkDto deeplinkObj) {
        return new WebUrlDto(LinkInfoHelper.siteWeb);
    }
}
