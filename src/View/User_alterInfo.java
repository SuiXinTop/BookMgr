package View;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.wb.swt.SWTResourceManager;

import Control.Loginusr;
import Model.User;
import org.eclipse.swt.widgets.Spinner;

public class User_alterInfo {

	protected Shell shell;
	private Text text_姓名;
	private Text text_手机;
	private Text text_账号;
	public String id;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			User_alterInfo window = new User_alterInfo();
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
		shell.setSize(1065, 721);
		shell.setText("\u7528\u6237\u4FE1\u606F\u4FEE\u6539");
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

		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblNewLabel_4.setBounds(396, 219, 89, 20);
		lblNewLabel_4.setText("\u7528\u6237\u8D26\u53F7");

		text_账号 = new Text(shell, SWT.NONE);
		text_账号.setText(id);
		text_账号.setEditable(false);
		text_账号.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		text_账号.setBounds(502, 212, 139, 26);

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblNewLabel.setBounds(396, 273, 76, 20);
		lblNewLabel.setText("\u59D3\u540D");

		text_姓名 = new Text(shell, SWT.NONE);
		text_姓名.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		text_姓名.setBounds(502, 270, 139, 26);

		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblNewLabel_1.setBounds(396, 326, 76, 20);
		lblNewLabel_1.setText("\u6027\u522B");

		Button btnRadioButton = new Button(shell, SWT.RADIO);
		btnRadioButton.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		btnRadioButton.setBounds(502, 326, 61, 20);
		btnRadioButton.setText("\u7537");

		Button btnRadioButton_1 = new Button(shell, SWT.RADIO);
		btnRadioButton_1.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		btnRadioButton_1.setBounds(580, 326, 61, 20);
		btnRadioButton_1.setText("\u5973");

		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblNewLabel_2.setBounds(396, 379, 76, 20);
		lblNewLabel_2.setText("\u5E74\u9F84");

		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblNewLabel_3.setBounds(396, 428, 89, 20);
		lblNewLabel_3.setText("\u624B\u673A\u53F7\u7801");

		text_手机 = new Text(shell, SWT.NONE);
		text_手机.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		text_手机.setBounds(502, 425, 139, 26);
		Spinner spinner = new Spinner(shell, SWT.NONE);
		spinner.setBounds(502, 377, 139, 26);

		Loginusr login = new Loginusr();
		User user = new User();
		user.setUser_id(id);
		login.selectuser(user);
		text_姓名.setText(user.getUser_name());
		if (user.getUser_sex().equals("男")) {
			// TODO
			btnRadioButton.setSelection(true);
		} else {
			// TODO
			btnRadioButton_1.setSelection(true);
		}
		spinner.setSelection(user.getUser_age());
		text_手机.setText(user.getUser_phone());

		Button btnNewButton = new Button(shell, SWT.TOGGLE | SWT.CENTER);
		btnNewButton.setImage(SWTResourceManager.getImage(User_alterInfo.class, "/images/modify.png"));
		btnNewButton.setFont(SWTResourceManager.getFont("黑体", 14, SWT.NORMAL));
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				user.setUser_id(text_账号.getText().trim());
				user.setUser_name(text_姓名.getText().trim());
				user.setUser_age(Integer.parseInt(spinner.getText().trim()));
				if (btnRadioButton.getSelection())
					user.setUser_sex(btnRadioButton.getText().trim());
				if (btnRadioButton_1.getSelection())
					user.setUser_sex(btnRadioButton_1.getText().trim());
				user.setUser_phone(text_手机.getText().trim());
				Loginusr r = new Loginusr();
				if (r.alteruser(user)) {
					// 操作
					MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_INFORMATION);
					messageBox.setMessage("信息修改成功");
					messageBox.open();
				} else {
					// 提示注册失败
					MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_ERROR);
					messageBox.setMessage("信息修改失败");
					messageBox.open();
				}

			}
		});
		btnNewButton.setText("\u4FEE\u6539");
		btnNewButton.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		btnNewButton.setBounds(440, 474, 168, 47);

		Label lblNewLabel_3_1 = new Label(shell, SWT.NONE);
		lblNewLabel_3_1.setText("\u7528\u6237\u4FE1\u606F\u4FEE\u6539");
		lblNewLabel_3_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		lblNewLabel_3_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 27, SWT.BOLD));
		lblNewLabel_3_1.setAlignment(SWT.CENTER);
		lblNewLabel_3_1.setBounds(348, 75, 366, 78);

		Label lblNewLabel_1_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1_1.setImage(SWTResourceManager.getImage(User_alterInfo.class, "/images/MC.ico"));
		lblNewLabel_1_1.setBounds(190, 37, 138, 128);

	}
}
