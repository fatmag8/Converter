package converter.Core.Interfaces;

import converter.Domain.DeepLinkDto;
import converter.Domain.LinkDto;
import converter.Domain.ShortLinkDto;
import converter.Domain.WebUrlDto;

public interface IShortLinkConverter {
    public LinkDto GetLinks(ShortLinkDto shortlink);

    public ShortLinkDto GetShortLink(DeepLinkDto deeplinkDto);

    public ShortLinkDto GetShortLink(WebUrlDto webUrlDto);
}
