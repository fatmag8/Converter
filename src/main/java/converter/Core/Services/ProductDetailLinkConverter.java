package converter.Core.Services;

import converter.Core.Helpers.LinkInfoHelper;
import converter.Core.Interfaces.ILinkConverter;
import converter.Domain.DeepLinkDto;
import converter.Domain.WebUrlDto;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Service
public class ProductDetailLinkConverter implements ILinkConverter {
    @Override
    public DeepLinkDto WebUrlToDeeplink(WebUrlDto webUrlObj) {
        Pattern p = Pattern.compile("(.*-p-)(\\d+)");
        Matcher m = p.matcher(webUrlObj.getWebUrl());
        m.find();
        String c_link= LinkInfoHelper.siteDeeplink+"?Page=Product&ContentId="+m.group(2);
        Matcher m2=Pattern.compile("(.*boutiqueId=)(\\d+)").matcher(webUrlObj.getWebUrl());
        Matcher m3=Pattern.compile("(.*merchantId=)(\\d+)").matcher(webUrlObj.getWebUrl());

        c_link+=(m2.find() ? "&CampaignId="+m2.group(2) : "")+(m3.find() ? "&MerchantId="+m3.group(2) : "");
        return new DeepLinkDto(c_link);

    }

    @Override
    public WebUrlDto DeeplinkToWebUrl(DeepLinkDto deeplinkObj) {
        Pattern p = Pattern.compile("(.*ContentId=)(\\d+)");
        Matcher m= p.matcher(deeplinkObj.getDeepLink());
        Matcher m2= Pattern.compile("(.*CampaignId=)(\\d+)").matcher(deeplinkObj.getDeepLink());
        Matcher m3 = Pattern.compile("(.*MerchantId=)(\\d+)").matcher(deeplinkObj.getDeepLink());
        m.find();
        String c_link=LinkInfoHelper.siteWeb+"/brand/name-p-"+m.group(2);
        if(m2.find()){
            c_link += "?boutiqueId="+m2.group(2);

        }
        if(m3.find()){
            c_link +=(c_link.contains("?") ? "&" : "?")+"merchantId="+m3.group(2);
        }
        return new WebUrlDto(c_link);

    }
}
