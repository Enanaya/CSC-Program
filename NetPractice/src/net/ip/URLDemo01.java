package net.ip;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo01 {

	public static void main(String[] args) throws MalformedURLException {
		//����·��
		URL url=new URL("http://www.baidu.com:80/index.html#aa?uname=bjsxt");//#aaΪê��
		System.out.println("Э��"+url.getProtocol());
		System.out.println("������"+url.getHost());
		System.out.println("�˿�"+url.getPort());
		System.out.println("��Դ"+url.getFile());
		System.out.println("���·������Դ"+url.getPath());
		System.out.println("ê��"+url.getRef());
		System.out.println("����"+url.getQuery()); //����������ê�㣬����null���������򷵻���ȷ
		
		
		
		url=new URL("http://www.baidu.com:80/a/");
		url=new URL(url,"b.txt");
		System.out.println(url.toString());
	}
}