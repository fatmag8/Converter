package converter.Contracts;

import converter.Domain.DeepLinkDto;
import converter.Domain.WebUrlDto;

public interface IURLConverterController {
    public DeepLinkDto GetDeeplink(WebUrlDto rDto);
}
