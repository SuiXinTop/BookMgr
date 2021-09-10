package View;

import java.util.Date;

import org.eclipse.swt.SWT;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

import com.ibm.icu.text.SimpleDateFormat;

import Control.Bookborrow;
import Control.Bookreturn;
import Model.Borrowbook;
import Model.Returnbook;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.widgets.Button;

public class User_borrowmark {
	protected Shell shell;
	private Table table;
	public String id;
	boolean t = true;// 时间显示状态
	int count = -1;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			User_borrowmark window = new User_borrowmark();
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
		shell.addShellListener(new ShellAdapter() {
			@Override
			public void shellClosed(ShellEvent e) {
				t = false;
			}
		});
		shell.setImage(SWTResourceManager.getImage(WelcomPart.class, "/images/MC.ico"));
		shell.setBackgroundImage(SWTResourceManager.getImage(WelcomPart.class, "/images/back.jpg"));
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		shell.setSize(1059, 720);
		shell.setText("\u501F\u9605\u60C5\u51B5\u603B\u89C8");
		shell.setLocation(Display.getCurrent().getClientArea().width / 2 - shell.getShell().getSize().x / 2,
				Display.getCurrent().getClientArea().height / 2 - shell.getSize().y / 2);

		final Label label = new Label(shell, SWT.NONE);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		label.setAlignment(SWT.CENTER);
		label.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		label.setBounds(339, 111, 386, 41);
		new Thread() {// 线程操作
			public void run() {
				while (t) {
					try {
						// 对Label进行实时刷新，需要加上这句
						label.getDisplay().asyncExec(new Runnable() {
							@Override
							public void run() {
								// 设置时间 ，格式化输出时间
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								String s = sdf.format(new Date());
								label.setText(s);// 输出到Label上
							}
						});
						Thread.sleep(1000);// 每隔一秒刷新一次
					} catch (Exception e) {
					}
				}
				Thread.interrupted();
			}
		}.start();

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

		table = new Table(shell, SWT.FULL_SELECTION);
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				count = table.getSelectionIndex();
			}
		});
		table.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(10, 179, 1021, 459);

		TableColumn tableColumn = new TableColumn(table, SWT.CENTER);
		tableColumn.setWidth(32);

		TableColumn tableColumn_id = new TableColumn(table, SWT.CENTER);
		tableColumn_id.setWidth(119);
		tableColumn_id.setText("\u56FE\u4E66\u7F16\u53F7");

		TableColumn tableColumn_name = new TableColumn(table, SWT.CENTER);
		tableColumn_name.setWidth(189);
		tableColumn_name.setText("\u56FE\u4E66\u540D\u79F0");

		TableColumn tableColumn_author = new TableColumn(table, SWT.CENTER);
		tableColumn_author.setWidth(126);
		tableColumn_author.setText("\u4F5C\u8005");

		TableColumn tableColumn_pub = new TableColumn(table, SWT.CENTER);
		tableColumn_pub.setWidth(122);
		tableColumn_pub.setText("\u51FA\u7248\u793E");

		TableColumn tableColumn_date = new TableColumn(table, SWT.CENTER);
		tableColumn_date.setWidth(175);
		tableColumn_date.setText("\u501F\u9605\u65F6\u95F4");

		TableColumn tableColumn_redate = new TableColumn(table, SWT.CENTER);
		tableColumn_redate.setWidth(172);
		tableColumn_redate.setText("\u9884\u671F\u5F52\u8FD8\u65F6\u95F4");

		TableColumn tableColumn_tf = new TableColumn(table, SWT.CENTER);
		tableColumn_tf.setWidth(82);
		tableColumn_tf.setText("\u72B6\u6001");

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblNewLabel.setFont(SWTResourceManager.getFont("黑体", 25, SWT.BOLD));
		lblNewLabel.setBounds(391, 50, 266, 48);
		lblNewLabel.setText("\u501F\u9605\u60C5\u51B5\u603B\u89C8");

		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setImage(SWTResourceManager.getImage(User_borrowmark.class, "/images/MC.ico"));
		lblNewLabel_1.setBounds(196, 20, 138, 128);

		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		label_1.setBounds(833, 147, 142, 20);
		label_1.setText("\u9009\u62E9\u672A\u5F52\u8FD8\u56FE\u4E66");

		Bookborrow borrow = new Bookborrow();
		Borrowbook bor = new Borrowbook();
		bor.setUser_id(id);
		String borr[][] = borrow.ShowBorrow(bor);
		if (borr.length != 1) {
			for (int i = 1; i < borr.length; i++) {
				TableItem item = new TableItem(table, SWT.NONE);
				item.setText(i + ".");
				item.setText(borr[i]);
			}
		}

		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (count != -1) {
					Bookreturn ret = new Bookreturn();
					Returnbook retbook = new Returnbook();
					retbook.setUser_id(id);
					retbook.setBook_id(borr[count + 1][1]);
					if (ret.ReturnBook(retbook)) {
						MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_INFORMATION);
						messageBox.setMessage("图书归还成功");
						messageBox.open();
						shell.close();
						User_borrowmark window = new User_borrowmark();
						window.id = id;
						window.open();
					} else {
						MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_ERROR);
						messageBox.setMessage("图书归还失败");
						messageBox.open();
					}
				}
			}
		});
		btnNewButton.setImage(SWTResourceManager.getImage(User_borrowmark.class, "/images/reset.png"));
		btnNewButton.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		btnNewButton.setBounds(981, 143, 50, 30);
	}
}