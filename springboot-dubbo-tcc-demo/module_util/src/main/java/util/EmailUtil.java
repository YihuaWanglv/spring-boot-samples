/**  
 * Copyright © 2015广交会电子商务有限公司. All rights reserved.
 *
 * @Title: EmailUtil.java
 * @Prject: ec
 * @Package: com.cf.ec.util
 * @Description: TODO
 * @author: wanglvyh@cf-ec.com  
 * @date: 2015年6月24日 上午10:49:40
 * @version: V1.0  
 */
package util;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: EmailUtil
 * @Description: TODO
 * @author: wanglvyh@cf-ec.com
 * @date: 2015年6月24日 上午10:49:40
 */
public class EmailUtil {

	private static final String EMAIL_INDEX_PREFIX = "http://mail.";
	private static Map<String, String> mailMap = new HashMap<String, String>();
	static {
		mailMap.put("outlook.com", "//www.outlook.com");
		mailMap.put("gmail.com", "https://mail.google.com");
	}
	
//	public static void main(String[] args) {
//		getEmailIndexFromUserEmail("619361578@qq.com");
//	}
	
	/**
	 * 
	 * @Title: getEmailIndexFromUserEmail
	 * @Description: 获取用户邮箱的邮箱首页
	 * @param userEmail
	 * @return
	 */
	public static String getEmailIndexFromUserEmail(String userEmail) {
		String result = null;
		if (userEmail.indexOf("@") > -1) {
			String email = userEmail.substring(userEmail.indexOf("@")+1, userEmail.length());
			if (mailMap.containsKey(email)) {
				result = mailMap.get(email);
			} else {
				result = EMAIL_INDEX_PREFIX+email;				
			}
		}
		return result;
	}
}
