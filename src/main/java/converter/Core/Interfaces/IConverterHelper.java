package converter.Core.Interfaces;

import converter.Domain.DeepLinkDto;
import converter.Domain.WebUrlDto;

public interface IConverterHelper {
    public DeepLinkDto ConvertWebLinkToDeeplink(WebUrlDto webUrlDto);

    public WebUrlDto ConvertDeeplinkToWebLink(DeepLinkDto deeplinkDto);
}
