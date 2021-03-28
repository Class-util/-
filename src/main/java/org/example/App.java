package org.example;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        //System.out.println( "Hello World!" );
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://127.0.0.1:3306/java18?useSSL=false");
        dataSource.setUser("root");
        dataSource.setPassword("120917981");
        Connection connection = dataSource.getConnection();
        String sql = "select * from student where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,2);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString("name"));
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
