package converter.Domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeepLinkDto {
    private String DeepLink;

    public DeepLinkDto(String deepLink) {
        DeepLink = deepLink;
    }
}
