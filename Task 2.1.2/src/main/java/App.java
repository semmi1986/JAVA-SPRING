import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        HelloWorld helloWorld1 = (HelloWorld) applicationContext.getBean("helloWorld");
        HelloWorld helloWorld2 = (HelloWorld) applicationContext.getBean("helloWorld");
        System.out.println(helloWorld1.getMessage());
        boolean isEqual1 = helloWorld1.equals(helloWorld2);

        Cat cat1 = (Cat) applicationContext.getBean("cat");
        Cat cat2 = (Cat) applicationContext.getBean("cat");
        System.out.println(cat1.say());
        boolean isEqual2 = cat1.equals(cat2);

        System.out.println("--------------------------------------------------");
        System.out.println("For HelloWorld1 and HelloWorld2 bean equal? -> " + isEqual1);
        System.out.println("--------------------------------------------------");
        System.out.println("For Cat1 and Cat2 bean equal? -> " + isEqual2);
        System.out.println("--------------------------------------------------");
    }
}