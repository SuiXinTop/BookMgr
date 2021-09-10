package Model;

public class Borrowbook {
	private String user_id;
	private String book_id;
	private String bor_date;
	private String ret_date;

	public Borrowbook() {
		super();
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getBor_date() {
		return bor_date;
	}

	public void setBor_date(String bor_date) {
		this.bor_date = bor_date;
	}

	public String getRet_date() {
		return ret_date;
	}

	public void setRet_date(String ret_date) {
		this.ret_date = ret_date;
	}

}
