package converter.Application.Helpers;

import lombok.Getter;

@Getter
public class ShortLinkHelper {
    private static String charsToUse = "abcdefghijklmnopqrstuvwxyz0123456789";
    private static int sLinkMaxLength = 10;

    public static String GenerateShortLink()
    {
        String safeLink = "";
        //char[] randominizedArr = charsToUse.ToCharArray().ToList().OrderBy(x => new Random().Next()).ToArray();
        //String randomStr = new String(randominizedArr);

        safeLink ="";
                //randomStr.Substring(new Random().Next(0, charsToUse.Length), new Random().Next(3, sLinkMaxLength));
        return safeLink;
    }
}
