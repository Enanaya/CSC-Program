package utils;

/**
 * 封装字符串常用操作
 * @author 非洲
 *
 */
public class StringUtils {
	/**将目标首字母变为大写
	 * @param str 目标字符串
	 * @return 首字母变为大写的字符串
	 */
	public static String firstChar2UpperCase(String str) {
		///abcd-->Abcd
		//abcd-->ABCD-->A
		return str.toUpperCase().substring(0, 1)+str.substring(1);
	}
}
