package View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import Control.BookType;
import Model.BookSort;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class Booktype_add {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Booktype_add window = new Booktype_add();
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
		shell = new Shell(SWT.CLOSE | SWT.MIN);
		shell.setImage(SWTResourceManager.getImage(WelcomPart.class, "/images/MC.ico"));
		shell.setBackgroundImage(SWTResourceManager.getImage(WelcomPart.class, "/images/back.jpg"));
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		shell.setSize(1069, 720);
		shell.setText("\u4E66\u7C7B\u6DFB\u52A0");
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

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		lblNewLabel.setBounds(445, 178, 98, 26);
		lblNewLabel.setText("\u4E66\u7C7B\u7F16\u53F7");

		Label label_3 = new Label(shell, SWT.NONE);

		label_3.setBounds(609, 215, 28, 26);
		text = new Text(shell, SWT.NONE);
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				BookType t = new BookType();
				BookSort sort = new BookSort();
				sort.setSort_id(text.getText().trim());
				sort = t.selectsortname(sort);
				if (sort.getSort_name() != null) {
					label_3.setImage(SWTResourceManager.getImage(Booktype_add.class, "/images/exit.png"));
				} else {
					label_3.setImage(null);
				}
			}
		});
		text.setBounds(445, 215, 158, 26);

		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		btnNewButton.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				BookType t = new BookType();
				BookSort sort = new BookSort();
				sort.setSort_id(text.getText().trim());
				sort.setSort_name(text_1.getText().trim());
				sort.setSort_text(text_2.getText().trim());
				if (text.getText().trim().length() != 0 && text_1.getText().trim().length() != 0
						&& text_2.getText().trim().length() != 0) {
					if (t.addsort(sort)) {
						MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_INFORMATION);
						messageBox.setMessage("添加书类成功");
						messageBox.open();
						text.setText("");
						text_1.setText("");
						text_2.setText("");
					} else {
						MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_ERROR);
						messageBox.setMessage("添加书类失败");
						messageBox.open();
					}
				} else {
					MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_ERROR);
					messageBox.setMessage("信息不能为空");
					messageBox.open();
				}
			}
		});
		btnNewButton.setBounds(445, 472, 158, 42);
		btnNewButton.setText("\u65B0\u589E");

		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		label.setBounds(445, 262, 98, 26);
		label.setText("\u4E66\u7C7B\u540D\u79F0");

		text_1 = new Text(shell, SWT.NONE);
		text_1.setBounds(445, 294, 158, 26);

		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		label_1.setBounds(445, 340, 98, 26);
		label_1.setText("\u5907\u6CE8");

		text_2 = new Text(shell, SWT.MULTI);
		text_2.setBounds(445, 372, 158, 74);

		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		label_2.setFont(SWTResourceManager.getFont("黑体", 26, SWT.NORMAL));
		label_2.setBounds(433, 95, 212, 56);
		label_2.setText("\u4E66\u7C7B\u6DFB\u52A0");

		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setImage(SWTResourceManager.getImage(Booktype_add.class, "/images/MC.ico"));
		lblNewLabel_1.setBounds(198, 25, 138, 128);

	}
}
