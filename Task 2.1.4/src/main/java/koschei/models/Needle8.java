package koschei.models;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Needle8 {
    public final Deth9 deth;

    @Autowired
    public Needle8(Deth9 deth) {
        this.deth = deth;
    }

    @Override
    public String toString() {
        return "смерть моя на кончике иглы, " + deth.toString();
    }
}
