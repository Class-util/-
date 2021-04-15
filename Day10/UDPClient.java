package Day10;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 04 15
 * Time:16:13
 */
public class UDPClient {
    //服务器ip
    private static final String ip = "127.0.0.1";
    private static final int port = 9001;
    private static final int bleng = 1024;
    public static void main(String[] args) throws IOException {
        //1.启动客户端
        DatagramSocket client = new DatagramSocket();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.print("我：");
            String msg = sc.nextLine();
            DatagramPacket dp = new DatagramPacket(
                    msg.getBytes(),
                    msg.getBytes().length,
                    InetAddress.getByName(ip),
                    port
            );
            client.send(dp);
            DatagramPacket da1 = new DatagramPacket(
                    new byte[bleng],
                    bleng
            );
            client.receive(da1);
            String SerMsg = new String(da1.getData());
            System.out.println("对方：" + SerMsg.trim());
        }
    }
}
