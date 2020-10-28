package converter.Core.Services;

import converter.Core.Helpers.LinkInfoHelper;
import converter.Core.Interfaces.ILinkConverter;
import converter.Domain.DeepLinkDto;
import converter.Domain.WebUrlDto;
//import converter.EntityFramework.Models.LinkEntity;
//import converter.EntityFramework.Repositories.LinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//other page link converter
@Service
@RequiredArgsConstructor
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
