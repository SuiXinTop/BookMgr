package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Model.Book;

public class Selectbook {
	static Connection con; // 声明Connection对象
	static Statement sql; // 声明Statement对象
	static ResultSet res; // 声明ResultSet对象

	/**
	 * 查询book表，用二维数组传递book表的所有参数
	 * 
	 * @return String[][]
	 */
	public String[][] ShowAllBook() {
		con = Connect.getConnection();
		try {
			int count = 0;
			PreparedStatement pt = con.prepareStatement("select COUNT(*) from book");
			res = pt.executeQuery();
			if (res.next()) {
				count = res.getInt(1);
			}
			String[][] allbook = new String[count + 1][8];// 属于book的二维数组
			pt = con.prepareStatement("SELECT DISTINCT book.book_id,book.book_name, book_sort.sort_name ,"
					+ "book.book_author,book.book_pub,book.book_stock,book.book_record" + "	FROM book JOIN book_sort"
					+ "		ON book.book_sortid=book_sort.sort_id" + "			ORDER BY book_id");
			res = pt.executeQuery();
			int i = 1;
			while (res.next()) { // 如果当前语句不是最后一条则进入循环
				for (int j = 1; j < allbook[i].length; j++) {
					allbook[i][j] = res.getString(j);
				}
				i++;
			}
			Connect.Closecon();
			return allbook;
		} catch (Exception e) {
			// e.printStackTrace();
			Connect.Closecon();
			return null;
		}
	}

	/**
	 * 按book_id条件查询book表，并返回信息,编辑图书信息的前置
	 * 
	 * @param book book_id
	 * @return book
	 *         book_id,book_name,book_author,book_pub,book_stock,book_sortid,book_record
	 */
	public Book select(Book book) {
		con = Connect.getConnection();
		try {
			PreparedStatement pt = con.prepareStatement("SELECT * FROM book WHERE book_id=?");
			pt.setString(1, book.getBook_id());
			res = pt.executeQuery();
			while (res.next()) {
				book.setBook_name(res.getString(2));
				book.setBook_author(res.getString(3));
				book.setBook_pub(res.getString(4));
				book.setBook_stock(res.getInt(5));
				book.setBook_sortid(res.getString(6));
				book.setBook_record(res.getString(7));
			}
		} catch (Exception e) {
			// e.printStackTrace();
			Connect.Closecon();
			return book;
		}
		Connect.Closecon();
		return book;
	}// 完成

	/**
	 * 以book_id为条件查询图书
	 * 
	 * @param book book_id
	 * @return String[][]
	 */
	public String[][] ShowAidBook(Book book) {
		con = Connect.getConnection();
		try {
			int count = 0;
			PreparedStatement pt = con.prepareStatement("select COUNT(*) from book WHERE book_id=?");
			pt.setString(1, book.getBook_id());
			res = pt.executeQuery();
			if (res.next()) {
				count = res.getInt(1);
			}
			String[][] allbook = new String[count + 1][8];// 属于book的二维数组
			pt = con.prepareStatement("SELECT DISTINCT book.book_id,book.book_name, book_sort.sort_name ,"
					+ "book.book_author,book.book_pub,book.book_stock,book.book_record" + "	FROM book JOIN book_sort"
					+ "		ON book.book_sortid=book_sort.sort_id" + "			WHERE book.book_id=?");
			pt.setString(1, book.getBook_id());
			res = pt.executeQuery();
			int i = 1;
			while (res.next()) { // 如果当前语句不是最后一条则进入循环
				for (int j = 1; j < allbook[i].length; j++) {
					allbook[i][j] = res.getString(j);
				}
				i++;
			}
			Connect.Closecon();
			return allbook;
		} catch (Exception e) {
			// e.printStackTrace();
			Connect.Closecon();
			return null;
		}
	}

	/**
	 * 以book_name模糊查询图书
	 * 
	 * @param book book_name
	 * @return String[][]
	 */
	public String[][] ShowAnameBook(Book book) {
		con = Connect.getConnection();
		try {
			int count = 0;
			PreparedStatement pt = con.prepareStatement("select COUNT(*) from book WHERE book_name Like ?");
			pt.setString(1, book.getBook_name());
			res = pt.executeQuery();
			if (res.next()) {
				count = res.getInt(1);
			}
			String[][] allbook = new String[count + 1][8];// 属于book的二维数组
			pt = con.prepareStatement("SELECT DISTINCT book.book_id,book.book_name, book_sort.sort_name ,"
					+ "book.book_author,book.book_pub,book.book_stock,book.book_record" + "	FROM book JOIN book_sort"
					+ "		ON book.book_sortid=book_sort.sort_id" + "			WHERE book.book_name Like ?"
					+ "			ORDER BY book_id ");
			pt.setString(1, book.getBook_name());
			res = pt.executeQuery();
			int i = 1;
			while (res.next()) { // 如果当前语句不是最后一条则进入循环
				for (int j = 1; j < allbook[i].length; j++) {
					allbook[i][j] = res.getString(j);
				}
				i++;
			}
			Connect.Closecon();
			return allbook;
		} catch (Exception e) {
			// e.printStackTrace();
			Connect.Closecon();
			return null;
		}
	}

	/**
	 * 以book_author为条件查询图书
	 * 
	 * @param book book_author
	 * @return String[][]
	 */
	public String[][] ShowAauthorBook(Book book) {
		con = Connect.getConnection();
		try {
			int count = 0;
			PreparedStatement pt = con.prepareStatement("select COUNT(*) from book WHERE book_author Like ?");
			pt.setString(1, book.getBook_author());
			res = pt.executeQuery();
			if (res.next()) {
				count = res.getInt(1);
			}

			String[][] allbook = new String[count + 1][8];// 属于book的二维数组
			pt = con.prepareStatement("SELECT DISTINCT book.book_id,book.book_name, book_sort.sort_name ,"
					+ "book.book_author,book.book_pub,book.book_stock,book.book_record" + "	FROM book JOIN book_sort"
					+ "		ON book.book_sortid=book_sort.sort_id" + "			WHERE book.book_author Like ?"
					+ "				ORDER BY	book_id");
			pt.setString(1, book.getBook_author());
			res = pt.executeQuery();
			int i = 1;
			while (res.next()) { // 如果当前语句不是最后一条则进入循环
				for (int j = 1; j < allbook[i].length; j++) {
					allbook[i][j] = res.getString(j);
				}
				i++;
			}
			Connect.Closecon();
			return allbook;
		} catch (Exception e) {
			// e.printStackTrace();
			Connect.Closecon();
			return null;
		}
	}
}
