package converter.Domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WebUrlDto {
    private String WebUrl;

    public WebUrlDto(String webUrl) {
        WebUrl = webUrl;
    }
}
