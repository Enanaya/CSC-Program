package regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebSpider {
	public static String getUrlContent(String urls) {
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(urls);
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
			String str = "";
			while ((str = br.readLine()) != null) {
				sb.append(str + "\n");
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static ArrayList<String> getMathcerSubstrs(String desStr, String regexStr) {

		// Pattern p=Pattern.compile("<a[\\s\\S]+?</a>"); //取到的所有超链接内容
		// Pattern p=Pattern.compile("href=\"(.+?)\""); //取到的所有超链接地址
		Pattern p = Pattern.compile(regexStr); // 取到的所有超链接地址
		Matcher matcher = p.matcher(desStr);
		ArrayList<String> result = new ArrayList<String>();
		while (matcher.find()) {
			result.add(matcher.group(1));
		}
		return result;
	}

	public static void main(String[] args) {
		String desStr=getUrlContent("http://www.163.com");
		
		ArrayList<String> res= getMathcerSubstrs(desStr, "href=\"(http.+?)\"");
		for (String string : res) {
			System.out.println(string);
		}
	}
}
