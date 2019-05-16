package zzz;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class JDBCUtils {
	public static String dirverClass;
    public static String url;
    public static String user;
    public static String password;
     /*
      * 1. 静态代码块 加载db.properties中的数据和注册驱动
      * */
    static {
        ClassLoader classLoader = JDBCUtils.class.getClassLoader();
        InputStream inStream = classLoader.getResourceAsStream("db.properties");
        Properties properties = new Properties();
        try {
            properties.load(inStream);
            dirverClass = properties.getProperty("dirverClass");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
             
            Class.forName(dirverClass);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取连接
     *
     * @throws ClassNotFoundException
     */
    public static Connection getConnection() {
        // 2.加载驱动，获得链接
        Connection connection = null;
        try {
            connection = (Connection) DriverManager.getConnection(url, user, password);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    /**
     * 3. 释放资源，注意资源的释放顺序
     */
    public static void release(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
