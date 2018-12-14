package IOstream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class buffrerdClient {
    public static void main(String[] args) {
        List<Stu2> stu=new ArrayList<>();
        stu.add(new Stu2("张三",18,'女'));
        stu.add(new Stu2("李四",28,'男'));
        File file=new File("stu");
        if(!file.exists() && file.isFile()==false) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //写入
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            BufferedWriter bwriter=new BufferedWriter(outputStreamWriter);
            String str = stu.toString();
            int i = 0 ;
            for (Stu2 stu1 : stu) {
                String s = stu1.toString();
                bwriter.write(s);
                System.out.println("写入的次数："+i++);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //读取
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader (inputStreamReader);
            String lien ;
            int i = 1 ;

            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
