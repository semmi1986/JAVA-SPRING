package koschei.models;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Egg7 {

    private final Needle8 needle;

    @Autowired
    public Egg7(Needle8 needle) {
        this.needle = needle;
    }

    @Override
    public String toString() {
        return "в яйце игла, " + needle.toString();
    }
}
