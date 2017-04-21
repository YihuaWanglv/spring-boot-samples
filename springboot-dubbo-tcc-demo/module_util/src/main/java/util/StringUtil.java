package util;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.UUID;

public class StringUtil {
	/* 随机字符串生成的方式（由字母和数字组成） */
	public static final int RANDOM_TYPE_NORMAL = 1;
	/* 随机字符串生成的方式（全部由数字组成） */
	public static final int RANDOM_TYPE_ALNUM = 2;
	/* 随机字符串生成的方式（全部由字母组成） */
	public static final int RANDOM_TYPE_ALPHA = 3;

	public static boolean isEmpty(String str) {
		if (str == null) {
			return true;
		} else {
			if (str.equals("")) {
				return true;
			}
		}
		return false;
	}

	public static boolean isNotEmpty(String str) {
		if (null != str && !"".equals(str)) {
			return true;
		}
		return false;
	}

	public static boolean isNotEmptyORNull(String str) {
		return null != str && !"".equals(str) && !"null".equals(str);
	}

	/**
	 * 生成随机字符串
	 * 
	 * @author Simon.Ye <samlinye@163.com>
	 * 
	 * @param len
	 *            随机字符串的长度
	 * @return
	 */
	public static String getRandomString(int len) {
		return getRandomString(len, RANDOM_TYPE_NORMAL);
	}

	/**
	 * 按指定的方式生成随机字符串
	 * 
	 * @author Simon.Ye <samlinye@163.com>
	 * 
	 * @param len
	 *            随机字符串的长度
	 * @param randomType
	 *            生成随机字符串的方式
	 * @return
	 */
	public static String getRandomString(int len, int randomType) {
		if (len < 1) {
			return "";
		}

		String str;

		if (randomType == RANDOM_TYPE_ALNUM) {
			str = "3456789987654334567899876543";
		} else if (randomType == RANDOM_TYPE_ALPHA) {
			str = "abcdefghjkmnpqrstuvwxyYXWVUTSRQPNMKJHGFEDCBAyxwvutsrqpnmkjhgfedcbaABCDEFGHJKMNPQRSTUVWXY";
		} else {
			str = "yxwvutsrqpnmkjhgfedcba3456789ABCDEFGHJKMNPQRSTUVWXY99876543ABCDEFGHJKMNPQRSTUVWXYabcdefghjkmnpqrstuvwxy";
		}

		Random rnd = new Random();

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < len; i++) {
			int index = rnd.nextInt(str.length());
			sb.append(str.charAt(index));
		}

		return sb.toString();
	}

	public static String getUUID() {
		return UUID.randomUUID().toString();
	}

	public static boolean isBlank(final String str) {

		int length;
		if (str == null || (length = str.length()) == 0) {
			return true;
		}

		for (int i = 0; i < length; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return false;
			}
		}
		return true;

	}

	public static boolean hasLength(CharSequence str) {
		return (str != null && str.length() > 0);
	}

	public static boolean hasLength(String str) {
		return hasLength((CharSequence) str);
	}

	public static byte[] getUtf8Bytes(String str) {
		if (hasLength(str)) {
			try {
				return str.getBytes("UTF-8");
			} catch (UnsupportedEncodingException e) {
				;
			}
		}
		return null;
	}

	public static String getStringFromUtf8Bytes(byte[] tmpArray) {
		if (tmpArray != null && tmpArray.length > 0) {
			try {
				return new String(tmpArray, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				;
			}
		}
		return null;
	}

	public static boolean equals(String str1, String str2) {
		if (str1 == null && str2 == null) {
			return true;
		}

		if (str1 == null || str2 == null) {
			return false;
		}

		return str1.equals(str2);
	}

}
