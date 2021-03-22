package Day10;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:吴博
 * Date:2021 03 22
 * Time:16:33
 */
public class Test03 {
    public static void main(String[] args) throws SQLException {
        //配置基本参数
        String url = "jdbc:mysql://127.0.1:3306/ebook?useSSL=false";
        String username = "root";
        String password = "120917981";
        //获取数据源
        DataSource dataSource = new MysqlDataSource();
        //设置参数，进行连接
        ((MysqlDataSource)dataSource).setURL(url);
        ((MysqlDataSource)dataSource).setUser(username);
        ((MysqlDataSource)dataSource).setPassword(password);
        //与数据源建立连接
        Connection connection = dataSource.getConnection();
        //执行sql语句
        String sql = "select * from student where name = ?";
        String a = "韩信";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //为了预防sql注入问题，所有采用PreparedStatement的预编译功能
        preparedStatement.setString(1,a);
        //获取结果集
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString(2));
        }
        resultSet.close();
    }
}
