package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Borrowbook;

public class Bookborrow {
	static Connection con; // 声明Connection对象
	static Statement sql; // 声明Statement对象
	static ResultSet res; // 声明ResultSet对象

	/**
	 * 查询该用户的借书记录
	 * 
	 * @param borrow user_id
	 * @return String[]
	 */
	public String[][] ShowBorrow(Borrowbook borrow) {
		con = Connect.getConnection();
		try {
			int count = 0;
			PreparedStatement pt = con.prepareStatement("select COUNT(*) from book_borrow where user_id=?");
			pt.setString(1, borrow.getUser_id());
			res = pt.executeQuery();
			if (res.next()) {
				count = res.getInt(1);
			}
			String[][] borr = new String[count + 1][8];
			pt = con.prepareStatement("SELECT DISTINCT book_borrow.book_id,book.book_name,"
					+ "book.book_author,book.book_pub,book_borrow.bor_date,book_borrow.exc_date,book_borrow.book_tf\r\n"
					+ "		FROM book_borrow JOIN book \r\n" + "		ON book_borrow.book_id=book.book_id\r\n"
					+ "			WHERE user_id= ?" + "				ORDER BY book_id");
			pt.setString(1, borrow.getUser_id());
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
	 * 查询该用户未归还的借书记录的book_id,bor_date
	 * 
	 * @param borrow user_id
	 * @return String[]
	 */
	public Borrowbook ShowBorrowfalse(Borrowbook borrow) {
		con = Connect.getConnection();
		borrow.setBook_id("");
		borrow.setBor_date("");
		try {
			PreparedStatement pt = con
					.prepareStatement("SELECT book_id,bor_date From book_borrow WHERE user_id= ? and book_tf='未归还'");
			pt.setString(1, borrow.getUser_id());
			res = pt.executeQuery();
			if (res.next()) { // 如果当前语句不是最后一条则进入循环
				borrow.setBook_id(res.getString(1));
				borrow.setBor_date(res.getString(2));
			}
			Connect.Closecon();
			return borrow;
		} catch (Exception e) {
			// e.printStackTrace();
			Connect.Closecon();
			return null;
		}
	}

	/**
	 * 查询所有的借书记录
	 * 
	 * @return String[]
	 */
	public String[][] ShowAllBorrow() {
		con = Connect.getConnection();
		try {
			int count = 0;
			PreparedStatement pt = con.prepareStatement("select COUNT(*) from book_borrow");
			res = pt.executeQuery();
			if (res.next()) {
				count = res.getInt(1);
			}
			String[][] borr = new String[count + 1][8];
			pt = con.prepareStatement("SELECT DISTINCT book_borrow.book_id,book.book_name,"
					+ "book.book_author,book.book_pub,book_borrow.bor_date,book_borrow.exc_date,book_borrow.book_tf\r\n"
					+ "		FROM book_borrow JOIN book \r\n" + "		ON book_borrow.book_id=book.book_id"
					+ "			ORDER BY book_id");
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
	 * 向还书表中添加记录，并对book表中对应书的库存-1
	 *
	 * @param borrow user_id,book_id,bor_date,ret_date
	 * @return boolean,true表示借书成功
	 */
	public boolean BorrowBook(Borrowbook borrow) {
		con = Connect.getConnection();
		int stock = 0;
		try {
			// 查询该用户是否还有未归还的图书
			PreparedStatement pt = con
					.prepareStatement("select COUNT(*) from book_borrow where user_id=? and book_tf='未归还'");
			pt.setString(1, borrow.getUser_id());
			res = pt.executeQuery();
			if (res.next()) {
				int count = res.getInt(1);
				if (count != 0) {
					Connect.Closecon();
					return false;
				}
			}
			// 查询该图书的库存
			pt = con.prepareStatement("select book_stock from book where book_id=?");
			pt.setString(1, borrow.getBook_id());
			res = pt.executeQuery();
			if (res.next()) {
				stock = res.getInt(1);
			}
			if (stock < 0 || stock == 0) {
				Connect.Closecon();
				return false;
			}
			// 获取时间
			GetDateTime g = new GetDateTime();
			borrow.setBor_date(g.getdate());
			borrow.setRet_date(g.getdateplus());

			con.setAutoCommit(false);

			PreparedStatement x = con.prepareStatement("insert into book_borrow values(?,?,?,?,?)");
			x.setString(1, borrow.getUser_id());
			x.setString(2, borrow.getBook_id());
			x.setString(3, borrow.getBor_date());
			x.setString(4, borrow.getRet_date());
			x.setString(5, "未归还");
			x.addBatch();
			x.executeBatch();

			x = con.prepareStatement("Update book set book_stock=? where book_id=?");
			x.setInt(1, stock - 1);
			x.setString(2, borrow.getBook_id());
			x.addBatch();
			x.executeBatch();

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
	}// 待测试

}
