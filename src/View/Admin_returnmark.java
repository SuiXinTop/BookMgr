package View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

import Control.Bookreturn;
import org.eclipse.swt.widgets.Label;

public class Admin_returnmark {

	protected Shell shell;
	private Table table;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Admin_returnmark window = new Admin_returnmark();
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
		shell.setSize(1090, 720);
		shell.setLocation(Display.getCurrent().getClientArea().width / 2 - shell.getShell().getSize().x / 2,
				Display.getCurrent().getClientArea().height / 2 - shell.getSize().y / 2);
		shell.setText("\u5F52\u8FD8\u60C5\u51B5\u603B\u89C8");

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
		table.setBounds(10, 181, 1052, 457);

		TableColumn tableColumn = new TableColumn(table, SWT.CENTER);
		tableColumn.setWidth(44);

		TableColumn tableColumn_id = new TableColumn(table, SWT.CENTER);
		tableColumn_id.setWidth(107);
		tableColumn_id.setText("\u7528\u6237\u8D26\u53F7");

		TableColumn tableColumn_name = new TableColumn(table, SWT.CENTER);
		tableColumn_name.setWidth(149);
		tableColumn_name.setText("\u56FE\u4E66\u7F16\u53F7");

		TableColumn tableColumn_author = new TableColumn(table, SWT.CENTER);
		tableColumn_author.setWidth(227);
		tableColumn_author.setText("\u56FE\u4E66\u540D\u79F0");

		TableColumn tableColumn_pub = new TableColumn(table, SWT.CENTER);
		tableColumn_pub.setWidth(147);
		tableColumn_pub.setText("\u4F5C\u8005");

		TableColumn tableColumn_1 = new TableColumn(table, SWT.CENTER);
		tableColumn_1.setWidth(172);
		tableColumn_1.setText("\u51FA\u7248\u793E");

		TableColumn tableColumn_date = new TableColumn(table, SWT.CENTER);
		tableColumn_date.setWidth(200);
		tableColumn_date.setText("\u5F52\u8FD8\u65F6\u95F4");

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setText("\u5F52\u8FD8\u60C5\u51B5\u603B\u89C8");
		lblNewLabel.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblNewLabel.setFont(SWTResourceManager.getFont("黑体", 25, SWT.BOLD));
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setBounds(392, 51, 266, 48);

		Label icon = new Label(shell, SWT.NONE);
		icon.setImage(SWTResourceManager.getImage(Admin_returnmark.class, "/images/MC.ico"));
		icon.setBounds(199, 10, 128, 152);

		Bookreturn rett = new Bookreturn();
		String retbook[][] = rett.ShowAllReturn();
		if (retbook.length != 1) {
			for (int i = 1; i < retbook.length; i++) {
				TableItem item = new TableItem(table, SWT.NONE);
				item.setText(i + ".");
				item.setText(retbook[i]);
			}
		}
	}
}
