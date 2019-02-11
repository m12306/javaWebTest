package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Description: JDBC数据库操作
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/11/27 19:00
 * @version : 1.0
 */
public class JDBCUtil {
    private static final String DB_URL = "jdbc:sqlite:D://dropbox/bookstore.db";
    private static final String DB_DRIVER = "org.sqlite.JDBC";
    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL);
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("连接数据库异常");
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
