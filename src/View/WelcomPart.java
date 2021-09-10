package View;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;

public class WelcomPart {

	protected Shell shell;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			WelcomPart window = new WelcomPart();
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
		shell.setSize(1068, 720);
		shell.setText("Welcom to \u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		shell.setLocation(Display.getCurrent().getClientArea().width / 2 - shell.getShell().getSize().x / 2,
				Display.getCurrent().getClientArea().height / 2 - shell.getSize().y / 2);

		Button btnNewButton = new Button(shell, SWT.CENTER);
		btnNewButton.setImage(SWTResourceManager.getImage(WelcomPart.class, "/images/login.png"));
		btnNewButton.setBackground(SWTResourceManager.getColor(255, 255, 255));
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				User_login window = new User_login();
				window.open();
			}
		});
		btnNewButton.setText("\u767B\u5F55");
		btnNewButton.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 14, SWT.NORMAL));
		btnNewButton.setBounds(459, 404, 138, 49);

		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setImage(SWTResourceManager.getImage(WelcomPart.class, "/images/add.png"));
		btnNewButton_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				User_register window = new User_register();
				window.open();
			}
		});
		btnNewButton_1.setText("\u6CE8\u518C");
		btnNewButton_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 14, SWT.NORMAL));
		btnNewButton_1.setBounds(459, 475, 138, 49);

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		lblNewLabel.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 26, SWT.NORMAL));
		lblNewLabel.setBounds(268, 92, 523, 64);
		lblNewLabel.setText("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");

		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setImage(SWTResourceManager.getImage(WelcomPart.class, "/images/MC.ico"));
		lblNewLabel_1.setBounds(459, 221, 138, 128);

	}

}
