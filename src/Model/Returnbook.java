package Model;

public class Returnbook {
	private String book_id;
	private String user_id;
	private String bor_date;
	private String fac_date;

	public Returnbook() {
		super();
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getFac_date() {
		return fac_date;
	}

	public void setFac_date(String fac_date) {
		this.fac_date = fac_date;
	}

	public String getBor_date() {
		return bor_date;
	}

	public void setBor_date(String bor_date) {
		this.bor_date = bor_date;
	}
}
