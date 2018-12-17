package car;

import java.util.List;

public class test {
    public static void main(String[] args) {
        /*carManager cm = new carManager();
        List<Car> cars = cm.getCars();
        for (Car car : cars) {
            System.out.println(car.toString());
        }*/

        Car c = new Car("宝马","轿车",500,"qwrj");
        System.out.println(c.toString());

    }
}
