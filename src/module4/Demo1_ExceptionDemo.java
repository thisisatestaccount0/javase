package module4;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class Demo1_ExceptionDemo {
    public static void main(String[] args) {

        //  Exception in thread "main" java.lang.ArithmeticException: / by zero
        //	at module4.Demo1_ExceptionDemo.main(Demo1_ExceptionDemo.java:8)
//        int i = 10 / 0 ;
        // 异常会中断我们程序的正常流程。
//        System.out.println(i);


        // 数组越界
        // ArrayIndexOutOfBoundsException
        int[] a = new int[3];
        a[0] = 0;
        a[1] = 0;
        a[2] = 0;
//        a[3] = 0;


        // NullPointerException
//        String s = null;
//        System.out.println("s.length() = " + s.length());


        // ClassCastException
        Object obj = Integer.valueOf(100);
        String str = (String) obj;
        System.out.println(str);



        // ===============以下是受检异常===============


        String url = "jdbc:mysql://localhost:3306/abcde";
        String user = "root";
        String password = "123456";

        // SQLException
        // Connection connction = DriverManager.getConnection(url, user, password);

        // FileNotFoundException
        // FileReader fr = new FileReader("test.txt");


        System.out.println("程序结束");


    }
}
