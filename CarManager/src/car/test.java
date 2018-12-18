package car;

import java.util.List;

public class test {
    public static void main(String[] args) {
        /*carManager cm = new carManager();
        List<Car> cars = cm.getCars();
        for (Car car : cars) {
            System.out.println(car.toString());
        }*/
        /*System.out.println("\t\t+---------------------------------------------------------------------------------------+");
        System.out.println("\t\t|\t\t品牌\t\t|\t\t车型\t\t|\t\t日租金\t\t|\t\t车牌号\t\t|\t是否已租赁\t|");
        System.out.println("\t\t+---------------+---------------+-------------------+-------------------+---------------+");
        Car c = new Car("宝马","轿车",500,"qwrj");
        System.out.println(c.toString());
        System.out.println("\t\t+---------------------------------------------------------------------------------------+");*/
        Car c = new Car("宝马","轿车",500,"qwrj");
        user u = new user("adv", "name", "String u_pwd"," String u_num",5);
        System.out.println("\t\t+----------------------------------------------------------------------------------+");
        System.out.println("\t\t|\t\t账号\t\t|\t\t姓名\t\t\t|\t\t\t联系电话\t\t\t|\t\t租借天数\t\t|");
        System.out.println("\t\t+---------------+-------------------+---------------------------+------------------+");

        System.out.print(u.toString());
        /*long l = c.getCar_time().getTime() - c.getLease_time().getTime();
        long l1 = l / 1000 / 60 / 60;
        long l2 = l1 % 24;
        long l4 = l1 / 24;
        long l3 = l4 + (l2 >= 12 ? 1 : 0);*/

    }
}
