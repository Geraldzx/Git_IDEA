package car;

import java.io.ObjectInputStream;
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
        if(this.findUserManager(u.getU_ID())==null)
            return false;
    	this.users.add(u);
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
     * 刷新缓存
     */
    /*public List<user>[] refresh(List<user>[] u){
        //ObjectInputStream in = new ObjectInputStream(new fileInputStream(“D:\\objectfile.obj”));
    }*/
}
