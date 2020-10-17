package converter.Api.Controllers;
import converter.Contracts.IURLConverterController;
import converter.Core.Interfaces.IConverterHelper;
import converter.Domain.DeepLinkDto;
import converter.Domain.WebUrlDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;
@RestController
public class WebUrlConverterController implements IURLConverterController {
    private Logger _logger;
    private IConverterHelper _helper;

    public WebUrlConverterController(Logger _logger, IConverterHelper _helper) {
        this._logger = _logger;
        this._helper = _helper;
    }

    @RequestMapping("/")
    @Override
    public DeepLinkDto GetDeeplink(WebUrlDto rDto) {
        return _helper.ConvertWebLinkToDeeplink(rDto);
    }
}
