package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {
	public static String convertTimestamp(String timestamp)
	{
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
		Date date = new Date(Long.parseLong(timestamp));
		return sf.format(date);
	}
}
