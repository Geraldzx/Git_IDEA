package IOtest;

import java.io.Serializable;

public class stu implements Serializable {

    private static final long serialVersionUID = -7044519280094454064L;
    private String name;
    private int num;

    @Override
    public String toString() {
        return "stu{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public stu() {
    }

    public stu(String name, int num) {
        this.name = name;
        this.num = num;
    }
}
