package net.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetDemo01 {

	public static void main(String[] args) throws UnknownHostException {
		//根据getlocalhost创建inetaddress对象
		InetAddress add1=InetAddress.getLocalHost();
		System.out.println(add1.getHostAddress()); //host地址
		System.out.println(add1.getHostName());  //计算机名
		//根据域名得到inetaddress对象
		add1=InetAddress.getByName("www.163.com");
		System.out.println(add1.getHostAddress()); //返回163服务器的ip
		System.out.println(add1.getHostName()); //输出www.163.com
		
		//根据ip
		add1=InetAddress.getByName("203.130.59.30");
		System.out.println(add1.getHostAddress());
		System.out.println(add1.getHostName());
	}
}
