package IOtest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<stu> stu2 = new ArrayList<>();
        stu2.add(new stu("hh",22));
        stu2.add(new stu("fe",30));
        stu2.add(new stu("yg",32));
        File file = new File("student");
        if(!file.exists() && file.isFile()==false) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileOutputStream fileOutputStream = new  FileOutputStream(file);
            for (stu stu : stu2) {
                String s = stu.toString()+"\n";
                byte[] bytes = s.getBytes();
                fileOutputStream.write(bytes);
            }
            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream =  new FileInputStream(file);
            int length = (int) file.length();
            byte b[] = new byte[length];
            fileInputStream.read(b);
            System.out.println(new String(b));
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
