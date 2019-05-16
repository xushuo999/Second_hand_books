package zzz;

import java.awt.image.RescaleOp;
import java.security.interfaces.RSAKey;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class test {
	    public static void main(String[] args) {
	   
			Connection connection=JDBCUtils.getConnection();
		
      PreparedStatement preparedStatement=null;
      ResultSet resultSet=null;
      //查询
      String sql1="SELECT * FROM `user` where username=?";
      //添加
      String  sql2="insert into user(username,password) VALUES (?,?);";
      //修改
      String sql3="UPDATE user set `password`=?  WHERE username=?";
      //删除
      String sql4="delete from user  WHERE username=?";
      
      //1...查询
	try {
		preparedStatement = (PreparedStatement) connection.prepareStatement(sql1);
		preparedStatement.setString(1, "111");
		resultSet=preparedStatement.executeQuery();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  
      try {
		while (resultSet.next()) {
			System.out.println("用户名："+resultSet.getString(1));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
             
	//2.添加 
	    try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql2);
			preparedStatement.setString(1, "111");
			preparedStatement.setString(2,"5556");
			int num=preparedStatement.executeUpdate();
			if(num==1)
				System.out.println("添加成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  

	    //3.修改
	      try {
				preparedStatement = (PreparedStatement) connection.prepareStatement(sql3);
				preparedStatement.setString(1, "8888");
				preparedStatement.setString(2,"111");
				int num=preparedStatement.executeUpdate();
				if(num>0)
					System.out.println("修改成功");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    //4...删除
	      try {
				preparedStatement = (PreparedStatement) connection.prepareStatement(sql4);
				preparedStatement.setString(1,"111");
				int num=preparedStatement.executeUpdate();
				if(num>0)
					System.out.println("成功删除"+num+"个数据");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      
	      
	      JDBCUtils.release(connection, preparedStatement, resultSet);
	    }
}
