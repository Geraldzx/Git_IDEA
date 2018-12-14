package test1;

import java.io.Serializable;

public class stdent implements Serializable {

    private static final long serialVersionUID = 8104207374201336499L;

    private String name ;
    private int age;
    private char sex;

    @Override
    public String toString() {
        return "stdent{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public stdent() {
    }

    public stdent(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}
