package converter.Api.Controllers;

import converter.Contracts.IDeeplinkConverterController;
import converter.Core.Interfaces.IConverterHelper;
import converter.Domain.DeepLinkDto;
import converter.Domain.WebUrlDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class DeepLinkConverterController implements IDeeplinkConverterController {
    private Logger _logger;
    private IConverterHelper _helper;
    public DeepLinkConverterController(Logger logger, IConverterHelper converterHelper)
    {
        _logger = logger;
        _helper = converterHelper;
    }
    @Override
    @RequestMapping("/")
    public WebUrlDto GetWebUrl(@RequestBody DeepLinkDto rDto) {
        return _helper.ConvertDeeplinkToWebLink(rDto);

    }

}
