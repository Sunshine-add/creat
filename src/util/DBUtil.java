package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	public static Connection getConnection() throws ClassNotFoundException,
			SQLException, IOException {

		Properties properties = PropertiesUtil.getProperties();

		String driver = properties.getProperty("driver");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		String url = properties.getProperty("url");

		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, username,
				password);

		return connection;
	}

//	 public static Connection getConnection() throws ClassNotFoundException,
//	 SQLException, IOException {
//	
//	 Properties properties = new Properties();
//	 // getClassLoader : 获取类加载器
//	 // getResourceAsStream : 把资源转换为流
//	 // 这里 定位到src.所以可以直接写文件名,而流是定位到项目
//	 properties.load(DBUtil.class.getClassLoader().getResourceAsStream(
//	 "jdbc.properties"));
//	 // properties 本质就是一个map,可以通过key获取value
//	 // username=root 读取到之后,以 = 分隔为数组,把username作为key,root作为value保存
//	 // 所以我们就可以通过username 来获取root
//	 String driver = properties.getProperty("driver");
//	 String username = properties.getProperty("username");
//	 String password = properties.getProperty("password");
//	 String url = properties.getProperty("url");
//	
//	 Class.forName(driver);
//	 Connection connection = DriverManager.getConnection(url, username,
//	 password);
//	
//	 return connection;
//	 }

	/**
	 * Connection , ResultSet , Statement 都实现了AutoCloseable接口
	 * 
	 * PreparedStatement 继承了 Statement
	 */
	public static void close(AutoCloseable obj) {
		if (obj != null) {
			try {
				obj.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
