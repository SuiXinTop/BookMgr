package Control;

import java.sql.*;
import Model.User;

public class Rigester {
	static Connection con; // ����Connection����
	static Statement sql; // ����Statement����
	static ResultSet res; // ����ResultSet����

	/**
	 * ��ѯ�Ƿ���˺��Ѵ���
	 * 
	 * @param user user_id
	 * @return boolean����ֵ��true��ʾ�����ڣ�false��ʾ�Ѵ���
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
	 * ע��
	 * 
	 * @param user user_id,user_name,user_age,user_sex,user_phone
	 * @return boolean����ֵ��true��ʾע��ɹ�
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
			pt.executeUpdate();// ��select���ʹ��execute();
		} catch (SQLException e) {
			// e.printStackTrace();
			Connect.Closecon();
			return false;
		}
		Connect.Closecon();
		return true;
	}// ���
}