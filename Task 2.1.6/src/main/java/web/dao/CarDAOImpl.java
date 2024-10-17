package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDAOImpl implements CarDAO {

    private static int CAR_COUNTER;
    private final List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car(++CAR_COUNTER, "Tesla", "Red"));
        cars.add(new Car(++CAR_COUNTER, "BMV", "Black"));
        cars.add(new Car(++CAR_COUNTER, "Porch", "Yellow"));
        cars.add(new Car(++CAR_COUNTER, "Chevrolet", "Blue"));
        cars.add(new Car(++CAR_COUNTER, "VW", "Green"));
        cars.add(new Car(++CAR_COUNTER, "Volvo", "Gray"));
    }

    @Override
    public List<Car> getCars(Integer count) {
        if (count == null || count < 0) {
            return cars;
        } else return cars.subList(0, count);
    }
}