package test1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<stdent> stu = new ArrayList<>();

        File file = new File("f://stu");
        {
            try {
                if (!file.exists() && file.isFile() == false)
                    file.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                for (stdent stdent : stu) {
                    byte[] bytes = stdent.toString().getBytes();
                    fileOutputStream.write(bytes);
                }


            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
