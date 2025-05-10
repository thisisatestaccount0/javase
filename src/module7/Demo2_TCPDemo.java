package module7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

// 这个是tcp的服务端代码
public class Demo2_TCPDemo {

    public static void main(String[] args) {
        // TCP的服务端
        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            System.out.println("服务端已启动，监听端口为9999");
            // 如果客户端发起连接，这里就能接收到
            Socket client = serverSocket.accept();

            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String line = null;
            while ((line = br.readLine()) != null) { // 如果为null，就是文件已经读完了
                System.out.println("接收到客户端的消息："+line);
                if ("quit".equalsIgnoreCase(line)) {
                    break;
                }
            }

            br.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
