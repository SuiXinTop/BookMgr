package Control;

import java.sql.*;
import Model.User;

public class Rigester {
	static Connection con; // 声明Connection对象
	static Statement sql; // 声明Statement对象
	static ResultSet res; // 声明ResultSet对象

	/**
	 * 查询是否该账号已存在
	 * 
	 * @param user user_id
	 * @return boolean返回值，true表示不存在，false表示已存在
	 */
	public boolean selectuser(User user) {
		con = Connect.getConnection();
		try {
			PreparedStatement pt = con.prepareStatement("select count(*) from usertable where user_id=?");
			pt.setString(1, user.getUser_id());
			int count = 0;
			res = pt.executeQuery();
			if (res.next()) {
				count = res.getInt(1);
			}
			if (count == 0) {
				Connect.Closecon();
				return true;
			}
		} catch (Exception e) {
			//// e.printStackTrace();
			Connect.Closecon();
			return false;
		}
		Connect.Closecon();
		return false;
	}

	/**
	 * 注册
	 * 
	 * @param user user_id,user_name,user_age,user_sex,user_phone
	 * @return boolean返回值，true表示注册成功
	 */
	public boolean rigester(User user) {
		con = Connect.getConnection();
		try {
			PreparedStatement pt = con.prepareStatement("insert into usertable values(?,?,?,?,?,?)");
			pt.setString(1, user.getUser_id());
			pt.setString(2, user.getUser_name());
			pt.setString(3, user.getUser_sex());
			pt.setInt(4, user.getUser_age());
			pt.setString(5, user.getUser_phone());
			pt.setString(6, user.getUser_password());
			pt.executeUpdate();// 非select语句使用execute();
		} catch (SQLException e) {
			// e.printStackTrace();
			Connect.Closecon();
			return false;
		}
		Connect.Closecon();
		return true;
	}// 完成
}