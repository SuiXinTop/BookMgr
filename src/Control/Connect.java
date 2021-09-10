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
	static Connection con = null; // ����Connection����
	static Statement sql = null; // ����Statement����
	static ResultSet res = null; // ����ResultSet����
	static BasicDataSource bds = null;
	/**
	 * �������ݿⷽ��
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
			 * p.getProperty("password"); �������ӳز��� bds.setDriverClassName(driver);
			 * bds.setUrl(url); bds.setUsername(username); bds.setPassword(password);
			 * 
			 * // ��ʼ�����ӳ��� bds.setInitialSize(5); // ����Ծ�� bds.setMaxActive(8); // ��������
			 * bds.setMaxIdle(4); // ��С������ bds.setMinIdle(4); // ���ȴ������� bds.setMaxWait(30);
			 */
			bds = (BasicDataSource) BasicDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		try {

			con = bds.getConnection();
			// Class.forName(driver);
			// con = DriverManager.getConnection(url, username, password);
			System.out.println("���ӳɹ�");
		} catch (Exception e) {
			// e.printStackTrace();
			// System.out.println("����ʧ��");
		}
		return con;
	}// ���

	/**
	 * �ر����ݿ�����
	 * 
	 */
	public static void Closecon() {
		try {
			if (con != null) {
				con.close();
				// System.out.println("���ӹر�");
			}
		} catch (SQLException e) {
			// e.printStackTrace();
		}
	}// ���

	/**
	 * ȫ��
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
