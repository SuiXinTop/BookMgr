package View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import Control.Selectbook;
import Model.Book;

public class Book_select {

	protected Shell shell;
	private Table table;
	private Text text_select;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Book_select window = new Book_select();
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
		shell.setSize(1157, 720);
		shell.setText("\u56FE\u4E66\u67E5\u8BE2");
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

		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 191, 1119, 447);

		TableColumn tableColumn = new TableColumn(table, SWT.CENTER);
		tableColumn.setWidth(29);

		TableColumn tableColumn_id = new TableColumn(table, SWT.CENTER);
		tableColumn_id.setWidth(110);
		tableColumn_id.setText("\u56FE\u4E66\u7F16\u53F7");

		TableColumn tableColumn_name = new TableColumn(table, SWT.CENTER);
		tableColumn_name.setWidth(216);
		tableColumn_name.setText("\u56FE\u4E66\u540D\u79F0");

		TableColumn tableColumn_author = new TableColumn(table, SWT.CENTER);
		tableColumn_author.setWidth(117);
		tableColumn_author.setText("\u56FE\u4E66\u79CD\u7C7B");

		TableColumn tableColumn_pub = new TableColumn(table, SWT.CENTER);
		tableColumn_pub.setWidth(148);
		tableColumn_pub.setText("\u4F5C\u8005");

		TableColumn tableColumn_stock = new TableColumn(table, SWT.CENTER);
		tableColumn_stock.setWidth(167);
		tableColumn_stock.setText("\u51FA\u7248\u793E");

		TableColumn tableColumn_sortid = new TableColumn(table, SWT.CENTER);
		tableColumn_sortid.setWidth(79);
		tableColumn_sortid.setText("\u5E93\u5B58");

		TableColumn tableColumn_record = new TableColumn(table, SWT.CENTER);
		tableColumn_record.setWidth(247);
		tableColumn_record.setText("\u767B\u8BB0\u65F6\u95F4");

		Combo combo_way = new Combo(shell, SWT.NONE);
		combo_way.add("图书编号");
		combo_way.add("图书名称");
		combo_way.add("图书作者");
		combo_way.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		combo_way.setBounds(314, 157, 131, 28);

		// 遍历查询book表
		Button btnButton_select = new Button(shell, SWT.NONE);
		btnButton_select.setImage(SWTResourceManager.getImage(Book_select.class, "/images/search.png"));
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
					for (int i = 1; i < str.length; i++) {
						TableItem item = new TableItem(table, SWT.NONE);
						item.setText(i + ".");
						item.setText(str[i]);
					}
				}
				if (combo_way.getText().equals("图书名称")) {
					book.setBook_name("%" + text_select.getText().trim() + "%");
					String str[][] = selectbook.ShowAnameBook(book);
					for (int i = 1; i < str.length; i++) {
						TableItem item = new TableItem(table, SWT.NONE);
						item.setText(i + ".");
						item.setText(str[i]);
					}
				}
				if (combo_way.getText().equals("图书作者")) {
					book.setBook_author("%" + text_select.getText().trim() + "%");
					String str[][] = selectbook.ShowAauthorBook(book);
					for (int i = 1; i < str.length; i++) {
						TableItem item = new TableItem(table, SWT.NONE);
						item.setText(i + ".");
						item.setText(str[i]);
					}
				}
				if (combo_way.getText().length() == 0) {
					String str[][] = selectbook.ShowAllBook();
					for (int i = 1; i < str.length; i++) {
						TableItem item = new TableItem(table, SWT.NONE);
						item.setText(i + ".");
						item.setText(str[i]);
					}
				}
			}
		});
		btnButton_select.setBounds(664, 155, 98, 30);
		btnButton_select.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		btnButton_select.setText("查询");

		text_select = new Text(shell, SWT.BORDER);
		text_select.setBounds(472, 155, 186, 30);

		Label lblNewLabel_way = new Label(shell, SWT.NONE);
		lblNewLabel_way.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		lblNewLabel_way.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblNewLabel_way.setBounds(314, 128, 107, 30);
		lblNewLabel_way.setText("\u67E5\u8BE2\u65B9\u5F0F\uFF1A");

		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setText("\u56FE\u4E66\u67E5\u8BE2");
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblNewLabel_1.setFont(SWTResourceManager.getFont("黑体", 25, SWT.BOLD));
		lblNewLabel_1.setAlignment(SWT.CENTER);
		lblNewLabel_1.setBounds(392, 54, 266, 48);

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setText("\u8F93\u5165\uFF1A");
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		lblNewLabel.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblNewLabel.setBounds(472, 129, 76, 20);

	}
}
