package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {

	public static final String SIMPLE_PATTERN = "yyyy-MM-dd";
	public static final String YYYYMMDD = "yyyyMMdd";
	public static final String FULL_PATTERN = "yyyy-MM-dd HH:mm:ss";
	public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

	public static String getFormatString(Date currentDate, String pattern) {
		if (currentDate == null) {

			return "";
		} else {
			SimpleDateFormat dateformat = new SimpleDateFormat(pattern);
			return dateformat == null ? "" : dateformat.format(currentDate);
		}
	}

	public static Date parseToDate(String dateStr) {
		return parseToDate(dateStr, FULL_PATTERN);
	}

	public static Date parseToDate(String dateStr, String pattern) {
		String orginalPattern = pattern;
		if (StringUtil.isEmpty(dateStr)) {
			return new Date();
		}
		if (StringUtil.isEmpty(pattern)) {
			pattern = SIMPLE_PATTERN;
		}
		Date date = null;
		SimpleDateFormat format = new SimpleDateFormat();
		try {
			format.applyPattern(pattern);
			date = format.parse(dateStr);
		} catch (ParseException e) {
			// nothing to do
		}
		if (date == null) {
			if (FULL_PATTERN.equals(pattern)) {
				format.applyPattern(SIMPLE_PATTERN);
			} else {
				format.applyPattern(FULL_PATTERN);
			}
			try {
				date = format.parse(dateStr);
			} catch (ParseException e) {
				throw new UnsupportedOperationException("DateUtil doesn't support the date pattern : " + orginalPattern);
			}
		}
		return date;
	}

	public static String format(Date date) {
		return format(date, SIMPLE_PATTERN);
	}

	public static String format(Date date, String pattern) {
		if (date == null) {
			return "";
		}
		if (StringUtil.isEmpty(pattern)) {
			pattern = SIMPLE_PATTERN;
		}
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	public static Date getCurrentDate() {
		return new Date();
	}

	public static String getCurrentDateYYYYMMDD() {
		return format(getCurrentDate(), YYYYMMDD);
	}

	public static String getCurrentDateYYYYMMDDHHMMSS() {
		return format(getCurrentDate(), YYYYMMDDHHMMSS);
	}

	/**
	 * 获取当前时间正负N天后的时间
	 * 
	 * @Author:laigengbiao
	 * @Description:
	 * @param days
	 *            正数为前推N天，负数为后推N天
	 * @return
	 * @throws
	 */
	public static Date addDateByDays(int days) {
		return addDateByDays(getCurrentDate(), days);
	}
	/**
	 * 获取指定时间的正负N天后的时间
	 * 
	 * @Author:laigengbiao
	 * @Description:
	 * @param source
	 *            指定时间
	 * @param days
	 *            正数为前推N天，负数为后推N天
	 * @return
	 * @throws
	 */
	public static Date addDateByDays(Date source, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(source);
		calendar.add(Calendar.DATE, days);
		return calendar.getTime();
	}

	/**
	 * 获取当前时间正负N月后的时间
	 * 
	 * @Author:laigengbiao
	 * @Description:
	 * @param months
	 *            正数为前推N月，负数为后推N月
	 * @return
	 * @throws
	 */
	public static Date addDateByMonths(int months) {
		return addDateByMonths(new Date(), months);
	}
	/**
	 * 获取指定时间的正负N月后的时间
	 * 
	 * @Author:laigengbiao
	 * @Description:
	 * @param source
	 *            指定时间
	 * @param days
	 *            正数为前推N月，负数为后推N月
	 * @return
	 * @throws
	 */
	public static Date addDateByMonths(Date source, int months) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(source);
		calendar.add(Calendar.MONTH, months);
		return calendar.getTime();
	}
	/**
	 * @throws ParseException
	 *             获取短日期（2012-12-21）
	 * @Author:laigengbiao
	 * @Description:
	 * @param date
	 * @return
	 * @throws
	 */
	public static Date getShortDate(Date date) throws ParseException {
		return parseToDate(format(date, SIMPLE_PATTERN));
	}

	public static String[] getPreviousNDays(int n) {
		String[] days = new String[Math.abs(n)];

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		int i = 0;

		for (int j = n + 1; j <= -1; j++) {
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, j);

			days[i] = df.format(calendar.getTime());

			i++;
		}

		days[days.length - 1] = df.format(new Date());

		return days;
	}

	public static Date strToDate(String input, String format) {
		try {
			SimpleDateFormat df = new SimpleDateFormat(format);

			return df.parse(input);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 获得Year年份列表。根据参数增量来，正整数获取从今年起(包括今年)后面多少年，附整数从今年(包括今年)算起的前多少年。
	 * 
	 * @param increment
	 * @return
	 */
	public static List<Integer> getYearList(int increment, boolean isContainThisYear) {

		List<Integer> result = new ArrayList<Integer>();

		int thisYear = Calendar.getInstance().get(Calendar.YEAR);

		if (isContainThisYear) {
			result.add(thisYear);
		} else {
			increment = increment > 0 ? increment + 1 : increment - 1;
		}

		if (increment > 0) {

			for (int x = 1; x < increment; x++) {
				result.add(++thisYear);
			}

		} else {

			for (int x = -1; x > increment; x--) {
				result.add(--thisYear);
			}

		}

		return result;

	}

	/**
	 * 获得newDate - oldDate的时间差，单位为秒
	 * 
	 * @param newDate
	 * @param oldDate
	 * @return
	 */
	public static int getTimeDifference(Date newDate, Date oldDate) {
		long timeDifference = newDate.getTime() - oldDate.getTime();
		return (int) (timeDifference / 1000);
	}

	/**
	 * 获取指定时间的正负N小时后的时间
	 * 
	 * @Author:zl
	 * @Description:
	 * @param source
	 *            指定时间
	 * @param hours
	 *            正数为前推N小时，负数为后推N小时
	 * @return
	 * @throws
	 */
	public static Date addDateByHours(Date source, int hours) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(source);
		calendar.add(Calendar.HOUR_OF_DAY, hours);
		return calendar.getTime();
	}

	public static Date addDateByMinutes(Date source, int minutes) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(source);
		calendar.add(Calendar.MINUTE, minutes);
		return calendar.getTime();
	}

	public static Date addDateByMinutes(int minutes) {
		return addDateByMinutes(new Date(), minutes);
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int daysBetween(Date date1, Date date2) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		long time1 = cal.getTimeInMillis();
		cal.setTime(date2);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/*
	 * public static void main(String[] args) throws Exception { String aa=
	 * "2015-07-26T16:00:00.000Z"; Date bb = parseToDate(aa);
	 * System.out.println(bb);
	 * 
	 * }
	 */
}
