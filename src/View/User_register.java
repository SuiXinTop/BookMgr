package View;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Control.Rigester;
import Model.User;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Spinner;

public class User_register {

	protected Shell shell;
	private Text text_姓名;
	private Text text_手机;
	private Text text_账号;
	private Text text_密码;
	private Text text_确认;

	private String user_sex;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			User_register window = new User_register();
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

	protected void createContents() {
		shell = new Shell(SWT.CLOSE | SWT.MIN);// 取消最大化与拖拽放大功能
		shell.setImage(SWTResourceManager.getImage(WelcomPart.class, "/images/MC.ico"));
		shell.setBackgroundImage(SWTResourceManager.getImage(WelcomPart.class, "/images/back.jpg"));
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		shell.setSize(1064, 720);
		shell.setText("\u7528\u6237\u6CE8\u518C");
		shell.setLocation(Display.getCurrent().getClientArea().width / 2 - shell.getShell().getSize().x / 2,
				Display.getCurrent().getClientArea().height / 2 - shell.getSize().y / 2);

		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblNewLabel_4.setBounds(396, 216, 76, 27);
		lblNewLabel_4.setText("\u7528\u6237\u8D26\u53F7");

		Label lblNewLabel_8 = new Label(shell, SWT.NONE);

		lblNewLabel_8.setBounds(647, 216, 18, 27);
		text_账号 = new Text(shell, SWT.BORDER);
		text_账号.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				User user = new User();
				user.setUser_id(text_账号.getText().trim());
				Rigester r = new Rigester();
				if (r.selectuser(user) == false) {
					lblNewLabel_8.setImage(SWTResourceManager.getImage(User_register.class, "/images/exit.png"));
				} else {
					lblNewLabel_8.setImage(null);
				}
			}
		});
		text_账号.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
		text_账号.setBounds(502, 216, 139, 26);

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblNewLabel.setBounds(396, 251, 76, 20);
		lblNewLabel.setText("\u59D3\u540D");

		text_姓名 = new Text(shell, SWT.BORDER);
		text_姓名.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
		text_姓名.setBounds(502, 248, 139, 26);

		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblNewLabel_1.setBounds(396, 285, 76, 20);
		lblNewLabel_1.setText("\u6027\u522B");

		Button btnRadioButton = new Button(shell, SWT.RADIO);
		btnRadioButton.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
		btnRadioButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				user_sex = btnRadioButton.getText().trim();
			}
		});
		btnRadioButton.setBounds(502, 285, 61, 20);
		btnRadioButton.setText("\u7537");

		Button btnRadioButton_1 = new Button(shell, SWT.RADIO);
		btnRadioButton_1.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
		btnRadioButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				user_sex = btnRadioButton_1.getText().trim();
			}
		});
		btnRadioButton_1.setBounds(580, 285, 61, 20);
		btnRadioButton_1.setText("\u5973");

		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblNewLabel_2.setBounds(396, 319, 76, 20);
		lblNewLabel_2.setText("\u5E74\u9F84");

		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblNewLabel_3.setBounds(396, 351, 89, 20);
		lblNewLabel_3.setText("\u624B\u673A\u53F7\u7801");

		text_手机 = new Text(shell, SWT.BORDER);
		text_手机.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
		text_手机.setBounds(502, 348, 139, 26);

		Label lblNewLabel_5 = new Label(shell, SWT.NONE);
		lblNewLabel_5.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblNewLabel_5.setBounds(396, 383, 76, 20);
		lblNewLabel_5.setText("\u5BC6\u7801");

		final Label lblNewLabel_pwd = new Label(shell, SWT.NONE);
		lblNewLabel_pwd.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_pwd.setBounds(647, 384, 225, 20);

		text_密码 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_密码.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (text_密码.getText().trim().length() == 0) {
					lblNewLabel_pwd.setText("\u5BC6\u7801\u4E0D\u80FD\u4E3A\u7A7A\uFF01");
				} else if (text_密码.getText().trim().length() > 0 && text_密码.getText().trim().length() < 6) {
					lblNewLabel_pwd
							.setText("\u5BC6\u7801(\u5B57\u6BCD+\u6570\u5B57)\u4E0D\u5F97\u4F4E\u4E8E6\u4F4D\uFF01");
				} else if (text_密码.getText().trim().length() > 0 && text_密码.getText().trim().length() > 16) {
					lblNewLabel_pwd
							.setText("\u5BC6\u7801(\u5B57\u6BCD+\u6570\u5B57)\u4E0D\u5F97\u9AD8\u4E8E16\u4F4D\uFF01");
				} else {
					lblNewLabel_pwd.setText("");
				}
			}
		});
		text_密码.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		text_密码.setBounds(502, 380, 139, 26);

		Label lblNewLabel_6 = new Label(shell, SWT.NONE);
		lblNewLabel_6.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblNewLabel_6.setBounds(396, 415, 89, 20);
		lblNewLabel_6.setText("\u786E\u8BA4\u5BC6\u7801");

		Label lblNewLabel_7 = new Label(shell, SWT.NONE);
		lblNewLabel_7.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_7.setAlignment(SWT.CENTER);
		lblNewLabel_7.setBounds(502, 444, 139, 20);

		text_确认 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_确认.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (text_确认.getText().trim().equals(text_密码.getText().trim())) {
					lblNewLabel_7.setText("");
				} else {
					lblNewLabel_7.setText("\u5BC6\u7801\u4E0D\u4E00\u81F4");
				}
			}
		});
		text_确认.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		text_确认.setBounds(502, 412, 139, 26);

		Spinner spinner = new Spinner(shell, SWT.BORDER);
		spinner.setBounds(502, 311, 139, 26);

		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setImage(SWTResourceManager.getImage(User_register.class, "/images/add.png"));
		btnNewButton.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				User user = new User();
				user.setUser_id(text_账号.getText().trim());
				user.setUser_name(text_姓名.getText().trim());
				user.setUser_age(Integer.parseInt(spinner.getText().trim()));
				user.setUser_sex(user_sex);
				user.setUser_phone(text_手机.getText().trim());
				user.setUser_password(text_密码.getText().trim());
				Rigester r = new Rigester();
				// 正则表达式英加数字
				Pattern pr = Pattern.compile("^[a-zA-Z]\\w{5,15}$");
				Matcher m = pr.matcher(text_密码.getText().trim());

				if (r.selectuser(user) == false) {
					// 提示该账号已被注册
					MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_WARNING);
					messageBox.setMessage("账号已存在，请重新输入用户账号！");
					messageBox.open();
				} else {
					if (text_密码.getText().trim().equals(text_确认.getText().trim()) && m.matches()) {
						if (r.rigester(user)) {
							MessageBox messageBox1 = new MessageBox(shell, SWT.OK | SWT.ICON_INFORMATION);
							messageBox1.setMessage("注册成功");
							messageBox1.open();
							shell.close();
							User_login window = new User_login();
							window.open();
						}
					} else if (m.matches() == false) {
						MessageBox messageBox1 = new MessageBox(shell, SWT.OK | SWT.ICON_WARNING);
						messageBox1.setMessage("输入的密码形式错误");
						messageBox1.open();
					} else if (text_密码.getText().trim().equals(text_确认.getText().trim()) == false) {
						MessageBox messageBox1 = new MessageBox(shell, SWT.OK | SWT.ICON_WARNING);
						messageBox1.setMessage("输入的密码不一致");
						messageBox1.open();
					} else {
						MessageBox messageBox1 = new MessageBox(shell, SWT.OK | SWT.ICON_ERROR);
						messageBox1.setMessage("注册失败");
						messageBox1.open();
					}
				}
			}
		});
		btnNewButton.setText("\u6CE8\u518C");
		btnNewButton.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		btnNewButton.setBounds(468, 477, 115, 36);

		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setImage(SWTResourceManager.getImage(User_register.class, "/images/reset.png"));
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				User_login window = new User_login();
				window.open();
			}
		});
		btnNewButton_1.setText("\u8FD4\u56DE");
		btnNewButton_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		btnNewButton_1.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		btnNewButton_1.setBounds(468, 525, 115, 36);

		Label lblNewLabel_4_1 = new Label(shell, SWT.NONE);
		lblNewLabel_4_1.setImage(SWTResourceManager.getImage(User_register.class, "/images/me.png"));
		lblNewLabel_4_1.setBounds(478, 216, 18, 26);

		Label lblNewLabel_5_1 = new Label(shell, SWT.NONE);
		lblNewLabel_5_1.setImage(SWTResourceManager.getImage(User_register.class, "/images/password.png"));
		lblNewLabel_5_1.setBounds(478, 377, 18, 26);

		Label lblNewLabel_3_1 = new Label(shell, SWT.NONE);
		lblNewLabel_3_1.setText("\u7528\u6237\u6CE8\u518C");
		lblNewLabel_3_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		lblNewLabel_3_1.setFont(SWTResourceManager.getFont("黑体", 27, SWT.BOLD));
		lblNewLabel_3_1.setAlignment(SWT.CENTER);
		lblNewLabel_3_1.setBounds(312, 94, 435, 78);

	}
}
