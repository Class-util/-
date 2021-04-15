package Day10.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:TCP服务器端
 * User:吴博
 * Date:2021 04 15
 * Time:19:28
 */
public class TCPServer {
    private static final int port = 9002;
    public static void main(String[] args) throws IOException {
        //创建并启动服务器端
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("服务器已经启动");
        //等待客户端连接
        Socket clientSocket = serverSocket.accept();
        //执行至此，说明已经有客户端连接
        System.out.println(String.format("已经有客户端连接：IP：%s 端口号：%d",clientSocket.getInetAddress().getHostAddress(),
                clientSocket.getPort()));

        // jdk 7 try-resource
        //自动关闭源
        try(
                BufferedWriter bufferedWriter = new BufferedWriter(
                        new OutputStreamWriter(clientSocket.getOutputStream())
                );
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream())
                );
                Scanner sc = new Scanner(System.in);
        ){
            while (true){
                //接收客户端的消息
                String msg = bufferedReader.readLine();
                if(msg != null && !msg.equals("")){
                    System.out.println("客户端消息：" + msg);
                    //给客户端一个反馈信息
                    System.out.print("->");
                    String serMsg = sc.nextLine();
                    //通过\n来划分边界，读取时按行读取，不然会一直处于读取状态
                    bufferedWriter.write(serMsg + "\n");
                    //发送缓冲区-刷新操作,意味着立马将缓冲区的消息发送出去
                    bufferedWriter.flush();
                }
            }
        }

        /*
        //收发消息
        BufferedReader bufferedReader = null;
        try {
                bufferedReader =  new BufferedReader(
                    //获取输入流信息
                    new InputStreamReader(clientSocket.getInputStream())
            );
            //接收客户端的消息
            String msg = bufferedReader.readLine();
            System.out.println("客户端消息：" + msg);
        }finally {
            if(bufferedReader != null){
                bufferedReader.close();
            }
        }

        bufferedReader.close();
        //给客户端反馈消息
        BufferedWriter bufferedWriter = null;
        try {
                bufferedWriter = new BufferedWriter(
                    new OutputStreamWriter(clientSocket.getOutputStream())
            );
            String serMsg = "我收到了";
            //通过\n来划分边界，读取时按行读取，不然会一直处于读取状态
            bufferedWriter.write(serMsg + "\n");
            //发送缓冲区-刷新操作,意味着立马将缓冲区的消息发送出去
            bufferedWriter.flush();
        }finally {
            if(bufferedWriter != null){
                bufferedWriter.close();
            }
        }*/
    }
}
