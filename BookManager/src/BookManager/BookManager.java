package BookManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 图书管理类
 */
public class BookManager {
    List<Book> books = new ArrayList<>();  //图书集合


    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public BookManager() {
        books.add(new Book("童话",341,10));
        books.add(new Book("童话2",34,10));
        books.add(new Book("童话3",234,10));
        this.refresh(this.books);
    }

    public BookManager(List<Book> books) {
        this.books = books;
    }

    /**
     * 添加图书
     */
    public boolean addBook(Book bo){
        this.books.add(bo);
        this.books = this.refresh(this.books);
        this.refresh(this.books);
        return false;
    }

    /**
     * 根据书名查找图书
     */
    public Book findBook(String name){
        for (Book book : books) {
            if(book.getName().equals(name)) return book;
        }
        return null;
    }

    /**
     * 根据书名删除图书
     */
    public boolean deleteBook(String name){
        Book b = this.findBook(name);
        if(b==null) return false;
        this.books.remove(b);
        this.refresh(this.books);
        return true;
    }

    /**
     * 计算所有图书的总价格
     */
    public double otal_price(){
        double money=0;
        for (Book book : books) {
            money+=book.getChoose()*book.getPrice();
        }
        return money;
    }

    /**
     * 根据价格降序排序
     */
    public void sortinginPrice(){
        Collections.sort(books);
        /*books.sort((f1,f2)->
                (int)(f1.getPrice()-f2.getPrice()));*/
        /*Collections.sort(books,(f1,f2)->
                (int)(f1.getPrice()-f2.getPrice()));*/
    }

    /**
     * 刷新纪录
     */
    public  List<Book>  refresh(List<Book> books){

        File file=new File("BookManager");
        if(!file.isFile()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream (file);
            for (Book book : books) {
                String str = book.toString()+"\n";
                byte[] bytes = str.getBytes();
                fileOutputStream.write(bytes);
            }
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  books;
    }
}
