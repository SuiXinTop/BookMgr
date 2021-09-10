package Control;

import java.sql.*;

import Model.Book;

public class Bookadmin {
	static Connection con; // ����Connection����
	static Statement sql; // ����Statement����
	static ResultSet res; // ����ResultSet����

	/**
	 * ���ͼ��
	 * 
	 * @param book book_id,book_name,book_author,book_pub,book_stock,book_sortid,book_record
	 * @return boolean,true��ʾ��ӳɹ�
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
	 * ɾ��ͼ��
	 * 
	 * @param book book_id
	 * @return boolean,true��ʾɾ���ɹ�
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
	}// ���

	/**
	 * �޸�ͼ����Ϣ
	 * 
	 * @param book book_id,book_name,book_author,book_pub,book_stock,book_sortid,book_record
	 * @return boolean,true��ʾ��ӳɹ�
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
	}// ���

}
