package IOtest2;

import java.io.Serializable;

public class test implements Serializable {

    private static final long serialVersionUID = -7896078268098892878L;

    private String name;
    private int num;

    @Override
    public String toString() {
        return "test{" +
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

    public test() {
    }

    public test(String name, int num) {
        this.name = name;
        this.num = num;
    }
}
