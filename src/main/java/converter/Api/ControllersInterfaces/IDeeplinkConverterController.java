package converter.Api.ControllersInterfaces;

import converter.Api.Response.ConverterResponse;
import converter.Domain.DeepLinkDto;

public interface IDeeplinkConverterController {
    ConverterResponse GetWebUrl(DeepLinkDto rDto);
}
