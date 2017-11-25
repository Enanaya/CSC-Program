package net.ip;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo01 {

	public static void main(String[] args) throws MalformedURLException {
		//绝对路径
		URL url=new URL("http://www.baidu.com:80/index.html#aa?uname=bjsxt");//#aa为锚点
		System.out.println("协议"+url.getProtocol());
		System.out.println("主机名"+url.getHost());
		System.out.println("端口"+url.getPort());
		System.out.println("资源"+url.getFile());
		System.out.println("相对路径的资源"+url.getPath());
		System.out.println("锚点"+url.getRef());
		System.out.println("参数"+url.getQuery()); //参数，存在锚点，返回null，不存在则返回正确
		
		
		
		url=new URL("http://www.baidu.com:80/a/");
		url=new URL(url,"b.txt");
		System.out.println(url.toString());
	}
}
