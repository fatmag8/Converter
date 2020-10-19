package converter.Api.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Getter
@Setter
public class ConverterResponse {
    private Object data;
    private HttpStatus status;
    private String description;

}
