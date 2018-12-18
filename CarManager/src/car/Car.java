package car;

import java.io.Serializable;
import java.util.Date;

/**
 *汽车类
 */
public class Car implements Serializable {
    private static final long serialVersionUID = 3421471490707489334L;
    private String  brand;//品牌
    private String  models;//车型
    private double  rent;//日租金
    private String  c_num;//车牌号
    private boolean  state=false;//状态
    private user  users;//租车人
    private Date Lease_time;//出租时间
    private Date Car_time;//还车时间

    public Car(String brand, String models, double rent, String c_num) {
        this.brand = brand;
        this.models = models;
        this.rent = rent;
        this.c_num = c_num;
        this.state = true;
    }

    @Override
    public String toString() {
        return  "\t\t|\t\t" + brand +
                "\t\t|\t\t" + models +
                "\t\t|\t\t"+ rent +
                "\t\t|\t\t" + c_num +
                "\t\t|\t\t" + (state?"是":"否") +"\t\t|";
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModels() {
        return models;
    }

    public void setModels(String models) {
        this.models = models;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public String getC_num() {
        return c_num;
    }

    public void setC_num(String c_num) {
        this.c_num = c_num;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public user getUsers() {
        return users;
    }

    public void setUsers(user users) {
        this.users = users;
    }

    public Date getLease_time() {
        return Lease_time;
    }

    public void setLease_time(Date lease_time) {
        Lease_time = lease_time;
    }

    public Date getCar_time() {
        return Car_time;
    }

    public void setCar_time(Date car_time) {
        Car_time = car_time;
    }

    public Car() {
    }
}
