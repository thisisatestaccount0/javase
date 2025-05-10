package module7;

import java.io.*;
import java.net.Socket;

public class Demo2_TcpClientDemo {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 9999);
            OutputStream out = socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
            // 我们通过控制台输入信息，不停的往 tcp服务端发送数据
            // 读取控制台的数据
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String inputString;
            System.out.println("请输入要发送给服务端的消息（输入quit则退出程序）：");
            while (true) {
                System.out.println("> ");
                inputString = br.readLine();
                if("quit".equalsIgnoreCase(inputString)) {
                    break;
                }
                bw.write(inputString + "\n");
                bw.flush();
            }

            out.close();
            bw.close();
            br.close();
            socket.close();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
