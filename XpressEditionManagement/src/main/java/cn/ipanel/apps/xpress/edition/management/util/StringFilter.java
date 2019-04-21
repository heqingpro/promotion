package cn.ipanel.apps.xpress.edition.management.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFilter {

	// 正则表达式过滤特殊字符
	public static String replaceStrings(String str) {
		String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}

	// 正则表达式过滤特殊字符 英文单引号  ' 防止字符包含 ' 导致html页面 js函数失效
	public static String replaceString(String str) {
		String regEx = "'";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}

}
