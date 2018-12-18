package car;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class userManager {
	//用户集合
    List<user> users=new ArrayList<>();
    //构造函数（有参构造）
    public userManager() {
        boolean add = this.users.add(new user("root", "root", "root", "root", 1));
    }
    //封装方法
    public List<user> getUsers() {
        return users;
    }
    public void setUsers(List<user> users) {
        this.users = users;
    }
    //无参构造
    private void addInStorage(){}
    
    /**
     * 添加用户
     */
    public boolean addUsers(user u) {
        if(this.findUserManager(u.getU_ID())!=null)
            return false;
    	this.users.add(u);
    	this.refresh(this.users);
    	return true;
    }

    /**
     * 根据ID查找用户
     */
    public user findUserManager(String id){
        for (user user : users) {
            if(user.getU_ID().equals(id)){
                return user;
            }
        }
        return null;
    }

    /**
     * 随机生成ID
     */
    public String RandomlyGenerated(){
        int id = (int)(Math.random()*100000000);
        String str = Integer.toString(id);
        if(this.findUserManager(str)!=null)
            str=this.RandomlyGenerated();
        return  str;
    }

    /**
     * 刷新缓存
     * @param u
     */
    public void refresh(List<user> u){
        File file = new File("UserManager");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream (file);
            for (user userList : u) {
                String s = userList.toString()+"\n";
                byte[] bytes = s.getBytes();
                fileOutputStream.write(bytes);
            }
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 登录返回状态值；
     * 如果账户密码和输入的密码匹配，直接返回状态值；
     * 如果不匹配，状态值减一，然后返回状态值；
     */
    public int login(user u , String id){
        if(!u.getU_pwd().equals(id))
            u.setState(u.getState()-1);
        return u.getState();
    }

    /**
     * 更改用户状态
     */
    public  boolean ChangeUserstate(user us){
        us.setState(3);
        return true;
    }
    /**
     * 更改用户权限up
     */
    public boolean changeUserpermissionsUp(user us){
        us.setPermissions(0);
        return true;
    }

    /**
     * 更改用户权限up
     */
    public boolean changeUserpermissionsDown(user us){
        us.setPermissions(-1);
        return true;
    }
}
