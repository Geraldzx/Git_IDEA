package car;

import java.io.Serializable;

public class user implements Serializable {
    private static final long serialVersionUID = -6286752678219424296L;
    private String u_ID;//账号
    private String u_name;//用户名
    private String u_pwd;//密码
    private String u_num;//联系电话
    private int permissions ;//权限
    private int state = 3;//状态
    private Car  uc;//租用车辆

    public Car getUc() {
        return uc;
    }

    public void setUc(Car uc) {
        this.uc = uc;
    }

    @Override
    public String toString() {
        return  "\t\t|\t\t" + u_ID +
                "\t\t|\t\t" + u_name +
                "\t\t|\t\t" + u_num +"\t\t|";
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getU_ID() {
        return u_ID;
    }

    public void setU_ID(String u_ID) {
        this.u_ID = u_ID;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_pwd() {
        return u_pwd;
    }

    public void setU_pwd(String u_pwd) {
        this.u_pwd = u_pwd;
    }

    public String getU_num() {
        return u_num;
    }

    public void setU_num(String u_num) {
        this.u_num = u_num;
    }

    public int getPermissions() {
        return permissions;
    }

    public void setPermissions(int permissions) {
        this.permissions = permissions;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public user(String adv, String name, String string_u_pwd, String u_num, String int_permissions) {
    }

    public user(String u_ID, String u_name, String u_pwd, String u_num,int permissions) {
        this.u_ID = u_ID;
        this.u_name = u_name;
        this.u_pwd = u_pwd;
        this.permissions=permissions;
        this.u_num = u_num;
    }
}
