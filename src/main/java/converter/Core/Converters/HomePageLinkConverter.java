package converter.Core.Converters;

import converter.Core.Helpers.LinkInfoHelper;
import converter.Core.Interfaces.ILinkConverter;
import converter.Domain.DeepLinkDto;
import converter.Domain.WebUrlDto;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static converter.Core.Extensions.StringExtensions.ConvertFromTurkishCharacters;

public class HomePageLinkConverter implements ILinkConverter {
    //private Dictionary<Integer,String> SectionMap = new Hashtable<Integer,String>();
    private BidiMap<Integer,String> SectionMap = new DualHashBidiMap<>();

    public HomePageLinkConverter()//Deeplink SectionId WebUrl karşılıkları
    {
        SectionMap.put(1, "Kadın");
        SectionMap.put(2, "Erkek");
        SectionMap.put(3, "Süpermarket");
        SectionMap.put(4, "Çocuk");
    }

    @Override
    public DeepLinkDto WebUrlToDeeplink(WebUrlDto webUrlObj) {
        Pattern p = Pattern.compile("(.*butik/liste*.)(\\w+)");
        Matcher m = p.matcher(webUrlObj.getWebUrl());
        m.find();
        int SectionId=SectionMap.getKey(m.group(2));
        DeepLinkDto deeplinkDto = new DeepLinkDto(LinkInfoHelper.siteDeeplink+"?Page=Home&SectionId="+SectionId);
        return deeplinkDto;

    }

    @Override
    public WebUrlDto DeeplinkToWebUrl(DeepLinkDto deeplinkObj) {
        Pattern p = Pattern.compile("(SectionId=)(\\d)");
        Matcher m = p.matcher(deeplinkObj.getDeepLink());
        m.find();
        String SectionName=SectionMap.get(Integer.parseInt(m.group(2)));
        WebUrlDto webUrlDto = new WebUrlDto(LinkInfoHelper.siteWeb+"/butik/liste/"+ConvertFromTurkishCharacters(SectionName).toLowerCase(Locale.US));
        //türkçe karakter olayı???
        return webUrlDto;
    }
}
