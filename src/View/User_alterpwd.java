package View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import Control.Loginusr;
import Model.User;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;

public class User_alterpwd {

	protected Shell shell;
	public String id;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			User_alterpwd window = new User_alterpwd();
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
		shell.setText("\u5BC6\u7801\u4FEE\u6539");
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

		text = new Text(shell, SWT.NONE);
		text.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		text.setEnabled(false);
		text.setText(id);
		text.setBounds(419, 226, 203, 26);

		text_1 = new Text(shell, SWT.PASSWORD);
		text_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));

		text_1.setBounds(419, 285, 203, 26);

		final Label label_pwd = new Label(shell, SWT.NONE);
		label_pwd.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_pwd.setBounds(628, 340, 253, 20);
		text_2 = new Text(shell, SWT.PASSWORD);
		text_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		text_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if (text_2.getText().trim().length() == 0) {
					label_pwd.setText("\u5BC6\u7801\u4E0D\u80FD\u4E3A\u7A7A\uFF01");
				} else if (text_2.getText().trim().length() > 0 && text_2.getText().trim().length() < 6) {
					label_pwd.setText("\u5BC6\u7801(\u5B57\u6BCD+\u6570\u5B57)\u4E0D\u5F97\u4F4E\u4E8E6\u4F4D\uFF01");
				} else if (text_2.getText().trim().length() > 0 && text_2.getText().trim().length() > 16) {
					label_pwd.setText("\u5BC6\u7801(\u5B57\u6BCD+\u6570\u5B57)\u4E0D\u5F97\u9AD8\u4E8E16\u4F4D\uFF01");
				} else {
					label_pwd.setText("");
				}
			}
		});
		text_2.setBounds(419, 340, 203, 26);

		final Label lblNewLabel_confirm = new Label(shell, SWT.NONE);
		lblNewLabel_confirm.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_confirm.setBounds(628, 393, 187, 20);
		text_3 = new Text(shell, SWT.PASSWORD);
		text_3.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		text_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (text_3.getText().trim().equals(text_2.getText().trim())) {
					lblNewLabel_confirm.setText("");
				} else {
					lblNewLabel_confirm.setText("\u5BC6\u7801\u4E0D\u4E00\u81F4");
				}
			}
		});
		text_3.setBounds(419, 393, 203, 26);

		Label label = new Label(shell, SWT.NONE);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		label.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		label.setBounds(419, 200, 76, 20);
		label.setText("\u8D26\u53F7");

		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		label_1.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		label_1.setBounds(419, 259, 76, 20);
		label_1.setText("\u65E7\u5BC6\u7801");

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblNewLabel.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblNewLabel.setBounds(419, 317, 76, 20);
		lblNewLabel.setText("\u65B0\u5BC6\u7801");

		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		label_2.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		label_2.setBounds(419, 372, 98, 20);
		label_2.setText("\u91CD\u590D\u5BC6\u7801");

		Button button = new Button(shell, SWT.NONE);
		button.setImage(SWTResourceManager.getImage(User_alterpwd.class, "/images/modify.png"));
		button.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				User user = new User();
				user.setUser_id(text.getText().trim());
				user.setUser_password(text_1.getText().trim());
				Loginusr login = new Loginusr();

				Pattern pr = Pattern.compile("^[a-zA-Z]\\w{5,15}$");
				Matcher m = pr.matcher(text_2.getText().trim());

				if (login.veriryusr(user)) {
					user.setUser_password(text_2.getText().trim());
					if (text_2.getText().trim().equals(text_3.getText().trim()) && m.matches()) {
						if (login.alterpassword(user)) {
							MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_INFORMATION);
							messageBox.setMessage("修改密码成功");
							messageBox.open();
						}
					} else if (m.matches() == false) {
						MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_ERROR);
						messageBox.setMessage("输入的新密码形式不正确");
						messageBox.open();
					} else {
						MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_ERROR);
						messageBox.setMessage("输入密码不一致");
						messageBox.open();
					}
				} else {
					MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_ERROR);
					messageBox.setMessage("旧密码不正确");
					messageBox.open();
				}
			}
		});
		button.setFont(SWTResourceManager.getFont("黑体", 14, SWT.NORMAL));
		button.setBounds(419, 461, 203, 50);
		button.setText("\u786E\u8BA4\u4FEE\u6539");

		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setText("\u4FEE\u6539\u5BC6\u7801");
		lblNewLabel_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		lblNewLabel_3.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 27, SWT.BOLD));
		lblNewLabel_3.setAlignment(SWT.CENTER);
		lblNewLabel_3.setBounds(365, 92, 339, 78);

		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setImage(SWTResourceManager.getImage(User_alterpwd.class, "/images/MC.ico"));
		lblNewLabel_1.setBounds(201, 31, 138, 128);
	}
}
