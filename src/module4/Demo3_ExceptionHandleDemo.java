package module4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Demo3_ExceptionHandleDemo {
    public static void main(String[] args) throws FileNotFoundException {
        // 异常处理，通常是针对受检异常
        // FileNotFoundException
        try {
            FileReader fr = new FileReader("test.txt");

            // 遇到第一个异常，就会跳转到 catch 语句中
            System.out.println("不会输出这句话，因为前面有异常，跳转到catch块了");

        } catch (FileNotFoundException e) {
            System.err.println("文件不存在，请输入正确的文件路径和文件名称");
            try{
                FileReader fr = new FileReader("test.txt");
            }catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }

        try{
            String url = "jdbc:mysql://localhost:3306/abcde";
            String user = "root";
            String password = "123456";

            // SQLException
            Connection connction = DriverManager.getConnection(url, user, password);
            System.out.println("不会输出这句话，因为前面有异常，跳转到catch块了");
        } catch (SQLException e) {
            System.err.println("数据库连接失败，可能是url不正确，或者是账号密码不正确，请检查");
        }

        try{
            int i = 10 / 0 ;
        }catch (Exception e) {
            System.err.println("除数不能为0");
        }



        // 通过finally 对资源进行回收
        FileReader fr = null;
        try {
            fr = new FileReader("test.txt");
            // 遇到第一个异常，就会跳转到 catch 语句中
            System.out.println("不会输出这句话，因为前面有异常，跳转到catch块了");

        } catch (FileNotFoundException e) {
            System.err.println("文件不存在，请输入正确的文件路径和文件名称");
        } finally {
            if(fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        // jdk7+
        // try with resources，代替原来finally的写法
        try (FileReader fr1 = new FileReader("test.txt")) {
            System.out.println("继续往下处理...");
        } catch (IOException e) {
            System.err.println("文件不存在，请输入正确的文件路径和文件名称");
        }


        // ============ 我不处理了，直接抛出去，这种方式后续的代码不会再运行（程序中断了）
        // 通常不推荐这么做，但是取决于具体的业务逻辑
        FileReader fr1 = new FileReader("test.txt");


        System.out.println("程序结束");




    }
}
