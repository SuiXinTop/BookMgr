package Control;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

public class Connect {
	static Connection con = null; // 声明Connection对象
	static Statement sql = null; // 声明Statement对象
	static ResultSet res = null; // 声明ResultSet对象
	static BasicDataSource bds = null;
	/**
	 * 连接数据库方法
	 * 
	 * @return Connection
	 */
	static {
		Properties p = new Properties();
		try {
			p.load(new FileInputStream("src/jdbc.properties"));
			/**
			 * String driver = p.getProperty("driver"); String url = p.getProperty("url");
			 * String username = p.getProperty("username"); String password =
			 * p.getProperty("password"); 设置连接池参数 bds.setDriverClassName(driver);
			 * bds.setUrl(url); bds.setUsername(username); bds.setPassword(password);
			 * 
			 * // 初始化连接池数 bds.setInitialSize(5); // 最大活跃数 bds.setMaxActive(8); // 最大空闲数
			 * bds.setMaxIdle(4); // 最小空闲数 bds.setMinIdle(4); // 最大等待毫秒数 bds.setMaxWait(30);
			 */
			bds = (BasicDataSource) BasicDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {

			con = bds.getConnection();
			// Class.forName(driver);
			// con = DriverManager.getConnection(url, username, password);
			System.out.println("连接成功");
		} catch (Exception e) {
			// e.printStackTrace();
			// System.out.println("连接失败");
		}
		return con;
	}// 完成

	/**
	 * 关闭数据库连接
	 * 
	 */
	public static void Closecon() {
		try {
			if (con != null) {
				con.close();
				// System.out.println("连接关闭");
			}
		} catch (SQLException e) {
			// e.printStackTrace();
		}
	}// 完成

	/**
	 * 全闭
	 * 
	 */
	public static void closeAll() {
		try {
			if (con != null) {
				con.close();
			}
			if (sql != null) {
				sql.close();
			}
			if (res != null) {
				res.close();
			}
		} catch (Exception e) {
		}
	}

	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
