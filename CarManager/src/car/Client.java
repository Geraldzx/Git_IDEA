package car;

import java.util.List;
import java.util.Scanner;

public class Client {
    static Scanner input = new Scanner(System.in);
    private static userManager um = new userManager();
    private static carManager cm = new carManager();
    public static void main(String[] args) {
         Client cl = new Client();
         cl.Initialize();

         hello :while(true){
             System.out.println("请选择：");
             int num = input.nextInt();
             switch (num){
                 case 1:
                     addUsers();
                     break;
                 case 2:
                     login();
                     break;
             }
         }
    }

    /**
     * 登录
     */
    private static void login() {
        System.out.println("请输入您的账户：");
        String userid =input.next();
        user userManager = um.findUserManager(userid);
        if(userManager==null){
            System.out.println("该账户还没有注册！");
            return;
        }
        CheckThePassword(userManager);
    }

    /**
     * 输入密码并验证
     * @param userManager
     */
    private static void CheckThePassword(user userManager) {
        if(userManager.getState()<=0){
            System.out.println("您的账户已被锁定，请联系管理员解锁！");
            return;
        }
        System.out.println("请输入您的密码");
        String pwd = input.next();
        int login = um.login(userManager, pwd);
        if (login==3){
            System.out.println("登录成功！");
            if(userManager.getPermissions()!=-1){
                administrator(userManager);
            }else{
                Userlogin(userManager);
                return;
            }
        }else{
            System.out.println("账号或密码错误！");
            System.out.println("还可以登录"+login+"次；");
            System.out.println("如果密码错误三次，账号将会被锁定！！！");
            Client.CheckThePassword(userManager);
        }
    }

    /**
     * 普通用户登录
     * @param userManager
     */
    private static void Userlogin(user userManager) {
        System.out.println("1、查看可租赁车辆");
        System.out.println("2、查看自己的租赁信息");
        System.out.println("3、归还车辆");
        System.out.println("4、租赁车辆");
        System.out.println("5、退出");
        int num=input.nextInt();
        switch (num){
            case 1:
                List<Car> cars = cm.getCars();
                for (Car car : cars) {
                    if(car.getState())
                        System.out.println(car.toString());
                }
            case 2:
                if(userManager.getUc()==null){
                    System.out.println("您没有租用车辆！");
                    Client.Userlogin(userManager);
                }
                System.out.println("您租用的车辆是："+userManager.getUc().toString());
            case 3:
                if(userManager.getUc()==null){
                    System.out.println("您没有租用车辆！");
                    Client.Userlogin(userManager);
                }
                System.out.println("您租用的车辆是："+userManager.getUc().toString());
                long l = userManager.getUc().getCar_time().getTime() - userManager.getUc().getLease_time().getTime();
                long l1 = l / 1000 / 60 / 60/24;
                long l2 = l / 1000 / 60 / 60 % 24;
                long l3 = l1 + (l2 >= 12 ? 1 : 0);
                double v = l3 * userManager.getUc().getRent();
                System.out.println("您需缴纳的金额为："+v+"元。");
                userManager.getUc().setState(!userManager.getUc().getState());  //更改车辆状态
                userManager.setUc(null);     //更改用户的租车情况
            case 4:
                System.out.println("请输入您想租用的汽车品牌：");
                String pp = input.next();
                List<Car> classification = cm.classification(pp);
                if(classification==null){
                    System.out.println("没有此品牌的汽车可出租");
                    Client.Userlogin(userManager);
                }
                System.out.println("\t\t+----------------------------------" +
                        "-----------------------------------------------------+");
                System.out.println("\t\t|\t\t品牌\t\t|\t\t车型\t\t|" +
                        "\t\t日租金\t\t|\t\t车牌号\t\t|\t是否已租赁\t|");
                System.out.println("\t\t+-----------------------------------" +
                        "----------------------------------------------------+");
                for (Car car : classification) {
                    System.out.println(car);
                }
                System.out.println("\t\t+-----------------------------------" +
                        "----------------------------------------------------+");
                System.out.println("请输入您选择的车牌号：");
                String ppp = input.next();
                Car car = cm.findcarManager(ppp);
                if(car==null){
                    System.out.println("没有该车牌号！");
                    Client.Userlogin(userManager);
                }
                car.setState(!car.getState());
                userManager.setUc(car);
                System.out.println("租借成功，祝您旅途愉快！");
            case 5:
                System.out.println("欢迎下次使用，再见！");
                System.exit(1);
        }
    }

    /**
     * 管理者登录
     * @param userManager
     */
    private static void administrator(user userManager) {
        System.out.println("1.查看所有车辆");
        System.out.println("2.根据车牌号查看汽车租赁人信息及已租天数");
        System.out.println("3.添加车辆");
        System.out.println("4.删除车辆");
        System.out.println("5.更改用户状态");
        if(userManager.getPermissions()==1)
            System.out.println("6.更改用户权限");
        System.out.println("0.退出");
        System.out.println("请选择：");
        int num=input.nextInt();
        if(num==1){
            CarManager();
            Client.administrator(userManager);
        }else if (num==2){
            Car_User();
            Client.administrator(userManager);
        }else if(num==3){
            addCars();
            Client.administrator(userManager);
        }else if(num==4){
            deleteCarManager();
            Client.administrator(userManager);
        }else if(num==5){
            changaUserState(userManager);
            Client.administrator(userManager);
        }else if (num == 6){
            changeUserPermissions();
            Client.administrator(userManager);
        }else if (num==0)
            System.out.println("欢迎下次使用，再见！");
           System.exit(1);
    }

    /**
     * 更改用户权限
     */
    private static void changeUserPermissions() {
        System.out.println("请输入用户账号：");
        String id = input.next();
        user users = um.findUserManager(id);
        if(users==null){
            System.out.println("没有该用户信息！");
            return;
        }
        System.out.println("1、权限上升；2、权限下降；");
        int no=input.nextInt();
        boolean remove;
        if (no == 1) {
            remove=um.changeUserpermissionsUp(users);
        } else {
             remove=um.changeUserpermissionsDown(users);
        }
        System.out.println(remove?"更改成功！":"更改失败！");
    }

    /**
     * 更改用户状态
     * @param userManager
     */
    private static void changaUserState(user userManager) {
        System.out.println("请输入用户账号：");
        String id = input.next();
        user userManager1 = um.findUserManager(id);
        if(userManager==null){
            System.out.println("没有该用户信息！");
            return;
        }
        boolean b = um.ChangeUserstate(userManager);
        System.out.println(b?"更改成功！":"更改失败！");
        return;
    }

    /**
     * 删除车辆信息
     */
    private static void deleteCarManager() {
        System.out.println("请输入要删除的车牌号：");
        String c_num=input.next();
        Car car = cm.findcarManager(c_num);
        if(car==null){
            System.out.println("没有该车信息！");
            return;
        }
        boolean b = cm.deleteCars(c_num);
        System.out.println(b?"删除成功！":"删除失败！");
        return;
    }

    /**
     * 添加车辆
     */
    private static void addCars() {
        System.out.println("请输入品牌：");
        String brand = input.next();
        System.out.println("请输入车型：");
        String models = input.next();
        System.out.println("请输入日租金：");
        double rent = input.nextInt();
        System.out.println("请输入车牌号：");
        String c_no = input.next();
        Car c = cm.findcarManager(c_no);
        if(c!=null){
            System.out.println("该车或该车牌号已经注册！");
            return;
        }
        Car car = new Car(brand,models,rent,c_no);
        boolean addcars = cm.addcars(car);
        System.out.println(addcars?"添加成功！":"添加失败！");
    }

    /**
     * 查看租车的人
     */
    private static void Car_User() {
        System.out.println("请输入需要查询的车牌号：");
        String c_num=input.next();
        Car car = cm.findcarManager(c_num);
        if(car.getUsers()!=null){
            System.out.println("\t\t+----------------------------------------------------------------------------------+");
            System.out.println("\t\t|\t\t账号\t\t|\t\t姓名\t\t\t|\t\t\t联系电话\t\t\t|\t\t租借天数\t\t|");
            System.out.println("\t\t+---------------+-------------------+---------------------------+------------------+");
            System.out.print(car.getUsers().toString());
            long l = car.getCar_time().getTime() - car.getLease_time().getTime();
            long l1 = l / 1000 / 60 / 60/24;
            long l2 = l / 1000 / 60 / 60 % 24;
            long l3 = l1 + (l2 >= 12 ? 1 : 0);
            System.out.println("\t\t"+l3+"\t\t|");
            System.out.println("\t\t+----------------------------------------------------------------------------------+");
        }
    }

    /**
     * 查看所有车辆信息
     */
    private static void CarManager() {
        List<Car> cars = cm.getCars();
        System.out.println("\t\t+----------------------------------" +
                "-----------------------------------------------------+");
        System.out.println("\t\t|\t\t品牌\t\t|\t\t车型\t\t|" +
                "\t\t日租金\t\t|\t\t车牌号\t\t|\t是否已租赁\t|");
        System.out.println("\t\t+-----------------------------------" +
                "----------------------------------------------------+");
        for (Car car : cars) {
            if(car!=null)
                System.out.println(car.toString());
        System.out.println("\t\t+--------------------------------" +
                "-------------------------------------------------------+");
        }
        return;
    }

    /**
     * 添加用户
     */
    private static void addUsers() {
        System.out.println("请输入姓名：");
        String name = input.next();
        String Id = um.RandomlyGenerated();
        System.out.println("您的账号是："+Id);
        System.out.println("请输入您的电话号码：");
        String no = input.next();
        System.out.println("请输入您的密码：");
        String pwd = input.next();
        System.out.println("请确定您的密码：");
        String pwdt = input.next();
        if(!pwd.equals(pwdt)){
            System.out.println("对不起，您两次输入的密码不一致！");
            return;
        }
        user user=new user(Id,name,pwd,no,-1);
        boolean b = um.addUsers(user);
        System.out.println(b?"添加成功！":"添加失败！");
    }

    /**
     * 初始化系统，输出系统的相关信息
     */
    private void Initialize(){
        System.out.println("\t+---------------------------+");
        System.out.println("\t|    \t汽车租赁系统      \t|");
        System.out.println("\t+---------------------------+");
        System.out.println();
        System.out.println("1、注册；2、登录；3、退出；");
        user user = new user("root","root","root","root",1);
        um.addUsers(user);
    }
}
