package converter.Core.Interfaces;

import converter.Domain.DeepLinkDto;
import converter.Domain.WebUrlDto;

public interface ILinkConverter {
    public DeepLinkDto WebUrlToDeeplink(WebUrlDto webUrlObj);

    public WebUrlDto DeeplinkToWebUrl(DeepLinkDto deeplinkObj);
}
