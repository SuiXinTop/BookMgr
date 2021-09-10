package Control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.BookSort;

public class BookType {
	static Connection con = null; // ����Connection����
	static Statement sql = null; // ����Statement����
	static ResultSet res = null; // ����ResultSet����

	/**
	 * ͨ��sort_id��ѯsort
	 * 
	 * @param sort sort_id
	 * @return sort
	 */
	public BookSort selectsort(BookSort sort) {
		con = Connect.getConnection();
		try {
			PreparedStatement pt = con.prepareStatement("select * from book_sort where sort_id=?");
			pt.setString(1, sort.getSort_id());
			res = pt.executeQuery();
			if (res.next()) {
				sort.setSort_id(res.getString(1));
				sort.setSort_name(res.getString(2));
				sort.setSort_text(res.getString(3));
			}
		} catch (Exception e) {
			// e.printStackTrace();
			Connect.Closecon();
			return sort;
		}
		Connect.Closecon();
		return sort;
	}

	/**
	 * ��ѯ����sort
	 * 
	 * @return String[]
	 */
	public String[] selectsortname() {
		con = Connect.getConnection();
		int count = 0;
		try {
			PreparedStatement pt = con.prepareStatement("select count(*) from book_sort");
			res = pt.executeQuery();
			if (res.next()) {
				count = res.getInt(1);
			}
			String str[] = new String[count + 1];
			pt = con.prepareStatement("select sort_name from book_sort");
			res = pt.executeQuery();
			int i = 1;
			while (res.next()) {
				str[i] = res.getString(1);
				i++;
			}
			Connect.Closecon();
			return str;
		} catch (Exception e) {
			// e.printStackTrace();
			Connect.Closecon();
			return null;
		}
	}

	/**
	 * ͨ��sort_id��ѯsort_name
	 * 
	 * @param sort sort_id
	 * @return sort sort_name
	 */
	public BookSort selectsortname(BookSort sort) {
		con = Connect.getConnection();
		try {
			PreparedStatement pt = con.prepareStatement("select sort_name from book_sort where sort_id=?");
			pt.setString(1, sort.getSort_id());
			res = pt.executeQuery();
			if (res.next()) {
				sort.setSort_name(res.getString(1));
			}
		} catch (Exception e) {
			// e.printStackTrace();
			Connect.Closecon();
			return sort;
		}
		Connect.Closecon();
		return sort;
	}

	/**
	 * ͨ��sort_name��ѯsort_id
	 * 
	 * @param sort sort_name
	 * @return sort sort_id
	 */
	public BookSort selectsortid(BookSort sort) {
		con = Connect.getConnection();
		try {
			PreparedStatement pt = con.prepareStatement("select sort_id from book_sort where sort_name=?");
			pt.setString(1, sort.getSort_name());
			res = pt.executeQuery();
			if (res.next()) {
				sort.setSort_id(res.getString(1));
			}
		} catch (Exception e) {
			// e.printStackTrace();
			Connect.Closecon();
			return sort;
		}
		Connect.Closecon();
		return sort;
	}

	/**
	 * ���ͼ������
	 * 
	 * @param sort sort_id,sort_name,sort_text
	 * @return boolean,true��ʾ��ӳɹ�
	 */
	public boolean addsort(BookSort sort) {
		con = Connect.getConnection();
		try {
			PreparedStatement pt = con.prepareStatement("insert into book_sort values(?,?,?)");
			pt.setString(1, sort.getSort_id());
			pt.setString(2, sort.getSort_name());
			pt.setString(3, sort.getSort_text());
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

	/**
	 * �޸�ͼ��������Ϣ
	 * 
	 * @param sort sort_id,sort_name,sort_text
	 * @return boolean,true��ʾ�޸ĳɹ�
	 */
	public boolean altersort(BookSort sort) {
		con = Connect.getConnection();
		try {
			PreparedStatement pt = con.prepareStatement("update book_sort set sort_name=?,sort_text=? where sort_id=?");
			pt.setString(1, sort.getSort_name());
			pt.setString(2, sort.getSort_text());
			pt.setString(3, sort.getSort_id());
			int count = pt.executeUpdate();
			if (count == 0) {
				Connect.Closecon();
				return false;
			}
		} catch (SQLException e) {
			// e.printStackTrace();
		}
		Connect.Closecon();
		return true;
	}

	/**
	 * ɾ��ͼ������
	 * 
	 * @param sort sort_id
	 * @return boolean,true��ʾɾ���ɹ�
	 */
	public boolean deletesort(BookSort sort) {
		con = Connect.getConnection();
		try {
			PreparedStatement pt = con.prepareStatement("delete from book_sort where sort_id=?");
			pt.setString(1, sort.getSort_id());
			int count = pt.executeUpdate();
			if (count == 0) {
				Connect.Closecon();
				return false;
			}
		} catch (SQLException e) {
			// e.printStackTrace();
		}
		Connect.Closecon();
		return true;
	}
}
