package converter.Api.Controllers;
import converter.Api.ControllersInterfaces.IURLConverterController;
import converter.Api.Response.ConverterResponse;
import converter.Core.Helpers.ConverterHelper;
import converter.Domain.DeepLinkDto;
import converter.Domain.WebUrlDto;
import converter.EntityFramework.LinkEntity;
import converter.EntityFramework.LinkRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j//log için
@RestController
@RequiredArgsConstructor
public class WebUrlConverterController implements IURLConverterController {
    final private LinkRepository repo;
    final private ConverterHelper converterHelper;//=new ConverterHelper();

    @GetMapping("/CreateDeepLinkFromUrl")
    @Override
    public ConverterResponse GetDeeplink(@RequestParam WebUrlDto rDto) {
        try{
            DeepLinkDto deeplink=converterHelper.ConvertWebLinkToDeeplink(rDto);
            LinkEntity linkEntity=new LinkEntity(rDto.getWebUrl(),deeplink.getDeepLink(),"WebUrlToDeepLink");
            repo.save(linkEntity);
            log.info("Succesfully inserted DB");
            return new ConverterResponse(deeplink, HttpStatus.OK,"Success");
        }
        catch (Exception e){
            log.error("Exception: ",e);
            return new ConverterResponse(null,HttpStatus.INTERNAL_SERVER_ERROR,"ERROR");
        }
        }

}
