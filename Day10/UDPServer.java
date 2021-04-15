package Day10;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:UDP服务器端
 * User:吴博
 * Date:2021 04 15
 * Time:15:58
 */
public class UDPServer {
    private static final int bleng = 1024;
    private static final int port = 9001;
    public static void main(String[] args) throws IOException {
        //1.启动一个udp服务器端,ip是动态生成的，默认是电脑的ip
        DatagramSocket socket = new DatagramSocket(UDPServer.port);
        System.out.println("服务器启动");
        while (true){
            //检测有无连接,等待客户端连接
            //初始化数据包
            DatagramPacket client = new DatagramPacket(
                    new byte[bleng],
                    bleng
            );
            //等待客户端连接（正式执行）
            socket.receive(client);
            //执行至此，有客户端连接
            String msg = new String(client.getData());
            System.out.println("客户端信息为：" + msg.trim());
            //给客户端响应
            String serMsg = msg.replace("吗？",",");
            DatagramPacket dp = new DatagramPacket(
                    serMsg.getBytes(),
                    serMsg.getBytes().length,
                    client.getAddress(),
                    client.getPort()
            );
            socket.send(dp);
        }
    }
}
