import lombok.*;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter

public class HelloWorld {

    @Value("Hello World!")
    private String message;

}