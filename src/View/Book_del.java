package View;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

import Control.BookType;
import Control.Bookadmin;
import Control.Selectbook;
import Model.Book;
import Model.BookSort;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class Book_del {

	protected Shell shell;
	private Text text_id;
	private Text text_name;
	private Text text_author;
	private Text text_pub;
	private Text text_sort;
	private Text text_record;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Book_del window = new Book_del();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell(SWT.CLOSE | SWT.MIN);// 取消最大化与拖拽放大功能
		shell.setImage(SWTResourceManager.getImage(WelcomPart.class, "/images/MC.ico"));
		shell.setBackgroundImage(SWTResourceManager.getImage(WelcomPart.class, "/images/back.jpg"));
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		shell.setSize(1065, 720);
		shell.setText("\u5220\u9664\u56FE\u4E66");
		shell.setLocation(Display.getCurrent().getClientArea().width / 2 - shell.getShell().getSize().x / 2,
				Display.getCurrent().getClientArea().height / 2 - shell.getSize().y / 2);

		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);

		MenuItem menuItem = new MenuItem(menu, SWT.CASCADE);
		menuItem.setImage(SWTResourceManager.getImage(Admin_BookShow.class, "/images/base.png"));
		menuItem.setText("\u7A0B\u5E8F");

		Menu menu_1 = new Menu(menuItem);
		menuItem.setMenu(menu_1);

		MenuItem menuI_main = new MenuItem(menu_1, SWT.NONE);
		menuI_main.setImage(SWTResourceManager.getImage(Admin_BookShow.class, "/images/about.png"));
		menuI_main.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				Admin_BookShow window = new Admin_BookShow();
				window.open();
			}
		});
		menuI_main.setText("\u4E3B\u9875");

		MenuItem menu_exit = new MenuItem(menu_1, SWT.NONE);
		menu_exit.setImage(SWTResourceManager.getImage(Admin_BookShow.class, "/images/reset.png"));
		menu_exit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				WelcomPart window = new WelcomPart();
				window.open();
			}
		});
		menu_exit.setText("\u9000\u51FA");

		MenuItem menubook = new MenuItem(menu, SWT.CASCADE);
		menubook.setImage(SWTResourceManager.getImage(Admin_BookShow.class, "/images/bookTypeManager.png"));
		menubook.setText("\u56FE\u4E66\u7BA1\u7406");

		Menu menu_2 = new Menu(menubook);
		menubook.setMenu(menu_2);

		MenuItem menu1_add = new MenuItem(menu_2, SWT.NONE);
		menu1_add.setImage(SWTResourceManager.getImage(Admin_BookShow.class, "/images/add.png"));
		menu1_add.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				Book_add window = new Book_add();
				window.open();
			}
		});
		menu1_add.setText("\u6DFB\u52A0\u56FE\u4E66");

		MenuItem menu1_select = new MenuItem(menu_2, SWT.NONE);
		menu1_select.setImage(SWTResourceManager.getImage(Admin_BookShow.class, "/images/search.png"));
		menu1_select.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// 图书查询
				shell.close();
				Book_select window = new Book_select();
				window.open();
			}
		});
		menu1_select.setText("\u67E5\u8BE2\u56FE\u4E66");

		MenuItem menu1_alter = new MenuItem(menu_2, SWT.NONE);
		menu1_alter.setImage(SWTResourceManager.getImage(Admin_BookShow.class, "/images/modify.png"));
		menu1_alter.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				Book_alter window = new Book_alter();
				window.open();
			}
		});
		menu1_alter.setText("\u4FEE\u6539\u56FE\u4E66");

		MenuItem menuI1_delete = new MenuItem(menu_2, SWT.NONE);
		menuI1_delete.setImage(SWTResourceManager.getImage(Admin_BookShow.class, "/images/exit.png"));
		menuI1_delete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				Book_del window = new Book_del();
				window.open();
			}
		});
		menuI1_delete.setText("\u5220\u9664\u56FE\u4E66");

		MenuItem menutype = new MenuItem(menu, SWT.CASCADE);
		menutype.setImage(SWTResourceManager.getImage(Admin_BookShow.class, "/images/bookManager.png"));
		menutype.setText("\u4E66\u7C7B\u7BA1\u7406");

		Menu menu_3 = new Menu(menutype);
		menutype.setMenu(menu_3);

		MenuItem menu2_add = new MenuItem(menu_3, SWT.NONE);
		menu2_add.setImage(SWTResourceManager.getImage(Admin_BookShow.class, "/images/add.png"));
		menu2_add.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				Booktype_add window = new Booktype_add();
				window.open();
			}
		});
		menu2_add.setText("\u6DFB\u52A0\u4E66\u7C7B");

		MenuItem menu2_alter = new MenuItem(menu_3, SWT.NONE);
		menu2_alter.setImage(SWTResourceManager.getImage(Admin_BookShow.class, "/images/modify.png"));
		menu2_alter.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				Booktype_alter window = new Booktype_alter();
				window.open();
			}
		});
		menu2_alter.setText("\u4FEE\u6539\u4E66\u7C7B");

		MenuItem menu2_delete = new MenuItem(menu_3, SWT.NONE);
		menu2_delete.setImage(SWTResourceManager.getImage(Admin_BookShow.class, "/images/exit.png"));
		menu2_delete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				Booktype_delete window = new Booktype_delete();
				window.open();
			}
		});
		menu2_delete.setText("\u5220\u9664\u4E66\u7C7B");

		MenuItem menumark = new MenuItem(menu, SWT.CASCADE);
		menumark.setImage(SWTResourceManager.getImage(Admin_BookShow.class, "/images/student.png"));
		menumark.setText("\u501F\u8FD8\u8BB0\u5F55");

		Menu menu_4 = new Menu(menumark);
		menumark.setMenu(menu_4);

		MenuItem menu3_borrow = new MenuItem(menu_4, SWT.NONE);
		menu3_borrow.setImage(SWTResourceManager.getImage(Admin_BookShow.class, "/images/edit.png"));
		menu3_borrow.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				Admin_borrowmark window = new Admin_borrowmark();
				window.open();// 借书记录
			}
		});
		menu3_borrow.setText("\u501F\u4E66\u8BB0\u5F55");

		MenuItem menu3_return = new MenuItem(menu_4, SWT.NONE);
		menu3_return.setImage(SWTResourceManager.getImage(Admin_BookShow.class, "/images/search.png"));
		menu3_return.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				Admin_returnmark window = new Admin_returnmark();
				window.open();// 还书记录
			}
		});
		menu3_return.setText("\u8FD8\u4E66\u8BB0\u5F55");

		MenuItem mntmhelp = new MenuItem(menu, SWT.CASCADE);
		mntmhelp.setImage(SWTResourceManager.getImage(Admin_BookShow.class, "/images/about.png"));
		mntmhelp.setText("\u5173\u4E8E");

		Menu menu_5 = new Menu(mntmhelp);
		mntmhelp.setMenu(menu_5);

		MenuItem menu4_Info = new MenuItem(menu_5, SWT.NONE);
		menu4_Info.setImage(SWTResourceManager.getImage(Admin_BookShow.class, "/images/me.png"));
		menu4_Info.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				Admin_Info window = new Admin_Info();
				window.open();
			}
		});
		menu4_Info.setText("\u8F6F\u4EF6\u4FE1\u606F");

		Spinner spinner_stock = new Spinner(shell, SWT.BORDER);
		spinner_stock.setMaximum(1000);
		spinner_stock.setBounds(501, 358, 128, 26);

		Label lblLabel_name = new Label(shell, SWT.NONE);
		lblLabel_name.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblLabel_name.setBounds(408, 252, 86, 20);
		lblLabel_name.setText("\u4E66\u7C4D\u540D\u79F0");

		text_name = new Text(shell, SWT.BORDER);
		text_name.setBounds(501, 250, 128, 26);

		Label lblLabel_author = new Label(shell, SWT.NONE);
		lblLabel_author.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblLabel_author.setBounds(408, 289, 86, 20);
		lblLabel_author.setText("\u4E66\u7C4D\u4F5C\u8005");

		Label lblLabel_pub = new Label(shell, SWT.NONE);
		lblLabel_pub.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblLabel_pub.setBounds(408, 323, 76, 20);
		lblLabel_pub.setText("\u51FA\u7248\u793E");

		Label lblLabel_stock = new Label(shell, SWT.NONE);
		lblLabel_stock.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblLabel_stock.setBounds(408, 360, 76, 20);
		lblLabel_stock.setText("\u5E93\u5B58\u91CF");

		Label lblLabel_sortid = new Label(shell, SWT.NONE);
		lblLabel_sortid.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblLabel_sortid.setBounds(408, 404, 76, 20);
		lblLabel_sortid.setText("\u5206\u7C7B");

		text_author = new Text(shell, SWT.BORDER);
		text_author.setBounds(501, 287, 128, 26);

		text_pub = new Text(shell, SWT.BORDER);
		text_pub.setBounds(501, 321, 128, 26);

		text_sort = new Text(shell, SWT.BORDER);
		text_sort.setBounds(501, 402, 128, 26);

		Label lblLabel_record = new Label(shell, SWT.NONE);
		lblLabel_record.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblLabel_record.setBounds(408, 446, 97, 20);
		lblLabel_record.setText("\u5F55\u5165\u65F6\u95F4");

		text_record = new Text(shell, SWT.BORDER);
		text_record.setBounds(501, 444, 127, 26);

		Label lblLabel_id = new Label(shell, SWT.NONE);
		lblLabel_id.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblLabel_id.setBounds(408, 218, 80, 20);
		lblLabel_id.setText("\u4E66\u7C4D\u7F16\u53F7");

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(640, 219, 25, 26);
		text_id = new Text(shell, SWT.BORDER);
		text_id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Selectbook selectbook = new Selectbook();
				BookType sort = new BookType();
				Book book = new Book();
				BookSort type = new BookSort();
				book.setBook_id(text_id.getText().trim());
				book = selectbook.select(book);
				if (book.getBook_name() != null) {
					type.setSort_id(book.getBook_sortid());
					type = sort.selectsortname(type);

					text_name.setText(book.getBook_name());
					text_author.setText(book.getBook_author());
					text_pub.setText(book.getBook_pub());
					spinner_stock.setSelection(book.getBook_stock());
					text_sort.setText(type.getSort_name());
					text_record.setText(book.getBook_record());
					lblNewLabel.setImage(null);
				} else {
					text_name.setText("");
					text_author.setText("");
					text_pub.setText("");
					spinner_stock.setSelection(0);
					text_sort.setText("");
					text_record.setText("");
					lblNewLabel.setImage(SWTResourceManager.getImage(Book_alter.class, "/images/exit.png"));
				}
			}
		});
		text_id.setBounds(501, 216, 128, 26);

		Button btnButton_del = new Button(shell, SWT.NONE);
		btnButton_del.setImage(SWTResourceManager.getImage(Book_del.class, "/images/exit.png"));
		btnButton_del.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Book book = new Book();
				Bookadmin admin = new Bookadmin();
				book.setBook_id(text_id.getText().trim());
				if (admin.delete(book)) {
					// 提示删除成功
					MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_INFORMATION);
					messageBox.setMessage("图书信息删除成功");
					messageBox.open();
				} else {
					// 删除失败
					MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ERROR);
					messageBox.setMessage("图书信息删除失败");
					messageBox.open();
				}
			}
		});
		btnButton_del.setFont(SWTResourceManager.getFont("黑体", 14, SWT.NORMAL));
		btnButton_del.setBounds(466, 495, 117, 46);
		btnButton_del.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		btnButton_del.setText("\u5220\u9664");

		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setText("\u5220\u9664\u56FE\u4E66");
		lblNewLabel_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		lblNewLabel_3.setFont(SWTResourceManager.getFont("黑体", 27, SWT.BOLD));
		lblNewLabel_3.setAlignment(SWT.CENTER);
		lblNewLabel_3.setBounds(352, 69, 363, 78);

		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setImage(SWTResourceManager.getImage(Book_del.class, "/images/MC.ico"));
		lblNewLabel_1.setBounds(199, 30, 138, 128);

	}
}
