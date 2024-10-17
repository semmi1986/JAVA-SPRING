package web.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Car {

    private int id;
    private String name;
    private String color;

    public Car(int id, String name, String color) {
        this.name = name;
        this.color = color;
        this.id = id;
    }
}