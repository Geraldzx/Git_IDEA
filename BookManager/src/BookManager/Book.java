package BookManager;

import java.io.Serializable;
import java.util.Objects;

/**
 * 图书类
 */
public class Book implements Serializable,Comparable<Book> {
    private static final long serialVersionUID = -3300930253090703161L;
    private String name;//图书名
    private double price;//单价
    private int choose;//库存数量

    @Override
    public String toString() {
        return
                "图书名：" + name + '\'' +
                ", 单价：" + price +
                ", 库存数量" + choose;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getChoose() {
        return choose;
    }

    public void setChoose(int choose) {
        this.choose = choose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(book.price, price) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

    public Book() {
    }

    public Book(String name, double price, int choose) {
        this.name = name;
        this.price = price;
        this.choose = choose;
    }

    @Override
    public int compareTo(Book o) {
        return (int) (this.price-o.getPrice());
    }
}
