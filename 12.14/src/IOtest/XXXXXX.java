package IOtest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class XXXXXX {

    public static void main(String[] args) {
        // 读取文件的方式一：逐个字符来读取文本文件
        FileReader fr = null;
        try {
            fr = new FileReader("Demo.txt");

            int ch = fr.read();
            while (ch != -1) {
                System.out.print((char) ch);
                ch = fr.read();
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("异常：" + e.toString());
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                System.out.println("异常：" + e.toString());
            }
        }

        //读取文件方式二：使用数组来读取文本文件
        FileReader fr1 = null;
        try {
            fr1 = new FileReader("Demo.txt");
            char [] buf = new char[1024];
            int num = 0;
            while((num = fr1.read(buf))!=-1) {
                System.out.println(new String(buf,0,num));
            }
        }catch(IOException e) {
            System.out.println("异常：" + e.toString());
        }finally {
            try {
                if(fr1!=null)
                    fr1.close();
            }catch(IOException e) {
                System.out.println("异常：" + e.toString());
            }
        }

        //方法三：用缓冲区读取文本文件
        //通过查源码得知方法三内部实现时是使用数组形式来缓冲字符数据的
        FileReader fr2 = null;
        BufferedReader bufr = null;
        try {
            fr2 = new FileReader("Demo.txt");
            bufr = new BufferedReader(fr2);
            String line = null;
            //BufferedReader提供了按行读取文本文件的方法readLine()
            //readLine()返回行有效数据，不包含换行符，未读取到数据返回null
            while((line = bufr.readLine())!=null) {
                System.out.println(line);
            }
        }catch(IOException e) {
            System.out.println("异常：" + e.toString());
        }finally {
            try {
                if(bufr!=null)
                    bufr.close();
            }catch(IOException e) {
                System.out.println("异常：" + e.toString());
            }
        }
    }

}
/*
---------------------
        作者：sutaotao_s77
        来源：CSDN
        原文：https://blog.csdn.net/sutaotao_s77/article/details/79251364
        版权声明：本文为博主原创文章，转载请附上博文链接！}
*/
