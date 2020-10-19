package converter.Api.ControllersInterfaces;

import converter.Api.Response.ConverterResponse;
import converter.Domain.WebUrlDto;

public interface IURLConverterController {
    ConverterResponse GetDeeplink(WebUrlDto rDto);
}
