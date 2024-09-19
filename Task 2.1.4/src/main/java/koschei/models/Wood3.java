package koschei.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Wood3 {

    private final Box4 box4;

    @Autowired
    public Wood3(Box4 box4) {
        this.box4 = box4;
    }

    @Override
    public String toString() {
        return "на дереве сундук, " + box4.toString();
    }
}
