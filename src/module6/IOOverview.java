package module6;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class IOOverview {
    public static void main(String[] args) {

        // 1. 使用 File 类来操作文件和目录
        File file = new File("example.txt");
        System.out.println("file.exists() = " + file.exists());
        System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());

        // 2. 读写文件
        // 2.1 字节流  (不常用)
        try (FileOutputStream fos = new FileOutputStream(file);
             FileInputStream fis = new FileInputStream(file)) {
            String text = "hello java";
            fos.write(text.getBytes()); // 默认是覆盖的方式写入
            fos.flush(); // 将内存的数据刷到磁盘中

            // 创建byte数组，用于接收读取的字节流
            byte[] buffer = new byte[1024];
            int readLength = fis.read(buffer);
            String fromFile = new String(buffer, 0, readLength);
            System.out.println("读取到的内容是：" + fromFile);
            String append = fromFile + "\n hello IO";
            fos.write(append.getBytes());
            fos.flush(); // 将内存的数据刷到磁盘中


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // 2.2 字符流 = string
        try (FileWriter writer = new FileWriter(file);
             FileReader reader = new FileReader(file)) {
            writer.write("你好，java");
            writer.flush();
            char[] buffer = new char[1024];
            int readLength = reader.read(buffer);
            String fromFile = new String(buffer, 0, readLength);
            System.out.println("fromFile = " + fromFile);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        // 2.3 带缓冲的流  <--- 实际生产中用的最多
        // 装饰器模式：在原有类的基础上，增加一些额外的功能（增加了缓冲）
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("example2.txt"));
             BufferedReader br = new BufferedReader(new FileReader("example2.txt"))) {
            bw.write("这是第一段的数据，写入到文件中");
            bw.newLine();
            bw.write("这是第二段数据，继续往文件中写");
            bw.newLine();
            bw.newLine();
            bw.newLine();
            bw.newLine();
            bw.write("写完了，结束。");
            bw.flush();

            String line = null;
            while ((line = br.readLine()) != null) { // 如果为null，就是文件已经读完了
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // 3. NIO (new IO),是java 1.4引入的一个更加高效的文件和数据操作方式 (因为是后引入的，用的不是特别多，但是也推荐用）
        // 先获取路径（通过nio的方式）
        Path path = Paths.get("nio_example.txt");
        try{
            Files.write(path, "这是通过NIO写入的数据\n第二行数据".getBytes());

            List<String> strings = Files.readAllLines(path);
            for (String string : strings) {
                System.out.println(string);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        file.delete();

    }
}
