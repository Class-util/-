package Day10.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Created with IntelliJ IDEA.
 * Description:自定义HTTP服务器
 * User:吴博
 * Date:2021 04 15
 * Time:21:09
 */
//根据uri内容返回不同信息
public class MyHTTP {
    private static final int port = 9004;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("服务器已启动");
        Socket socket = serverSocket.accept();
        try(
                BufferedWriter bufferedWriter = new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream())
                );
                BufferedReader bufferedReader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                )
        ){
            //得到客户端信息
            //首行信息
            String firstLine = bufferedReader.readLine();
            String[] firstLineArr = firstLine.split(" ");
            //方法类型
            String method = firstLineArr[0];
            //uri
            String uri = firstLineArr[1];
            //http版本号
            String httpVersion = firstLineArr[2];
            System.out.println(String.format("首行信息：方法类型：%s,URI：%s,HTTP版本号：%s",method,uri,httpVersion));
            //构建内容返回内容
            String content = "";
            //如果uri中存在404,则赋值
            if(uri.contains("404")){
                content = "<h1>没有找到此页面</h1>";
            }
            if(uri.contains("200")){
                content = "<h1>你好，世界</h1>";
            }
            bufferedWriter.write(String.format("%s 200 ok",httpVersion) + "\n");
            bufferedWriter.write("Content-Type: text/html;charset=utf-8\n");
            bufferedWriter.write("Content-length: " + content.getBytes().length + "\n");
            bufferedWriter.write("\n");
            bufferedWriter.write(content);
            bufferedWriter.flush();
        }
    }
}
