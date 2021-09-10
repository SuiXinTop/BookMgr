package View;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import Control.Loginusr;
import Model.User;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class User_login {

	protected Shell shell;
	private Text text_’À∫≈;
	private Text text_√‹¬Î;
	private Button btnNewButton;
	private Button btnNewButton_1;

	public String user_id;
	private Label lblNewLabel;
	private Label lblNewLabel_1;
	private Label label;
	private Label lblNewLabel_4;
	private Label lblNewLabel_5;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			User_login window = new User_login();
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
		shell = new Shell(SWT.CLOSE | SWT.MIN);// »°œ˚◊Ó¥ÛªØ”ÎÕœ◊ß∑≈¥Ûπ¶ƒ‹
		shell.setImage(SWTResourceManager.getImage(User_login.class, "/images/MC.ico"));
		shell.setBackgroundImage(SWTResourceManager.getImage(User_login.class, "/images/back.jpg"));
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		shell.setSize(1058, 720);
		shell.setText("\u7528\u6237\u767B\u5F55");
		shell.setLocation(Display.getCurrent().getClientArea().width / 2 - shell.getShell().getSize().x / 2,
				Display.getCurrent().getClientArea().height / 2 - shell.getSize().y / 2);

		Label lblNewLabel_id = new Label(shell, SWT.NONE);
		lblNewLabel_id.setAlignment(SWT.CENTER);
		lblNewLabel_id.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_id.setBounds(449, 346, 194, 20);

		text_’À∫≈ = new Text(shell, SWT.BORDER);
		text_’À∫≈.setBounds(449, 315, 201, 26);
		text_’À∫≈.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if (text_’À∫≈.getText().trim().length() == 0) {
					lblNewLabel_id.setText("\u8D26\u53F7\u4E0D\u80FD\u4E3A\u7A7A\uFF01");
				} else {
					lblNewLabel_id.setText("");
				}
			}
		});
		text_’À∫≈.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));

		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setAlignment(SWT.CENTER);
		lblNewLabel_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel_2.setBounds(449, 402, 194, 20);

		text_√‹¬Î = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_√‹¬Î.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (text_√‹¬Î.getText().trim().length() == 0) {
					lblNewLabel_2.setText("\u5BC6\u7801\u4E0D\u80FD\u4E3A\u7A7A\uFF01");
				} else {
					lblNewLabel_2.setText("");
				}
			}
		});
		text_√‹¬Î.setBounds(449, 372, 201, 26);
		text_√‹¬Î.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));

		Link link_mi = new Link(shell, SWT.NONE);
		link_mi.setLinkForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		link_mi.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Õ¸º«√‹¬Î
				shell.close();
				WelcomPart window = new WelcomPart();
				window.open();
			}
		});
		link_mi.setBounds(660, 372, 84, 20);

		btnNewButton = new Button(shell, SWT.CENTER);
		btnNewButton.setBounds(416, 447, 95, 37);
		btnNewButton.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_FOREGROUND));
		btnNewButton.setImage(SWTResourceManager.getImage(User_login.class, "/images/login.png"));
		btnNewButton.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		btnNewButton.setFont(SWTResourceManager.getFont("∫⁄ÃÂ", 12, SWT.NORMAL));
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				User usr = new User();
				usr.setUser_id(text_’À∫≈.getText());
				usr.setUser_password(text_√‹¬Î.getText());
				Loginusr login = new Loginusr();
				if (login.veriryusr(usr)) {
					shell.close();
					User_BookShow window = new User_BookShow();
					window.id = usr.getUser_id();
					window.open();
				} else {
					link_mi.setText("<a>\u5FD8\u8BB0\u5BC6\u7801?</a>");
					MessageBox messageBox = new MessageBox(shell, SWT.CANCEL | SWT.ICON_ERROR);
					messageBox.setMessage("µ«¬Ω ß∞‹");
					messageBox.open();
				}
			}
		});
		btnNewButton.setText("\u767B\u5F55");

		btnNewButton_1 = new Button(shell, SWT.CENTER);
		btnNewButton_1.setBounds(477, 504, 84, 30);
		btnNewButton_1.setText("\u6CE8\u518C");
		btnNewButton_1.setImage(SWTResourceManager.getImage(User_login.class, "/images/add.png"));
		btnNewButton_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		btnNewButton_1.setFont(SWTResourceManager.getFont("∫⁄ÃÂ", 12, SWT.NORMAL));
		btnNewButton_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// ∑µªÿ
				shell.close();
				User_register window = new User_register();
				window.open();
			}
		});

		Button btnNewButton_2 = new Button(shell, SWT.CENTER);
		btnNewButton_2.setForeground(SWTResourceManager.getColor(0, 0, 255));
		btnNewButton_2.setBounds(525, 447, 95, 37);
		btnNewButton_2.setFont(SWTResourceManager.getFont("∫⁄ÃÂ", 12, SWT.NORMAL));
		btnNewButton_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		btnNewButton_2.setImage(SWTResourceManager.getImage(User_login.class, "/images/reset.png"));
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text_’À∫≈.setText("");
				text_√‹¬Î.setText("");
			}
		});
		btnNewButton_2.setText("\u91CD\u7F6E");

		lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(398, 286, 50, 23);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_FOREGROUND));
		lblNewLabel.setText("\u8D26\u53F7");
		lblNewLabel.setFont(SWTResourceManager.getFont("∫⁄ÃÂ", 12, SWT.NORMAL));

		lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(398, 345, 50, 23);
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_FOREGROUND));
		lblNewLabel_1.setText("\u5BC6\u7801");
		lblNewLabel_1.setFont(SWTResourceManager.getFont("∫⁄ÃÂ", 12, SWT.NORMAL));

		label = new Label(shell, SWT.NONE);
		label.setBounds(461, 157, 128, 146);
		label.setImage(SWTResourceManager.getImage(User_login.class, "/images/MC.ico"));

		Label label_1 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_FOREGROUND));
		label_1.setBounds(517, 437, 2, 64);

		Link link = new Link(shell, SWT.NONE);
		link.setFont(SWTResourceManager.getFont("∫⁄ÃÂ", 10, SWT.NORMAL));
		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				Admin_login window = new Admin_login();
				window.open();
			}
		});
		link.setBounds(477, 540, 95, 20);
		link.setText("<a>\u7BA1\u7406\u5458\u767B\u9646</a>");

		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		lblNewLabel_3.setAlignment(SWT.CENTER);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 27, SWT.BOLD));
		lblNewLabel_3.setBounds(309, 53, 435, 78);
		lblNewLabel_3.setText("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");

		lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setImage(SWTResourceManager.getImage(User_login.class, "/images/me.png"));
		lblNewLabel_4.setBounds(415, 304, 28, 37);

		lblNewLabel_5 = new Label(shell, SWT.NONE);
		lblNewLabel_5.setImage(SWTResourceManager.getImage(User_login.class, "/images/password.png"));
		lblNewLabel_5.setBounds(416, 377, 27, 26);

	}
}
