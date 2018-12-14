package test1;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class cilent {
    public static void main(String[] args) {
        List<stdent> stu = new ArrayList<>();

        File file = new File("f://stu");
         {
            try {
                if(!file.exists() && file.isFile()==false)
                file.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                for (stdent stdent : stu) {
                    byte[] bytes = stdent.toString().getBytes();
                    fileOutputStream.write(bytes);
                }


            } catch (IOException e) {
                e.printStackTrace();
            }

             /*try {
                 FileInputStream fileInputStream = new FileInputStream(file);
                 BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                 byte[] bytes = new byte[1024];
                 int h ;
                 while((h=bufferedInputStream.read(bytes))!=-1){
                     System.out.println(new String());
                 }
             } catch (FileNotFoundException e) {
                 e.printStackTrace();
             } catch (IOException e) {
                 e.printStackTrace();
             }*/

         }
    }
}
