package Control;

import java.sql.*;

import Model.Book;

public class Bookadmin {
	static Connection con; // 声明Connection对象
	static Statement sql; // 声明Statement对象
	static ResultSet res; // 声明ResultSet对象

	/**
	 * 添加图书
	 * 
	 * @param book book_id,book_name,book_author,book_pub,book_stock,book_sortid,book_record
	 * @return boolean,true表示添加成功
	 */
	public boolean add(Book book) {
		con = Connect.getConnection();
		try {
			PreparedStatement pt = con.prepareStatement("insert into book values(?,?,?,?,?,?,?)");
			pt.setString(1, book.getBook_id());
			pt.setString(2, book.getBook_name());
			pt.setString(3, book.getBook_author());
			pt.setString(4, book.getBook_pub());
			pt.setInt(5, book.getBook_stock());
			pt.setString(6, book.getBook_sortid());
			pt.setString(7, book.getBook_record());
			pt.executeUpdate();
		} catch (SQLException e) {
			// e.printStackTrace();
			Connect.Closecon();
			return false;
		}
		Connect.Closecon();
		return true;
	}// DONE

	/**
	 * 删除图书
	 * 
	 * @param book book_id
	 * @return boolean,true表示删除成功
	 */
	public boolean delete(Book book) {
		con = Connect.getConnection();
		try {
			PreparedStatement pt = con.prepareStatement("Delete from book where book_id=?");
			pt.setString(1, book.getBook_id());
			int count = pt.executeUpdate();
			Connect.Closecon();
			if (count > 0) {
				Connect.Closecon();
				return true;
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			Connect.Closecon();
			return false;
		}
		Connect.Closecon();
		return false;
	}// 完成

	/**
	 * 修改图书信息
	 * 
	 * @param book book_id,book_name,book_author,book_pub,book_stock,book_sortid,book_record
	 * @return boolean,true表示添加成功
	 */
	public boolean alter(Book book) {
		con = Connect.getConnection();
		try {
			PreparedStatement pt = con.prepareStatement("update book set book_name=?, book_author=?,"
					+ "book_pub=?,book_stock=?,book_sortid=? where book_id=?");
			pt.setString(1, book.getBook_name());
			pt.setString(2, book.getBook_author());
			pt.setString(3, book.getBook_pub());
			pt.setInt(4, book.getBook_stock());
			pt.setString(5, book.getBook_sortid());
			pt.setString(6, book.getBook_id());
			int count = pt.executeUpdate();
			Connect.Closecon();
			if (count > 0) {
				Connect.Closecon();
				return true;
			}
		} catch (SQLException e) {
			// e.printStackTrace();
			Connect.Closecon();
			return false;
		}
		Connect.Closecon();
		return false;
	}// 完成

}
