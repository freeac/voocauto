package com.vooc.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCommon {
	public static String DateFormat(String format) {
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat(format);
		String content = String.format("%s", ft.format(date));
		return content;
	}

}
