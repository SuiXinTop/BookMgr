package View;

import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import com.ibm.icu.text.SimpleDateFormat;

import Control.Bookadmin;
import Control.Selectbook;
import Model.Book;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;

public class Admin_BookShow {

	private Shell shell;
	private Table table;
	boolean t = true;// 时间显示状态
	int count = -1;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Admin_BookShow window = new Admin_BookShow();
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
		shell.setSize(1154, 720);
		shell.setLocation(Display.getCurrent().getClientArea().width / 2 - shell.getShell().getSize().x / 2,
				Display.getCurrent().getClientArea().height / 2 - shell.getSize().y / 2);
		shell.setText("\u7BA1\u7406\u5458\u4E3B\u9875");

		final Label label = new Label(shell, SWT.NONE);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		label.setAlignment(SWT.CENTER);
		label.setFont(SWTResourceManager.getFont("微软雅黑", 12, SWT.NORMAL));
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
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				count = table.getSelectionIndex();
			}
		});
		table.setFont(SWTResourceManager.getFont("黑体", 10, SWT.NORMAL));
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBackgroundMode(SWT.INHERIT_DEFAULT);
		table.setBackgroundImage(null);
		table.setBounds(10, 179, 1116, 459);

		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn.setMoveable(true);
		tblclmnNewColumn.setWidth(40);

		TableColumn tableColumn = new TableColumn(table, SWT.CENTER);
		tableColumn.setMoveable(true);
		tableColumn.setWidth(109);
		tableColumn.setText("\u56FE\u4E66\u7F16\u53F7");

		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_1.setMoveable(true);
		tblclmnNewColumn_1.setWidth(197);
		tblclmnNewColumn_1.setText("\u56FE\u4E66\u540D\u79F0");

		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_2.setMoveable(true);
		tblclmnNewColumn_2.setWidth(139);
		tblclmnNewColumn_2.setText("\u56FE\u4E66\u79CD\u7C7B");

		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_3.setMoveable(true);
		tblclmnNewColumn_3.setWidth(169);
		tblclmnNewColumn_3.setText("\u4F5C\u8005");

		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_4.setMoveable(true);
		tblclmnNewColumn_4.setWidth(178);
		tblclmnNewColumn_4.setText("\u51FA\u7248\u793E");

		TableColumn tblclmnNewColumn_5 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_5.setMoveable(true);
		tblclmnNewColumn_5.setWidth(73);
		tblclmnNewColumn_5.setText("\u5E93\u5B58");

		TableColumn tblclmnNewColumn_6 = new TableColumn(table, SWT.CENTER);
		tblclmnNewColumn_6.setMoveable(true);
		tblclmnNewColumn_6.setWidth(207);
		tblclmnNewColumn_6.setText("\u6DFB\u52A0\u65F6\u95F4");

		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setText("\u56FE\u4E66\u4FE1\u606F\u603B\u89C8");
		lblNewLabel.setForeground(SWTResourceManager.getColor(255, 255, 255));
		lblNewLabel.setFont(SWTResourceManager.getFont("黑体", 25, SWT.BOLD));
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setBounds(392, 57, 266, 48);

		Label icon = new Label(shell, SWT.NONE);
		icon.setImage(SWTResourceManager.getImage(Admin_BookShow.class, "/images/MC.ico"));
		icon.setBounds(195, 10, 128, 152);

		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		label_1.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		label_1.setBounds(924, 147, 40, 26);
		label_1.setText("\u4FEE\u6539");

		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		label_2.setFont(SWTResourceManager.getFont("黑体", 12, SWT.NORMAL));
		label_2.setBounds(1024, 147, 48, 20);
		label_2.setText("\u5220\u9664");

		Selectbook select = new Selectbook();
		String str[][] = select.ShowAllBook();
		// TableEditor edi[]=new TableEditor[str.length];
		// Button[] bt=new Button[str.length];
		for (int i = 1; i < str.length; i++) {
			TableItem item = new TableItem(table, SWT.NONE);
			// edi[i]=new TableEditor(table);
			// bt[i]=new Button(table, SWT.CHECK);
			// bt[i].computeSize(SWT.DEFAULT,table.getItemHeight());
			// edi[i].grabHorizontal=true;
			// edi[i].setEditor(bt[i],item,0);
			item.setText(i + ".");
			item.setText(str[i]);
		}

		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (count != -1) {
					String book_id = str[count + 1][1];
					Book_alter window = new Book_alter();
					window.book_id = book_id;
					shell.close();
					window.open();
				}
			}
		});
		btnNewButton.setImage(SWTResourceManager.getImage(Admin_BookShow.class, "/images/modify.png"));
		btnNewButton.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		btnNewButton.setBounds(970, 143, 48, 30);

		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (count != -1) {
					Book book = new Book();
					Bookadmin admin = new Bookadmin();
					book.setBook_id(str[count + 1][1]);
					if (admin.delete(book)) {
						// 提示删除成功
						MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ICON_INFORMATION);
						messageBox.setMessage("图书信息删除成功");
						messageBox.open();
						shell.close();
						Admin_BookShow window = new Admin_BookShow();
						window.open();
					} else {
						// 删除失败
						MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.ERROR);
						messageBox.setMessage("图书信息删除失败");
						messageBox.open();
					}
				}
			}
		});
		btnNewButton_1.setImage(SWTResourceManager.getImage(Admin_BookShow.class, "/images/exit.png"));
		btnNewButton_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		btnNewButton_1.setBounds(1078, 143, 48, 30);

	}
}
