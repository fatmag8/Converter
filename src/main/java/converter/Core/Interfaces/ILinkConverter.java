package converter.Core.Interfaces;

import converter.Domain.DeepLinkDto;
import converter.Domain.WebUrlDto;
import org.springframework.stereotype.Component;

@Component
public interface ILinkConverter {
    DeepLinkDto WebUrlToDeeplink(WebUrlDto webUrlObj) ;

    WebUrlDto DeeplinkToWebUrl(DeepLinkDto deeplinkObj)  ;
}
