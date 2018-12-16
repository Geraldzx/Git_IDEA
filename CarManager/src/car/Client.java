package car;

import com.sun.org.apache.xalan.internal.xsltc.dom.SortingIterator;

import java.util.List;
import java.util.Scanner;

public class Client {
    static Scanner input = new Scanner(System.in);
    private static userManager um = new userManager();
    private static carManager cm = new carManager();
    public static void main(String[] args) {
         Client cl = new Client();
         cl.Initialize();

         while(true){
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
            }
        }else{
            System.out.println("账号或密码错误！");
            System.out.println("还可以登录"+login+"次；");
            System.out.println("如果密码错误三次，账号将会被锁定！！！");
            Client.CheckThePassword(userManager);
        }
    }

    /**
     * 管理者登录
     * @param userManager
     */
    private static void administrator(user userManager) {
        System.out.println("1.查看所有车辆");
        System.out.println("2.根据车牌号查看汽车租赁人信息及已租天数");
        System.out.println("3.更改用户状态");
        System.out.println("4.添加车辆");
        System.out.println("5.删除车辆");
        if(userManager.getPermissions()==1)
            System.out.println("6.更改用户权限");
        System.out.println("请选择：");
        int num=input.nextInt();
        if(num==1){
            List<Car> cars = cm.getCars();
            for (Car car : cars) {
                if(car!=null)
                    System.out.println(car.toString());
            }
            return;
        }else if (num==2){
            System.out.println("请输入需要查询的车牌号：");
            String c_num=input.next();
            Car car = cm.findcarManager(c_num);
            if(car!=null){
                System.out.print(car.getUsers().toString());
                long l = car.getCar_time().getTime() - car.getLease_time().getTime();
                long l1 = l / 1000 / 60 / 60/24;
                long l2 = l / 1000 / 60 / 60 % 24;
                long l3 = l1 + (l2 >= 12 ? 1 : 0);
            }
        }
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
