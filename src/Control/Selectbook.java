package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import Model.Book;

public class Selectbook {
	static Connection con; // ����Connection����
	static Statement sql; // ����Statement����
	static ResultSet res; // ����ResultSet����

	/**
	 * ��ѯbook���ö�ά���鴫��book������в���
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
			String[][] allbook = new String[count + 1][8];// ����book�Ķ�ά����
			pt = con.prepareStatement("SELECT DISTINCT book.book_id,book.book_name, book_sort.sort_name ,"
					+ "book.book_author,book.book_pub,book.book_stock,book.book_record" + "	FROM book JOIN book_sort"
					+ "		ON book.book_sortid=book_sort.sort_id" + "			ORDER BY book_id");
			res = pt.executeQuery();
			int i = 1;
			while (res.next()) { // �����ǰ��䲻�����һ�������ѭ��
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
	 * ��book_id������ѯbook����������Ϣ,�༭ͼ����Ϣ��ǰ��
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
	}// ���

	/**
	 * ��book_idΪ������ѯͼ��
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
			String[][] allbook = new String[count + 1][8];// ����book�Ķ�ά����
			pt = con.prepareStatement("SELECT DISTINCT book.book_id,book.book_name, book_sort.sort_name ,"
					+ "book.book_author,book.book_pub,book.book_stock,book.book_record" + "	FROM book JOIN book_sort"
					+ "		ON book.book_sortid=book_sort.sort_id" + "			WHERE book.book_id=?");
			pt.setString(1, book.getBook_id());
			res = pt.executeQuery();
			int i = 1;
			while (res.next()) { // �����ǰ��䲻�����һ�������ѭ��
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
	 * ��book_nameģ����ѯͼ��
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
			String[][] allbook = new String[count + 1][8];// ����book�Ķ�ά����
			pt = con.prepareStatement("SELECT DISTINCT book.book_id,book.book_name, book_sort.sort_name ,"
					+ "book.book_author,book.book_pub,book.book_stock,book.book_record" + "	FROM book JOIN book_sort"
					+ "		ON book.book_sortid=book_sort.sort_id" + "			WHERE book.book_name Like ?"
					+ "			ORDER BY book_id ");
			pt.setString(1, book.getBook_name());
			res = pt.executeQuery();
			int i = 1;
			while (res.next()) { // �����ǰ��䲻�����һ�������ѭ��
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
	 * ��book_authorΪ������ѯͼ��
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

			String[][] allbook = new String[count + 1][8];// ����book�Ķ�ά����
			pt = con.prepareStatement("SELECT DISTINCT book.book_id,book.book_name, book_sort.sort_name ,"
					+ "book.book_author,book.book_pub,book.book_stock,book.book_record" + "	FROM book JOIN book_sort"
					+ "		ON book.book_sortid=book_sort.sort_id" + "			WHERE book.book_author Like ?"
					+ "				ORDER BY	book_id");
			pt.setString(1, book.getBook_author());
			res = pt.executeQuery();
			int i = 1;
			while (res.next()) { // �����ǰ��䲻�����һ�������ѭ��
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
