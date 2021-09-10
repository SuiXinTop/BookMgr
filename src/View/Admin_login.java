package View;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import Control.Loginadm;
import Model.Admin;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Admin_login {

	protected Shell shell;
	private Text text_ÕËºÅ;
	private Text text_ÃÜÂë;

	private Button btnNewButton_1;
	private Label lblNewLabel_2;
	private Label lblNewLabel_3;
	private Label lblNewLabel_4;
	private Label label;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Admin_login window = new Admin_login();
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
		shell = new Shell(SWT.CLOSE | SWT.MIN);// È¡Ïû×î´ó»¯ÓëÍÏ×§·Å´ó¹¦ÄÜ

		shell.setImage(SWTResourceManager.getImage(WelcomPart.class, "/images/MC.ico"));
		shell.setBackgroundImage(SWTResourceManager.getImage(WelcomPart.class, "/images/back.jpg"));
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		shell.setSize(1066, 720);
		shell.setLocation(Display.getCurrent().getClientArea().width / 2 - shell.getShell().getSize().x / 2,
				Display.getCurrent().getClientArea().height / 2 - shell.getSize().y / 2);
		shell.setText("\u7BA1\u7406\u5458\u767B\u9646");

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("ºÚÌå", 12, SWT.NORMAL));
		lblNewLabel.setBounds(435, 298, 98, 20);
		lblNewLabel.setText("\u7BA1\u7406\u5458\u8D26\u53F7");

		text_ÕËºÅ = new Text(shell, SWT.BORDER);
		text_ÕËºÅ.setFont(SWTResourceManager.getFont("ºÚÌå", 10, SWT.NORMAL));
		text_ÕËºÅ.setBounds(435, 328, 172, 26);

		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("ºÚÌå", 12, SWT.NORMAL));
		lblNewLabel_1.setBounds(435, 360, 43, 20);
		lblNewLabel_1.setText("\u5BC6\u7801");

		text_ÃÜÂë = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_ÃÜÂë.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		text_ÃÜÂë.setBounds(435, 386, 172, 26);

		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setImage(SWTResourceManager.getImage(Admin_login.class, "/images/login.png"));
		btnNewButton.setFont(SWTResourceManager.getFont("ºÚÌå", 14, SWT.NORMAL));
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Admin admin = new Admin();
				admin.setAdm_id(text_ÕËºÅ.getText());
				admin.setAdm_password(text_ÃÜÂë.getText());

				Loginadm login = new Loginadm();
				if (login.veriryadm(admin)) {
					shell.close();
					Admin_BookShow window = new Admin_BookShow();
					window.open();
				} else {
					// ÌáÊ¾µÇÂ½Ê§°Ü
					MessageBox messageBox = new MessageBox(shell, SWT.CANCEL | SWT.ICON_WARNING);
					messageBox.setMessage("µÇÂ½Ê§°Ü");
					messageBox.open();
				}
			}
		});
		btnNewButton.setBounds(422, 436, 98, 39);
		btnNewButton.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		btnNewButton.setText("\u767B\u5F55");

		btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setImage(SWTResourceManager.getImage(Admin_login.class, "/images/reset.png"));
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				User_login window = new User_login();
				window.open();
			}
		});
		btnNewButton_1.setText("\u8FD4\u56DE");
		btnNewButton_1.setFont(SWTResourceManager.getFont("ºÚÌå", 14, SWT.NORMAL));
		btnNewButton_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		btnNewButton_1.setBounds(477, 498, 98, 33);

		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text_ÕËºÅ.setText("");
				text_ÃÜÂë.setText("");
			}
		});
		btnNewButton_2.setText("\u91CD\u7F6E");
		btnNewButton_2.setImage(SWTResourceManager.getImage(Admin_login.class, "/images/reset.png"));
		btnNewButton_2.setFont(SWTResourceManager.getFont("ºÚÌå", 14, SWT.NORMAL));
		btnNewButton_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		btnNewButton_2.setBounds(535, 436, 98, 39);

		lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setText("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 27, SWT.BOLD));
		lblNewLabel_2.setAlignment(SWT.CENTER);
		lblNewLabel_2.setBounds(310, 82, 435, 78);

		lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setImage(SWTResourceManager.getImage(Admin_login.class, "/images/me.png"));
		lblNewLabel_3.setBounds(539, 299, 28, 19);

		lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setImage(SWTResourceManager.getImage(Admin_login.class, "/images/password.png"));
		lblNewLabel_4.setBounds(484, 361, 27, 20);

		label = new Label(shell, SWT.NONE);
		label.setImage(SWTResourceManager.getImage(Admin_login.class, "/images/MC.ico"));
		label.setBounds(459, 146, 128, 146);
	}
}
