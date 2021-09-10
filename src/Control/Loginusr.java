package Control;

import java.sql.*;

import Model.User;

public class Loginusr {
	static Connection con; // ����Connection����
	static Statement sql; // ����Statement����
	static ResultSet res; // ����ResultSet����

	/**
	 * �û���½��֤
	 * 
	 * @param user user_id,user_password
	 * @return boolean��true��ʾ��½�ɹ�
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
	}// ���

	/**
	 * ��ȡ���û�����Ϣ
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
	}// ���

	/**
	 * �����û���Ϣ
	 * 
	 * @param user user_id,user_name,user_age,user_sex,user_phone
	 * @return boolean��true��ʾ���ĳɹ�
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
	 * �����û�����
	 * 
	 * @param user ��ȡuser_id,user_password
	 * @return boolean��true��ʾ���ĳɹ�
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
