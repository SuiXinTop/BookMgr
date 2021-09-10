package Model;

public class Book {
	private String book_id;
	private String book_name;
	private String book_author;
	private String book_pub;
	private int book_stock;
	private String book_sortid;
	private String book_record;

	public Book() {
		super();
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_author() {
		return book_author;
	}

	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}

	public String getBook_pub() {
		return book_pub;
	}

	public void setBook_pub(String book_pub) {
		this.book_pub = book_pub;
	}

	public int getBook_stock() {
		return book_stock;
	}

	public void setBook_stock(int book_stock) {
		this.book_stock = book_stock;
	}

	public String getBook_sortid() {
		return book_sortid;
	}

	public void setBook_sortid(String book_sortid) {
		this.book_sortid = book_sortid;
	}

	public String getBook_record() {
		return book_record;
	}

	public void setBook_record(String book_record) {
		this.book_record = book_record;
	}

}
