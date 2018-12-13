package IOstream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Stu> stu = new ArrayList<>();
        stu.add(new Stu("张三",18,'女'));
        stu.add(new Stu("李四",28,'男'));

        File file = new File("student");
        if(!file.exists() && file.isFile()==false) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //写入文件
        in(stu, file);
        //读取文件
        read(file);
    }

    private static void in(List<Stu> stu, File file) {
        try {
            OutputStream out = new FileOutputStream(file);
            for (Stu stu1 : stu) {
                String s = stu1.toString()+"\n";
                byte b [] = s.getBytes();
                out.write(b);
            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void read(File file) {
        try {
            InputStream is = new FileInputStream(file);
            int filelength = (int) file.length();
            byte b[]=new byte[filelength];
            is.read(b);
            System.out.println(new String(b));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
