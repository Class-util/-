package Day10.tcp;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 04 15
 * Time:19:59
 */
public class TCPClient {
    private static final String ip = "127.0.0.1";
    private static final int port = 9003;
    public static void main(String[] args) throws IOException {
        //创建并启动客户端,顺便连服务器
        Socket socket = new Socket(ip,port);
        try(
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream())
                );
                Scanner sc = new Scanner(System.in);
        ){

            while (true){
                //发送消息
                System.out.print("->");
                String msg = sc.nextLine();
                writer.write(msg + "\n");
                writer.flush();
                //接收消息
                String serMsg = reader.readLine();
                if(serMsg != null && !serMsg.equals("")){
                    System.out.println("服务器端说：" + serMsg);
                }
            }
        }
    }
}
