package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Returnbook;

public class Bookreturn {
	static Connection con; // 声明Connection对象
	static ResultSet res; // 声明ResultSet对象

	/**
	 * 查询该用户的还书记录
	 * 
	 * @param ret user_id
	 * @return String[][]
	 */
	public String[][] ShowReturn(Returnbook ret) {
		con = Connect.getConnection();
		try {
			int count = 0;
			PreparedStatement pt = con.prepareStatement("select COUNT(*) from book_return WHERE user_id= ?");
			pt.setString(1, ret.getUser_id());
			res = pt.executeQuery();
			if (res.next()) {
				count = res.getInt(1);
			}
			String[][] borr = new String[count + 1][7];
			pt = con.prepareStatement("SELECT DISTINCT book_return.book_id,book.book_name,"
					+ "book.book_author,book.book_pub,book_return.bor_date,book_return.fac_date\r\n"
					+ "		FROM book_return JOIN book \r\n" + "		ON book_return.book_id=book.book_id\r\n"
					+ "			WHERE user_id= ?" + "				ORDER BY	book_id");
			pt.setString(1, ret.getUser_id());
			res = pt.executeQuery();
			int i = 1;
			while (res.next()) { // 如果当前语句不是最后一条则进入循环
				for (int j = 1; j < borr[i].length; j++) {
					borr[i][j] = res.getString(j);
				}
				i++;
			}
			Connect.Closecon();
			return borr;
		} catch (Exception e) {
			// e.printStackTrace();
			Connect.Closecon();
			return null;
		}
	}

	/**
	 * 查询所有的还书记录
	 * 
	 * @return String[][]
	 */
	public String[][] ShowAllReturn() {
		con = Connect.getConnection();
		try {
			int count = 0;
			PreparedStatement pt = con.prepareStatement("select COUNT(*) from book_return");
			res = pt.executeQuery();
			if (res.next()) {
				count = res.getInt(1);
			}
			String[][] ret = new String[count + 1][7];

			pt = con.prepareStatement("SELECT DISTINCT book_return.user_id,book_return.book_id,book.book_name,\r\n"
					+ "				book.book_author,book.book_pub,book_return.bor_date,book_return.fac_date\r\n"
					+ "				FROM book_return JOIN book \r\n"
					+ "						ON book_return.book_id=book.book_id"
					+ "						ORDER BY	book_id");
			res = pt.executeQuery();
			int i = 1;
			while (res.next()) { // 如果当前语句不是最后一条则进入循环
				for (int j = 1; j < ret[i].length; j++) {
					ret[i][j] = res.getString(j);
				}
				i++;
			}
			Connect.Closecon();
			return ret;
		} catch (Exception e) {
			// e.printStackTrace();
			Connect.Closecon();
			return null;
		}
	}

	/**
	 * 向还书表中添加还书记录，并将book表中对应书的库存+1
	 * 
	 * @param ret boo_id,user_id,bor_date,fac_date
	 * @return boolean,true表示还书成功
	 * @throws SQLException
	 */
	public boolean ReturnBook(Returnbook ret) {
		con = Connect.getConnection();
		int stock = 0;
		try { // 查询借阅记录，并返回结果
			PreparedStatement pt = con.prepareStatement(
					"select bor_date from book_borrow " + "where book_id=? and user_id=? and book_tf='未归还'");
			pt.setString(1, ret.getBook_id());
			pt.setString(2, ret.getUser_id());
			res = pt.executeQuery();
			if (res.next()) {
				ret.setBor_date(res.getString(1));
			}
			if (ret.getBor_date() == null) {
				Connect.Closecon();
				return false;
			}

			// 查询该图书的库存
			pt = con.prepareStatement("select book_stock from book where book_id=?");
			pt.setString(1, ret.getBook_id());
			res = pt.executeQuery();
			if (res.next()) {
				stock = res.getInt(1);
			}

			GetDateTime g = new GetDateTime();
			ret.setFac_date(g.getdate());

			con.setAutoCommit(false);
			PreparedStatement x = con.prepareStatement("insert into book_return values(?,?,?,?)");
			x.setString(1, ret.getUser_id());
			x.setString(2, ret.getBook_id());
			x.setString(3, ret.getBor_date());
			x.setString(4, ret.getFac_date());

			PreparedStatement y = con.prepareStatement(
					"Update book_borrow set book_tf='已归还' " + "where book_id=? and user_id=? and bor_date=?");
			y.setString(1, ret.getBook_id());
			y.setString(2, ret.getUser_id());
			y.setString(3, ret.getBor_date());
			
			PreparedStatement z = con.prepareStatement("Update book set book_stock=? where book_id=?");
			z.setInt(1, stock + 1);
			z.setString(2, ret.getBook_id());

			x.executeUpdate();
			y.executeUpdate();
			z.executeUpdate();
			con.commit();// 同时提交
			con.setAutoCommit(true);

		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
			}
			Connect.Closecon();
			return false;
		}
		Connect.Closecon();
		return true;
	} // TODO
}
