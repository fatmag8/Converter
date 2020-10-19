package converter.Core.Services;

import converter.Core.Helpers.LinkInfoHelper;
import converter.Core.Interfaces.ILinkConverter;
import converter.Domain.DeepLinkDto;
import converter.Domain.WebUrlDto;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static converter.Core.Extensions.StringExtensions.ConvertFromTurkishCharacters;
@Service
public class HomePageLinkConverter implements ILinkConverter {
    //private Dictionary<Integer,String> SectionMap = new Hashtable<Integer,String>();
    private BidiMap<Integer,String> SectionMap = new DualHashBidiMap<>();

    public HomePageLinkConverter()//Deeplink SectionId WebUrl karşılıkları
    {
        SectionMap.put(1, "kadin");
        SectionMap.put(2, "erkek");
        SectionMap.put(3, "süpermarket");
        SectionMap.put(4, "çocuk");
    }

    @Override
    public DeepLinkDto WebUrlToDeeplink(WebUrlDto webUrlObj) {
        Pattern p = Pattern.compile("(.*butik/liste*.)(\\w+)");
        Matcher m = p.matcher(webUrlObj.getWebUrl());
        m.find();
        String group = m.group(2);
        int SectionId=SectionMap.getKey(group);
        return new DeepLinkDto(LinkInfoHelper.siteDeeplink+"?Page=Home&SectionId="+SectionId);


    }

    @Override
    public WebUrlDto DeeplinkToWebUrl(DeepLinkDto deeplinkObj) {
        Pattern p = Pattern.compile("(SectionId=)(\\d)");
        Matcher m = p.matcher(deeplinkObj.getDeepLink());
        m.find();
        String SectionName=SectionMap.get(Integer.parseInt(m.group(2)));
        return  new WebUrlDto(LinkInfoHelper.siteWeb+"/butik/liste/"+ConvertFromTurkishCharacters(SectionName).toLowerCase(Locale.US));

    }
}
