package View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

import Control.Selectbook;
import Model.Book;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;

public class User_select {
	protected Shell shell;
	private Table table;
	private Text text_select;
	public String id;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			User_select window = new User_select();
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
	 * 
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shell = new Shell(SWT.CLOSE | SWT.MIN);// 取消最大化与拖拽放大功能
		shell.setImage(SWTResourceManager.getImage(WelcomPart.class, "/images/MC.ico"));
		shell.setBackgroundImage(SWTResourceManager.getImage(WelcomPart.class, "/images/back.jpg"));
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		shell.setSize(1153, 720);
		shell.setText("\u56FE\u4E66\u67E5\u8BE2");
		shell.setLocation(Display.getCurrent().getClientArea().width / 2 - shell.getShell().getSize().x / 2,
				Display.getCurrent().getClientArea().height / 2 - shell.getSize().y / 2);

		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);

		MenuItem menu_soft = new MenuItem(menu, SWT.CASCADE);
		menu_soft.setImage(SWTResourceManager.getImage(User_alterInfo.class, "/images/base.png"));
		menu_soft.setText("\u7A0B\u5E8F");

		Menu menu_1 = new Menu(menu_soft);
		menu_soft.setMenu(menu_1);

		MenuItem menu_main = new MenuItem(menu_1, SWT.NONE);
		menu_main.setImage(SWTResourceManager.getImage(User_alterInfo.class, "/images/me.png"));
		menu_main.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				User_BookShow window = new User_BookShow();
				window.id = id;
				window.open();
			}
		});
		menu_main.setText("\u4E3B\u9875");

		MenuItem menu_exit = new MenuItem(menu_1, SWT.NONE);
		menu_exit.setImage(SWTResourceManager.getImage(User_alterInfo.class, "/images/reset.png"));
		menu_exit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				WelcomPart window = new WelcomPart();
				window.open();
			}
		});
		menu_exit.setText("\u9000\u51FA");

		MenuItem menu_br = new MenuItem(menu, SWT.CASCADE);
		menu_br.setImage(SWTResourceManager.getImage(User_alterInfo.class, "/images/bookManager.png"));
		menu_br.setText("\u56FE\u4E66\u7BA1\u7406");

		Menu menu_2 = new Menu(menu_br);
		menu_br.setMenu(menu_2);

		MenuItem menu_borrow = new MenuItem(menu_2, SWT.NONE);
		menu_borrow.setImage(SWTResourceManager.getImage(User_alterInfo.class, "/images/add.png"));
		menu_borrow.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// 借书
				shell.close();
				User_borrow window = new User_borrow();
				window.id = id;
				window.open();
			}
		});
		menu_borrow.setText("\u501F\u4E66");

		MenuItem menu_return = new MenuItem(menu_2, SWT.NONE);
		menu_return.setImage(SWTResourceManager.getImage(User_alterInfo.class, "/images/reset.png"));
		menu_return.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// 还书
				shell.close();
				User_return window = new User_return();
				window.id = id;
				window.open();
			}
		});
		menu_return.setText("\u8FD8\u4E66");

		MenuItem menuI_select = new MenuItem(menu, SWT.CASCADE);
		menuI_select.setImage(SWTResourceManager.getImage(User_alterInfo.class, "/images/bookTypeManager.png"));
		menuI_select.setText("\u67E5\u8BE2");

		Menu menu_3 = new Menu(menuI_select);
		menuI_select.setMenu(menu_3);

		MenuItem menuI_bookselect = new MenuItem(menu_3, SWT.NONE);
		menuI_bookselect.setImage(SWTResourceManager.getImage(User_alterInfo.class, "/images/search.png"));
		menuI_bookselect.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// 图书查询
				shell.close();
				User_select window = new User_select();
				window.id = id;
				window.open();
			}
		});
		menuI_bookselect.setText("\u56FE\u4E66\u67E5\u8BE2");

		MenuItem menu_borrowmark = new MenuItem(menu_3, SWT.NONE);
		menu_borrowmark.setImage(SWTResourceManager.getImage(User_alterInfo.class, "/images/edit.png"));
		menu_borrowmark.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// 借书记录
				shell.close();
				User_borrowmark window = new User_borrowmark();
				window.id = id;
				window.open();
			}
		});
		menu_borrowmark.setText("\u501F\u4E66\u8BB0\u5F55");

		MenuItem menu_returnmark = new MenuItem(menu_3, SWT.NONE);
		menu_returnmark.setImage(SWTResourceManager.getImage(User_alterInfo.class, "/images/modify.png"));
		menu_returnmark.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// 还书记录
				shell.close();
				User_returnmark window = new User_returnmark();
				window.id = id;
				window.open();
			}
		});
		menu_returnmark.setText("\u8FD8\u4E66\u8BB0\u5F55");

		MenuItem menu_UserInfo = new MenuItem(menu, SWT.CASCADE);
		menu_UserInfo.setImage(SWTResourceManager.getImage(User_alterInfo.class, "/images/userName.png"));
		menu_UserInfo.setText("\u4E2A\u4EBA\u4FE1\u606F\u7BA1\u7406");

		Menu menu_4 = new Menu(menu_UserInfo);
		menu_UserInfo.setMenu(menu_4);

		MenuItem menu_InfoAlter = new MenuItem(menu_4, SWT.NONE);
		menu_InfoAlter.setImage(SWTResourceManager.getImage(User_alterInfo.class, "/images/modify.png"));
		menu_InfoAlter.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// 修改
				shell.close();
				User_alterInfo window = new User_alterInfo();
				window.id = id;
				window.open();
			}
		});
		menu_InfoAlter.setText("\u4FE1\u606F\u4FEE\u6539");

		MenuItem menu_pwd = new MenuItem(menu_4, SWT.NONE);
		menu_pwd.setImage(SWTResourceManager.getImage(User_alterInfo.class, "/images/password.png"));
		menu_pwd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// 密码
				shell.close();
				User_alterpwd window = new User_alterpwd();
				window.id = id;
				window.open();
			}
		});
		menu_pwd.setText("\u5BC6\u7801\u4FEE\u6539");

		MenuItem mntmhelp = new MenuItem(menu, SWT.CASCADE);
		mntmhelp.setImage(SWTResourceManager.getImage(User_alterInfo.class, "/images/about.png"));
		mntmhelp.setText("\u5173\u4E8E");

		Menu menu_5 = new Menu(mntmhelp);
		mntmhelp.setMenu(menu_5);

		MenuItem menu_Info = new MenuItem(menu_5, SWT.NONE);
		menu_Info.setImage(SWTResourceManager.getImage(User_alterInfo.class, "/images/me.png"));
		menu_Info.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				User_Info window = new User_Info();
				window.id = id;
				window.open();
			}
		});
		menu_Info.setText("\u8F6F\u4EF6\u4FE1\u606F");

		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 196, 1115, 442);

		TableColumn tableColumn = new TableColumn(table, SWT.CENTER);
		tableColumn.setWidth(32);

		TableColumn tableColumn_id = new TableColumn(table, SWT.CENTER);
		tableColumn_id.setWidth(102);
		tableColumn_id.setText("\u56FE\u4E66\u7F16\u53F7");

		TableColumn tableColumn_name = new TableColumn(table, SWT.CENTER);
		tableColumn_name.setWidth(180);
		tableColumn_name.setText("\u56FE\u4E66\u540D\u79F0");

		TableColumn tableColumn_author = new TableColumn(table, SWT.CENTER);
		tableColumn_author.setWidth(137);
		tableColumn_author.setText("\u56FE\u4E66\u79CD\u7C7B");

		TableColumn tableColumn_pub = new TableColumn(table, SWT.CENTER);
		tableColumn_pub.setWidth(155);
		tableColumn_pub.setText("\u4F5C\u8005");

		TableColumn tableColumn_stock = new TableColumn(table, SWT.CENTER);
		tableColumn_stock.setWidth(173);
		tableColumn_stock.setText("\u51FA\u7248\u793E");

		TableColumn tableColumn_sortid = new TableColumn(table, SWT.CENTER);
		tableColumn_sortid.setWidth(139);
		tableColumn_sortid.setText("\u5E93\u5B58");

		TableColumn tableColumn_record = new TableColumn(table, SWT.CENTER);
		tableColumn_record.setWidth(193);
		tableColumn_record.setText("\u767B\u8BB0\u65F6\u95F4");

		Combo combo_way = new Combo(shell, SWT.NONE);
		combo_way.add("图书编号");
		combo_way.add("图书名称");
		combo_way.add("图书作者");
		combo_way.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		combo_way.setBounds(288, 160, 131, 33);

		// 遍历查询book表
		Button btnButton_select = new Button(shell, SWT.CENTER);
		btnButton_select.setImage(SWTResourceManager.getImage(User_select.class, "/images/search.png"));
		btnButton_select.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		btnButton_select.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Book book = new Book();
				Selectbook selectbook = new Selectbook();
				table.removeAll();
				if (combo_way.getText().equals("图书编号")) {
					book.setBook_id(text_select.getText().trim());
					String str[][] = selectbook.ShowAidBook(book);
					if (str.length != 1) {
						for (int i = 1; i < str.length; i++) {
							TableItem item = new TableItem(table, SWT.NONE);
							item.setText(i + ".");
							item.setText(str[i]);
						}
					}
				}
				if (combo_way.getText().equals("图书名称")) {
					book.setBook_name("%" + text_select.getText().trim() + "%");
					String str[][] = selectbook.ShowAnameBook(book);
					if (str.length != 1) {
						for (int i = 1; i < str.length; i++) {
							TableItem item = new TableItem(table, SWT.NONE);
							item.setText(i + ".");
							item.setText(str[i]);
						}
					}
				}
				if (combo_way.getText().equals("图书作者")) {
					book.setBook_author("%" + text_select.getText().trim() + "%");
					String str[][] = selectbook.ShowAauthorBook(book);
					if (str.length != 1) {
						for (int i = 1; i < str.length; i++) {
							TableItem item = new TableItem(table, SWT.NONE);
							item.setText(i + ".");
							item.setText(str[i]);
						}
					}
				}
				if (combo_way.getText().length() == 0) {
					String str[][] = selectbook.ShowAllBook();
					if (str.length != 1) {
						for (int i = 1; i < str.length; i++) {
							TableItem item = new TableItem(table, SWT.NONE);
							item.setText(i + ".");
							item.setText(str[i]);
						}
					}
				}
			}
		});
		btnButton_select.setBounds(643, 160, 98, 27);
		btnButton_select.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnButton_select.setText("查询");

		text_select = new Text(shell, SWT.BORDER);
		text_select.setBounds(449, 158, 176, 30);

		Label lblNewLabel_way = new Label(shell, SWT.NONE);
		lblNewLabel_way.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		lblNewLabel_way.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblNewLabel_way.setBounds(288, 134, 98, 20);
		lblNewLabel_way.setText("\u67E5\u8BE2\u65B9\u5F0F\uFF1A");

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		lblNewLabel.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblNewLabel.setBounds(449, 132, 76, 20);
		lblNewLabel.setText("\u8F93\u5165\uFF1A");

		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setText("\u56FE\u4E66\u67E5\u8BE2");
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblNewLabel_1.setFont(SWTResourceManager.getFont("黑体", 25, SWT.BOLD));
		lblNewLabel_1.setAlignment(SWT.CENTER);
		lblNewLabel_1.setBounds(395, 50, 266, 48);
		shell.setTabList(new Control[] { table, btnButton_select });
	}
}
