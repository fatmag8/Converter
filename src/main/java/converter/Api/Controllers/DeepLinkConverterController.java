package converter.Api.Controllers;
import converter.Api.ControllersInterfaces.IDeeplinkConverterController;
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
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class DeepLinkConverterController implements IDeeplinkConverterController {

    ConverterHelper converterHelper=new ConverterHelper();
    @Autowired private LinkRepository repo;


    @GetMapping("/CreateUrlFromDeepLink")
    public ConverterResponse GetWebUrl(@RequestParam DeepLinkDto rDto) {
        try {
            //DeepLinkDto rDto2=new DeepLinkDto(rDto);


            WebUrlDto Weburl=converterHelper.ConvertDeeplinkToWebLink(rDto);
            LinkEntity linkEntity=new LinkEntity(rDto.getDeepLink(),Weburl.getWebUrl(),"DeepLinkToWebUrl");
            repo.save(linkEntity);
            log.info("Succesfully inserted DB");

            return new ConverterResponse(Weburl,HttpStatus.OK,"Success");
        }
        catch (Exception e){
            log.error("Exception: ",e);

            return new ConverterResponse(null,HttpStatus.INTERNAL_SERVER_ERROR,"ERROR");
        }


    }

}
