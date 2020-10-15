package converter.Contracts;

import converter.Domain.DeepLinkDto;
import converter.Domain.WebUrlDto;

public interface IDeeplinkConverterController {
    public WebUrlDto GetWebUrl(DeepLinkDto rDto);
}
