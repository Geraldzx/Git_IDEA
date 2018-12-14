package IOtest2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class testClient {
    public static void main(String[] args) {
        List<test> tests = new ArrayList<>();
        tests.add(new test("dsf",23));
        tests.add(new test("dsf",23));
        tests.add(new test("dsf",23));
        tests.add(new test("dsf",23));
        tests.add(new test("dsf",23));
        File file = new File("test");
        if(!file.exists()&&file.isFile()==false){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileWriter fileWriter =  new FileWriter(file);
            for (test test : tests) {
                String s = test.toString()+"\n";
                fileWriter.write(s);
                
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        testClient demo = new testClient();
        try {
            FileReader fileReader = new  FileReader(file);
            int ch =  fileReader.read();
            while(ch!=-1){
                System.out.print((char) ch);
                ch = fileReader.read();
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
