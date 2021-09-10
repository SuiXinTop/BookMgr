package Control;

import java.sql.*;

import Model.Admin;

public class Loginadm {
	static Connection con; // 声明Connection对象
	static Statement sql; // 声明Statement对象
	static ResultSet res; // 声明ResultSet对象

	/**
	 * 管理员登陆验证
	 * 
	 * @param admin adm_id,adm_password
	 * @return boolean返回值，true表示登陆成功
	 */
	public boolean veriryadm(Admin admin) {
		con = Connect.getConnection();
		try {
			PreparedStatement pt = con
					.prepareStatement("select count(*) from Admin where adm_id = ? and adm_password = ?");
			pt.setString(1, admin.getAdm_id());
			pt.setString(2, admin.getAdm_password());
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
			// e.printStackTrace();
			Connect.Closecon();

			return false;
		}
		Connect.Closecon();

		return true;
	}// 完成
}
