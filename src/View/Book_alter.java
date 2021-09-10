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
import org.eclipse.swt.widgets.Combo;
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

public class Book_alter {

	protected Shell shell;
	private Text text_id;
	private Text text_name;
	private Text text_author;
	private Text text_pub;
	protected String book_id = "";

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Book_alter window = new Book_alter();
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
		shell.setSize(1064, 720);
		shell.setText("\u4FEE\u6539\u56FE\u4E66\u4FE1\u606F");
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
		spinner_stock.setBounds(454, 406, 140, 26);

		Label lblLabel_id = new Label(shell, SWT.NONE);
		lblLabel_id.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblLabel_id.setBounds(454, 162, 97, 20);
		lblLabel_id.setText("\u4E66\u7C4D\u7F16\u53F7");

		BookType sort = new BookType();
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setBounds(454, 464, 140, 28);
		String str[] = sort.selectsortname();
		for (int i = 1; i < str.length; i++) {
			combo.add(str[i]);
		}

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(600, 188, 25, 26);
		text_id = new Text(shell, SWT.BORDER);
		text_id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Selectbook selectbook = new Selectbook();
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
					combo.setText(type.getSort_name());
					lblNewLabel.setImage(null);
				} else {
					text_name.setText("");
					text_author.setText("");
					text_pub.setText("");
					spinner_stock.setSelection(0);
					combo.setText("");
					lblNewLabel.setImage(SWTResourceManager.getImage(Book_alter.class, "/images/exit.png"));
				}
			}
		});
		text_id.setBounds(454, 188, 140, 26);

		Label lblLabel_name = new Label(shell, SWT.NONE);
		lblLabel_name.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblLabel_name.setBounds(454, 220, 97, 20);
		lblLabel_name.setText("\u4E66\u7C4D\u540D\u79F0");

		text_name = new Text(shell, SWT.BORDER);
		text_name.setBounds(454, 238, 140, 26);

		Label lblLabel_author = new Label(shell, SWT.NONE);
		lblLabel_author.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblLabel_author.setBounds(454, 270, 97, 20);
		lblLabel_author.setText("\u4E66\u7C4D\u4F5C\u8005");

		Label lblLabel_pub = new Label(shell, SWT.NONE);
		lblLabel_pub.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblLabel_pub.setBounds(454, 326, 76, 20);
		lblLabel_pub.setText("\u51FA\u7248\u793E");

		Label lblLabel_stock = new Label(shell, SWT.NONE);
		lblLabel_stock.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblLabel_stock.setBounds(454, 380, 76, 20);
		lblLabel_stock.setText("\u5E93\u5B58\u91CF");

		Label lblLabel_sortid = new Label(shell, SWT.NONE);
		lblLabel_sortid.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblLabel_sortid.setBounds(454, 438, 97, 20);
		lblLabel_sortid.setText("\u5206\u7C7B\u7F16\u53F7");

		text_author = new Text(shell, SWT.BORDER);
		text_author.setBounds(454, 294, 140, 26);

		text_pub = new Text(shell, SWT.BORDER);
		text_pub.setBounds(454, 354, 140, 26);

		if (book_id.length() != 0) {
			text_id.setText(book_id);
			Selectbook selectbook = new Selectbook();
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
				combo.setText(type.getSort_name());
			}
		}

		Button btnButton_change = new Button(shell, SWT.NONE);
		btnButton_change.setImage(SWTResourceManager.getImage(Book_alter.class, "/images/modify.png"));
		btnButton_change.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Book book = new Book();
				Bookadmin admin = new Bookadmin();
				BookSort type = new BookSort();
				type.setSort_name(combo.getText().trim());
				type = sort.selectsortid(type);

				book.setBook_id(text_id.getText().trim());
				book.setBook_name(text_name.getText().trim());
				book.setBook_author(text_author.getText().trim());
				book.setBook_pub(text_pub.getText().trim());
				book.setBook_stock(Integer.parseInt(spinner_stock.getText().trim()));
				book.setBook_sortid(type.getSort_id());// TODO
				if (text_id.getText().trim().length() != 0 && text_name.getText().trim().length() != 0
						&& text_author.getText().trim().length() != 0 && text_pub.getText().trim().length() != 0
						&& spinner_stock.getText().trim().length() != 0 && combo.getText().trim().length() != 0) {
					if (admin.alter(book)) {
						MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_INFORMATION);
						messageBox.setMessage("图书信息修改成功");
						messageBox.open();
					} else {
						MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ERROR);
						messageBox.setMessage("图书信息修改失败");
						messageBox.open();
					}
				} else {
					MessageBox messageBox = new MessageBox(shell, SWT.CANCEL | SWT.ICON_ERROR);
					messageBox.setMessage("信息不能为空");
					messageBox.open();
				}
			}
		});
		btnButton_change.setFont(SWTResourceManager.getFont("黑体", 14, SWT.NORMAL));
		btnButton_change.setBounds(454, 507, 140, 37);
		btnButton_change.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		btnButton_change.setText("\u4FEE\u6539");

		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setText("\u4FEE\u6539\u56FE\u4E66\u4FE1\u606F");
		lblNewLabel_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		lblNewLabel_3.setFont(SWTResourceManager.getFont("黑体", 27, SWT.BOLD));
		lblNewLabel_3.setAlignment(SWT.CENTER);
		lblNewLabel_3.setBounds(338, 78, 378, 78);

		Label icon = new Label(shell, SWT.NONE);
		icon.setImage(SWTResourceManager.getImage(Book_alter.class, "/images/MC.ico"));
		icon.setBounds(191, 10, 128, 152);

	}
}
