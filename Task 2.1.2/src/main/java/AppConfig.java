import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
 
    @Bean
    public HelloWorld helloWorld() {
        return new HelloWorld();
    }

    @Bean
    @Scope("prototype")
    public Cat cat(){
       return new Cat();
    }
}