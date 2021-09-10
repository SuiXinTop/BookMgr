package Control;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 获取当前系统时间
 * 
 * @author STARS
 * @return String
 */
public class GetDateTime {
	public String getdate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		return sdf.format(date);
	}

	/**
	 * 获取默认当前30天后的时间
	 * 
	 * @author STARS
	 * @return String
	 */
	public String getdateplus() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, 30);
		date = calendar.getTime();
		return sdf.format(date);

	}
}
