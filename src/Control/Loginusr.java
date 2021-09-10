package Control;

import java.sql.*;

import Model.User;

public class Loginusr {
	static Connection con; // 声明Connection对象
	static Statement sql; // 声明Statement对象
	static ResultSet res; // 声明ResultSet对象

	/**
	 * 用户登陆验证
	 * 
	 * @param user user_id,user_password
	 * @return boolean，true表示登陆成功
	 */
	public boolean veriryusr(User user) {
		con = Connect.getConnection();
		try {
			PreparedStatement pt = con.prepareStatement("select COUNT(*) from usertable where user_id= ? and user_password= ?");
			pt.setString(1, user.getUser_id());
			pt.setString(2, user.getUser_password());
			res = pt.executeQuery();
			int count = 0;
			if (res.next()) {
				count = res.getInt(1);
			}
			if (count == 0) {
				Connect.Closecon();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Connect.Closecon();
			return false;
		}
		Connect.Closecon();
		return true;
	}// 完成

	/**
	 * 获取该用户的信息
	 * 
	 * @param user user_id
	 * @return User
	 */
	public User selectuser(User user) {
		con = Connect.getConnection();
		try {
			PreparedStatement pt = con.prepareStatement("select * from usertable where user_id=?");
			pt.setString(1, user.getUser_id());
			res = pt.executeQuery();
			if (res.next()) {
				user.setUser_name(res.getString(2));
				user.setUser_sex(res.getString(3));
				user.setUser_age(res.getInt(4));
				user.setUser_phone(res.getString(5));
			}
		} catch (Exception e) {
			// e.printStackTrace();
			Connect.Closecon();
			return user;
		}
		Connect.Closecon();
		return user;
	}// 完成

	/**
	 * 更改用户信息
	 * 
	 * @param user user_id,user_name,user_age,user_sex,user_phone
	 * @return boolean，true表示更改成功
	 */
	public boolean alteruser(User user) {
		con = Connect.getConnection();
		try {
			PreparedStatement pt = con.prepareStatement(
					"Update usertable set user_name=?,user_age=?," + "user_sex=?,user_phone=? where user_id=?");
			pt.setString(1, user.getUser_name());
			pt.setInt(2, user.getUser_age());
			pt.setString(3, user.getUser_sex());
			pt.setString(4, user.getUser_phone());
			pt.setString(5, user.getUser_id());
			int count = pt.executeUpdate();
			if (count == 0)
				return false;
		} catch (SQLException e) {
			Connect.Closecon();
			return false;
		}
		Connect.Closecon();
		return true;
	}

	/**
	 * 更改用户密码
	 * 
	 * @param user 获取user_id,user_password
	 * @return boolean，true表示更改成功
	 */
	public boolean alterpassword(User user) {
		con = Connect.getConnection();
		try {
			PreparedStatement pt = con.prepareStatement("Update usertable set user_password=? where user_id=?");
			pt.setString(1, user.getUser_password());
			pt.setString(2, user.getUser_id());
			int count = pt.executeUpdate();
			if (count == 0) {
				Connect.Closecon();
				return false;
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			Connect.Closecon();
			return false;
		}
		Connect.Closecon();
		return true;
	}
}
