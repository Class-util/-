package Day10.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 04 15
 * Time:20:42
 */
public class TCPServerByCN {
    private static final int port = 9003;

    static HashMap<String,String> dirMap = new HashMap<>();

    static {
        dirMap.put("hello","你好");
        dirMap.put("cat","猫");
        dirMap.put("dog","狗");
    }

    public static void main(String[] args) throws IOException {
        //创建tcp服务器端
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("服务器已启动");
        Socket socket = serverSocket.accept();
        System.out.println(String.format("已经有客户端连接：IP：%s 端口号：%d",socket.getInetAddress().getHostAddress(),
                socket.getPort()));
        try(
                BufferedWriter bufferedWriter = new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream())
                );
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                )
        ){
            while (true){
                String en = bufferedReader.readLine();
                if(en != null && !en.equals("")){
                    String cn = processData1(en);
                    bufferedWriter.write(cn + "\n");
                    bufferedWriter.flush();
                }
            }
        }
    }

    private static String processData1(String en){
        String cn = null;
        cn = dirMap.get(en);
        return cn == null ? "未知":cn;
    }
    //todo:英译汉
    private static String processData(String en) {
        String cn = "";
        switch (en){
            case "hello": cn = "你好";
            break;
            case "cat": cn = "猫";
            break;
            case "dog": cn = "狗";
            break;
            case "pig": cn = "猪";
            break;
            default:cn = "未知";
        }
        return cn;
    }
}
