package IOstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Stu> stu = new ArrayList<>();
        stu.add(new Stu("张三",18,'女'));
        stu.add(new Stu("李四",28,'男'));

        File file = new File("f://student");
        if(!file.exists() && file.isFile()==false) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileInputStream input = new FileInputStream((File) stu);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
