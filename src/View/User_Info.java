package View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class User_Info {

	protected Shell shell;
	public String id;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			User_Info window = new User_Info();
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
		shell.setSize(1066, 720);
		shell.setText("\u8F6F\u4EF6\u4FE1\u606F");
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

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		lblNewLabel.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 20, SWT.NORMAL));
		lblNewLabel.setBounds(407, 120, 198, 54);
		lblNewLabel.setText("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");

		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		lblNewLabel_1.setText("    \u672C\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\u63D0\u4F9B\uFF1A\r\n1.\u7528\u6237"
				+ "\u548C\u7BA1\u7406\u5458\u53CC\u767B\u5F55\u7A97\u53E3\r\n2.\u5229\u7528JDBC\u7F16\u7A0B\uFF0C\u5B9E\u73B0\u5BF9"
				+ "\u56FE\u4E66\u7684\u589E\u52A0\uFF0C\u5220\u9664\uFF0C\u4FEE\u6539\uFF0C\u67E5\u8BE2\r\n3.\u5229\u7528JDBC\u7F16\u7A0B\uFF0C\u5B9E\u73B0"
				+ "\u5BF9\u7528\u6237\u548C\u7BA1\u7406\u5458\u8D26\u53F7\u7684\u5B58\u50A8\u548C\u4FEE\u6539\r\n\r\n\r\n\r\n\r\n          "
				+ "    \u8BBE\u8BA1\u4EBA\u5458\uFF1A\u6731\u5B54\u660E\u3001\u6210\u8D24\u9E4F\u3001\u5434\u7EE7\u8FDC\r\n\r\n");
		lblNewLabel_1.setBounds(266, 212, 585, 337);

		Label lblV = new Label(shell, SWT.NONE);
		lblV.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		lblV.setBounds(569, 175, 76, 20);
		lblV.setText("V1.0");

		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		lblNewLabel_2.setImage(SWTResourceManager.getImage(User_Info.class, "/icons/full/help.png"));
		lblNewLabel_2.setBounds(242, 220, 24, 30);

		Label lblNewLabel_1_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1_1.setImage(SWTResourceManager.getImage(User_Info.class, "/images/MC.ico"));
		lblNewLabel_1_1.setBounds(263, 64, 138, 128);

		Label lblTodo = new Label(shell, SWT.NONE);
		lblTodo.setText("TODO.......");
		lblTodo.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblTodo.setBounds(242, 564, 76, 20);
	}
}
