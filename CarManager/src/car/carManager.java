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
        if(!file.isFile()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
     * 添加车辆
     */
    public boolean addcars(Car u) {
        if(this.findcarManager(u.getC_num())!=null)
            return false;
        this.cars.add(u);
        this.refresh(this.cars);
        return true;
    }

    /**
     * 根据车牌号查找车辆
     */
    public Car findcarManager(String C_num){
        for (Car car : cars) {
            if(car.getC_num().equals(C_num))
                return car;
        }
        return null;
    }

    /**
     * 删除车辆
     */
    public  boolean deleteCars(String num){
        for (Car car : cars) {
            if(car.getC_num().equals(num)){
                boolean remove = cars.remove(car);
                this.refresh(this.cars);
                return remove;
            }
        }
        return false;
    }

    /**
     * 按品牌把能出租的车辆分类
     */
    public List<Car> classification(String pp){
         List<Car> car2=new ArrayList<>();
        for (Car carList : this.cars) {
            if(!carList.getState()&&carList.getBrand().equals(pp))
                car2.add(carList);
        }
        return car2;
    }
}
