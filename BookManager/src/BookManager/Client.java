package BookManager;

import java.util.List;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BookManager bookm = new BookManager();
        Book bk = new Book();
        Client cl = new Client();
        cl.out();
        while(true){
            System.out.println("请选择：");
            int num = input.nextInt();
            switch (num){
                case 1:
                    addBook(input, bookm);
                    break;
                case 2:
                    findBook(input, bookm);
                    break;
                case 3:
                    printBookManager(bookm);
                    break;
                case 4:
                    deleteBook(input, bookm);
                    break;
                    case 5:
                    double money = bookm.otal_price();
                    System.out.println("所有图书总价："+money+"元");
                        break;
                case 6:
                    break;
            }
        }
    }

    /**
     * 所有图书信息
     * @param bookm
     */
    private static void printBookManager(BookManager bookm) {
        bookm.sortinginPrice();
        List<Book> books = bookm.getBooks();
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }


    /**
     * 根据书名删除图书
     * @param input
     * @param bookm
     * @return
     */
    private static boolean deleteBook(Scanner input, BookManager bookm) {
        System.out.println("请输入要删除的书名：");
        String name = input.next();
        Book book = bookm.findBook(name);
        if(book==null) {
            System.out.println("没有该图书信息！");
            return true;
        }
        boolean b = bookm.deleteBook(name);
        System.out.println(b?"删除失败！":"删除成功！");
        return false;
    }


    /**
     * 根据书名查找图书
     * @param input
     * @param bookm
     */
    private static void findBook(Scanner input, BookManager bookm) {
        System.out.println("请输入查找的图书名称：");
        String name = input.next();
        Book book = bookm.findBook(name);
        if(book==null) {
            System.out.println("没有该图书信息！");
            return;
        }else
            System.out.println(book.toString());
    }


    /**
     * 添加图书
     * @param input
     * @param bookm
     */
    private static void addBook(Scanner input, BookManager bookm) {
        System.out.println("请输入图书名称：");
        String name = input.next();
        if(bookm.findBook(name)!=null) {
            System.out.println("已有该图书信息！");
            return;
        }
        System.out.println("请输入图书单价：");
        double price = input.nextDouble();
        System.out.println("请输入数量：");
        int choose = input.nextInt();
        Book boo = new Book(name,price,choose);
        boolean b = bookm.addBook(boo);
        System.out.println(b?"添加成功！":"添加失败！");
    }

    /**
     * 初始化系统，输出系统功能
     */
    public void out(){
        System.out.println("\t---------------------------------");
        System.out.println("\t--       图书管理信息系统      --");
        System.out.println("\t---------------------------------");
        System.out.println("1.新增图书");
        System.out.println("2.根据书名查找图书");
        System.out.println("3.查找所有图书信息，并根据价格降序排序");
        System.out.println("4.根据书名删除图书");
        System.out.println("5.计算所有图书的总价格");
        System.out.println("6.退出");
        System.out.println();
    }

    /**
     * 测试信息
     */

}
