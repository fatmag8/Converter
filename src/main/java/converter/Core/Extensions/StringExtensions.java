package converter.Core.Extensions;

public class StringExtensions {
    public static String ConvertFromTurkishCharacters(String input)
    {
        input= input.replace('ö', 'o');
        input = input.replace('ç', 'c');
        input = input.replace('ş', 's');
        input = input.replace('ı', 'i');
        input = input.replace('ğ', 'g');
        input = input.replace('ü', 'u');

        input = input.replace("Ü", "U");
        input = input.replace("İ", "I");
        input = input.replace("Ö", "O");
        input = input.replace("Ü", "U");
        input = input.replace("Ş", "S");
        input = input.replace("Ğ", "G");
        input = input.replace("Ç", "C");
        return input;
    }
}
