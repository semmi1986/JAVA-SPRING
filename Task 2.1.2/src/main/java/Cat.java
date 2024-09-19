import lombok.*;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter

public class Cat {

    @Value("Myrka")
    private String name;

    public String say() {
        return "My name is " + this.name;
    }
}
