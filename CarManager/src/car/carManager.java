package car;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class carManager {
    private List<Car> cars=new ArrayList<>();

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

     carManager() {
    }

    public carManager(List<Car> cars) {
        this.cars = cars;
    }

    /**
     * 刷新缓存
     * @param
     */
    private void refresh(List<Car> u){
        File file = new File("carManager");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream (file);
            for (Car userList : u) {
                String s = userList.toString()+"\n";
                byte[] bytes = s.getBytes();
                fileOutputStream.write(bytes);
            }
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加用户
     */
    public boolean addUsers(Car u) {
        if(this.findcarManager(u.getC_num())==null)
            return false;
        this.cars.add(u);
        this.refresh(this.cars);
        return true;
    }

    /**
     * 根据ID查找用户
     */
    public Car findcarManager(String C_num){
        for (Car car : cars) {
            if(car.getC_num().equals(C_num))
                return car;
        }
        return null;
    }
}
